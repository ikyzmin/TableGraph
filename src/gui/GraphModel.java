package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Point;

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
        data.add(new Point(-13d,Math.sin(-13)));
        data.add(new Point(-12d,Math.sin(-12)));
        data.add(new Point(-11d,Math.sin(-11)));
        data.add(new Point(-10d,Math.sin(-10)));
        data.add(new Point(-9d,Math.sin(-9)));
        data.add(new Point(-8d,Math.sin(-8)));
        data.add(new Point(-7d,Math.sin(-7)));
        data.add(new Point(-6d,Math.sin(-6)));
        data.add(new Point(-5d,Math.sin(-5)));
        data.add(new Point(-4d,Math.sin(-4)));
        data.add(new Point(-3d,Math.sin(-3)));
        data.add(new Point(-2d,Math.sin(-2)));
        data.add(new Point(-1d,Math.sin(-1)));
        data.add(new Point(0d,Math.sin(0)));
        data.add(new Point(1d,Math.sin(1)));
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
        point.setY(Math.sin(point.getX()));
        data.add(index, point);
        controller.onPointEdit(index);
        updateViews();
    }

    public ObservableList getObservableData() {
        return FXCollections.observableArrayList(data);
    }

}
