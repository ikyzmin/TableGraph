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

    private ArrayList<Point> data;
    private GraphContract.Controller controller;
    private GraphContract.View[] views;


    public GraphModel(GraphContract.View... views) {
        data = new ArrayList<>();
        data.add(new Point(1, 1));

        data.add(new Point(10, 10));

        data.add(new Point(15, 15));

        data.add(new Point(20, 20));

        data.add(new Point(13, 31));

        data.add(new Point(61, 51));

        data.add(new Point(41, 51));

        data.add(new Point(61, 71));

        data.add(new Point(81, 19));

        data.add(new Point(14, 51));
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
    public void addPoint(Point point) {
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
    }

    @Override
    public void editPoint(int index, Point point) {
        data.remove(index);
        data.add(index, point);
        controller.onPointEdit(index);
    }

    public ObservableList getObservableData() {
        return FXCollections.observableArrayList(data);
    }

}
