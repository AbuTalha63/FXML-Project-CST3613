package edu.citytech.cst3613;

import java.net.URL;
import java.util.ResourceBundle;

import edu.citytech.cst3613.service.CounterService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    @Override
    public void initialize(URL url, ResourceBundle resource) {
        
        ObservableList<Node> children = fpNumbers.getChildren(); //newer version of java u can just declare as var, thi suspports all

        for (int i = 0; i < 200; i++) {
            Label label = new Label(i + "");
            children.add(label);
        }

        populateTreeView();
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
}
