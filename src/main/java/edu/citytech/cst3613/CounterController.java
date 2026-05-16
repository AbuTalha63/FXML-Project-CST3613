package edu.citytech.cst3613;

import java.net.URL;
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
import javafx.scene.control.ComboBox;

public class CounterController implements Initializable{

    @FXML
    private FlowPane fpNumbers;

    @FXML
    private Label lblCountBy;

    @FXML
    private TreeView<String> tvCounter;

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        generateLabels(-5);
        populateTreeView();
        treeViewNumberSelection();

    }

    public void generateLabels(int startNumber) {
        ObservableList<Node> children = fpNumbers.getChildren(); //newer version of java u can just declare as var, thi suspports all

        fpNumbers.getChildren().clear();

        for (int i = 0 ; i < 200; i++) {
            Label label = new Label(i * startNumber + "");
            children.add(label);
        }
    }

    private void treeViewNumberSelection() {
        var x = tvCounter.getSelectionModel().selectedItemProperty();

        x.addListener( (a, b, c ) -> {
            System.out.println( c.getValue() );

            int number = counterservice.getNumberVersion(c.getValue());
            lblCountBy.setText( "Count by: " + c.getValue() + ": " + number);
            
            generateLabels(number);
        });
    }


    CounterService counterservice = new CounterService();

    private void populateTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Numbers");
        var children = rootItem.getChildren();
        rootItem.setExpanded(true);

        var numbers = counterservice.getNumbers();

        for (CounterService.Digit digit : numbers) {
            TreeItem<String> item = new TreeItem<>(digit.description);
            children.add(item);
        }

        tvCounter.setRoot(rootItem);

    }


        @FXML
    void selectStartWith(ActionEvent event) {
        
        ComboBox<String> comboBox = (ComboBox<String>)event.getSource(); 
        System.out.println(comboBox.getValue());

        
    }
}
