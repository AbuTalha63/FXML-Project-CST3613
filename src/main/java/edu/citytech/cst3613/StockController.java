package edu.citytech.cst3613;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;

import edu.citytech.cst3613.dto.Stock;
import edu.citytech.cst3613.service.CounterService;
import edu.citytech.cst3613.service.StockService;
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

public class StockController implements Initializable{

    @FXML
    private FlowPane fpNumbers;

    @FXML
    private Label lblCountBy;

    @FXML
    private TreeView<String> tvCounter;

    @FXML
    private ComboBox<String> cbStartsWith;

    private StockService stockService = new StockService();

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        cbStartsWith.getItems().clear();        
        generateLabel("all");
        populateTreeView();
        treeViewNumberSelection();
    }

    public void generateLabel(String query) {
        ObservableList<Node> children = fpNumbers.getChildren(); //newer version of java u can just declare as var, this style suspports all

        fpNumbers.getChildren().clear();

        List<Stock> list = stockService.getStocks(query);

        for (Stock stock : list) {
            Label label = new Label(stock.symbol + " | " + commaFormat(stock.marketCapInBillions) + 
            " | " + commaFormat(stock.divYield * 100) + "%");
            children.add(label);
        }

    }

        private String commaFormat(double number) {
        String sNumber = number + "";
        double amount = Double.parseDouble(sNumber);
        DecimalFormat formatter = new DecimalFormat("#,#00.000");
        return (formatter.format(amount));
    }

    private void treeViewNumberSelection() {

        var x = tvCounter.getSelectionModel().selectedItemProperty();
        x.addListener( (a, b, c ) -> {

            System.out.println("Count by: " + c.getValue() + ": ");
            String queryData = c.getValue().split(" ")[0];
            generateLabel(queryData);

        });
    }


    CounterService counterService = new CounterService();

    private void populateTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("All");
        var children = rootItem.getChildren();
        rootItem.setExpanded(true);

        var numbers = CounterService.ABC();
        var mapping = stockService.getMapping();

        for (Character digit : numbers) {

            if (mapping.containsKey(digit)){

            int count = mapping.get(digit);

            TreeItem<String> item = new TreeItem<>(digit + " " + count);
            //cbStartsWith.getItems().add(digit.description);
            children.add(item);
        }
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