package gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.swing.*;

/**
 * Created by Илья on 02.05.2017.
 */
public class MainFrameFx extends JFrame {
    private TableView tableView;
    private GraphController controller;
    private GraphModel model;

    public MainFrameFx() {
        this.setSize(600, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        final JFXPanel jfx = new JFXPanel();
        jfx.setSize(560, 500);

        model = new GraphModel();
        controller = new GraphController(model);
        model.setController(controller);
        tableView.setController(controller);

        this.add(jfx);
        Platform.runLater(() -> {
            Group root = new Group();
            Scene scene = new Scene(root, 400, 300);
            jfx.setScene(scene);
            tableView = new TableView();
            final Label label = new Label("Function");
            label.setFont(new Font("Arial", 20));
            TableColumn xCol = new TableColumn("X");
            TableColumn yCol = new TableColumn("Y");

            tableView.getColumns().addAll(xCol, yCol);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, tableView);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);
        });
    }
}
