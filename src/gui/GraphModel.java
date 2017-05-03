package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mvc.BaseController;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Илья on 02.05.2017.
 */
public class GraphModel implements GraphContract.Model {

    private ArrayList<model.Point> data;
    private GraphContract.Controller controller;
    private GraphContract.View[] views;


    public GraphModel(GraphContract.View... views) {
        data = new ArrayList<>();
        this.views = views;
        for (GraphContract.View view : views) {
            view.setModel(this);
        }
    }

    @Override
    public void setController(GraphContract.Controller baseController) {
        this.controller = baseController;
    }

    @Override
    public void addPoint(model.Point point) {
        data.add(point);
        controller.onPointAdd(data.indexOf(point));
        updateViews();
    }

    private void updateViews(){
        for (GraphContract.View view : views) {
            view.update();
        }
    }

    @Override
    public void removePoint(int index) {
        data.remove(index);
        controller.onPointRemove(index);
        updateViews();
    }

    @Override
    public void editPoint(int index, model.Point point) {
        data.remove(index);
        data.add(index, point);
        controller.onPointEdit(index);
        updateViews();
    }

    public ObservableList getObservableData() {
        return FXCollections.observableArrayList(data);
    }

}
