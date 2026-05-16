package edu.citytech.cst3613;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import edu.citytech.cst3613.service.CounterService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;

public class CounterController implements Initializable{

    @FXML
    private FlowPane fpNumbers;

    @FXML
    private Label lblCountBy;

    @FXML
    private TreeView<String> tvCounter;

    @FXML
    private ComboBox<String> cbStartsWith;

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        generateLabel(-5, 0);
        populateTreeView();
        treeViewNumberSelection();
    }

    public void generateLabel(int incrementBy, int startWith) {
        ObservableList<Node> children = fpNumbers.getChildren(); //newer version of java u can just declare as var, this style suspports all

        fpNumbers.getChildren().clear();
        String sNumbers = "";

        int i = 0, total = startWith;

        do {
            sNumbers = total + "";
            Label label = new Label(sNumbers);
            children.add(label);
            i++;
            total = total + incrementBy;

        } while ( i < 200);
    }

    
        private String commaFormat(int number) {
        String sNumber = number + "";
        double amount = Double.parseDouble(sNumber);
        DecimalFormat formatter = new DecimalFormat("#,###");
        return (formatter.format(amount));
    }

    private void treeViewNumberSelection() {
        var x = tvCounter.getSelectionModel().selectedItemProperty();

        x.addListener( (a, b, c ) -> {
            System.out.println( c.getValue() );

            int number = counterService.getNumberVersion(c.getValue());
            lblCountBy.setText( "Count by: " + c.getValue() + ": " + number);
            
            int startsWith = counterService.getNumberVersion(cbStartsWith.getValue());
            generateLabel(number, startsWith);
        });
    }


    CounterService counterService = new CounterService();

    private void populateTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Numbers");
        var children = rootItem.getChildren();
        rootItem.setExpanded(true);

        var numbers = counterService.getNumbers();

        for (CounterService.Digit digit : numbers) {
            TreeItem<String> item = new TreeItem<>(digit.description);
            children.add(item);
        }

        tvCounter.setRoot(rootItem);

    }


        @FXML
    void selectStartWith(ActionEvent event) {
        
        ComboBox<String> comboBox = (ComboBox<String>)event.getSource();
        int number = counterService.getNumberVersion(comboBox.getValue());
        System.out.println(comboBox.getValue() +" "+ number);

        
    }
}
