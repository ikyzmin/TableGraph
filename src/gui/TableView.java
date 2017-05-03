package gui;

import model.*;
import mvc.BaseController;
import mvc.BaseModel;
import mvc.BaseView;

import java.awt.*;
import java.awt.Point;

/**
 * Created by Илья on 02.05.2017.
 */
public class TableView extends javafx.scene.control.TableView<model.Point> implements GraphContract.View {

    BaseController controller;
    GraphContract.Model model;

    @Override
    public void setController(GraphContract.Controller baseController) {
        this.controller = controller;
    }

    @Override
    public void setModel(BaseModel model) {
        this.model = (GraphContract.Model) model;
    }

    @Override
    public void show() {

    }

    @Override
    public void update() {
        setItems(model.getObservableData());
    }

    @Override
    public void addPoint(model.Point point) {

    }

    @Override
    public void removePoint(int index) {

    }

    @Override
    public void editPoint(int index, model.Point point) {

    }
}
