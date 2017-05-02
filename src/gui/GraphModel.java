package gui;

import mvc.BaseController;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Илья on 02.05.2017.
 */
public class GraphModel implements GraphContract.Model {

    ArrayList<Point> data;
    GraphContract.Controller controller;

    public GraphModel() {
        data = new ArrayList<>();
    }

    @Override
    public void setController(GraphContract.Controller baseController) {
        this.controller = controller;
    }

    @Override
    public void addPoint(Point point) {
        data.add(point);
        controller.onPointAdd(data.indexOf(point));
    }

    @Override
    public void removePoint(int index) {
        data.remove(index);
        controller.onPointRemove(index);
    }

    @Override
    public void editPoint(int index, Point point) {
        data.remove(index);
        data.add(index,point);
        controller.onPointEdit(index);
    }

}
