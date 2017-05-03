package gui;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import model.*;
import model.Point;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Илья on 02.05.2017.
 */
public class MainFrameFx extends JFrame {
    private TableView tableView;
    private GraphController controller;
    private GraphModel model;
    private ContextMenu contextMenu;
    private MenuItem deleteItem;
    final HBox hb = new HBox();
    final HBox mainBox = new HBox();

    public MainFrameFx() {
        this.setSize(1000, 560);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        final JFXPanel jfx = new JFXPanel();
        jfx.setSize(1000, 560);


        this.add(jfx);
        Platform.runLater(() -> {
            Group root = new Group();
            Scene scene = new Scene(root, 1000, 300);
            jfx.setScene(scene);
            tableView = new TableView();
            tableView.setController(controller);
            tableView.setEditable(true);
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("X");
            yAxis.setLabel("Y");

            final GraphView lineChart =
                    new GraphView(xAxis, yAxis);

            model = new GraphModel(tableView, lineChart);
            controller = new GraphController(model);
            model.setController(controller);
            //creating the chart
            final Label label = new Label("Function");
            label.setFont(new Font("Arial", 20));
            TableColumn<model.Point, Double> xCol = new TableColumn<>("X");
            TableColumn<model.Point, Double> yCol = new TableColumn<>("Y");

            xCol.setContextMenu(contextMenu);
            yCol.setContextMenu(contextMenu);
            tableView.setRowFactory(param -> {
                contextMenu = new ContextMenu();
                deleteItem = new MenuItem("Delete");
                contextMenu.getItems().addAll(deleteItem);
                deleteItem.setOnAction(event -> {
                    int index = tableView.getSelectionModel().getSelectedIndex();
                    controller.removePoint(index);
                });
                final TableRow<Point> row = new TableRow<>();
                row.contextMenuProperty().bind(
                        Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                .then(contextMenu)
                                .otherwise((ContextMenu) null));
                return row;
            });
            xCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleConverter()));
            yCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleConverter()));
            xCol.setCellValueFactory(new PropertyValueFactory<>("x"));
            yCol.setCellValueFactory(new PropertyValueFactory<>("y"));

            xCol.setOnEditCommit(event -> {
                model.Point point = event.getRowValue();
                point.setX(event.getNewValue());
                controller.editPoint(event.getTablePosition().getRow(), point);
            });
            yCol.setOnEditCommit(event -> {
                model.Point point = event.getRowValue();
                point.setY(event.getNewValue());
                controller.editPoint(event.getTablePosition().getRow(), point);

            });
            tableView.setItems(model.getObservableData());
            tableView.getColumns().addAll(xCol, yCol);

            final TextField addX = new TextField();
            addX.setPromptText("X");
            addX.setMaxWidth(xCol.getPrefWidth());
            final TextField addY = new TextField();
            addY.setMaxWidth(yCol.getPrefWidth());
            addY.setPromptText("Y");

            final javafx.scene.control.Button addButton = new javafx.scene.control.Button("Add");
            addButton.setOnAction(e -> {
                controller.addPoint(new model.Point(Double.valueOf(addX.getText()), Double.valueOf(addY.getText())));
                addX.clear();
                addY.clear();
            });

            hb.getChildren().addAll(addX, addY, addButton);
            hb.setSpacing(3);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, tableView, hb);
            mainBox.getChildren().addAll(vbox, lineChart);
            ((Group) scene.getRoot()).getChildren().addAll(mainBox);
        });
    }
}
