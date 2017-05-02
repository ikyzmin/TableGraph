package gui;

import mvc.BaseModel;

import java.awt.*;

/**
 * Created by Илья on 02.05.2017.
 */
public class GraphController implements GraphContract.Controller {

    private GraphContract.Model baseModel;

    public GraphController(GraphContract.Model model) {
        baseModel = model;
    }

    @Override
    public void setModel(BaseModel baseModel) {

    }

    @Override
    public void addPoint(Point point) {

    }

    @Override
    public void removePoint(int index) {

    }

    @Override
    public void editPoint(int index, Point point) {

    }

    @Override
    public void onPointRemove(int index) {

    }

    @Override
    public void onPointEdit(int index) {

    }

    @Override
    public void onPointAdd(int index) {

    }

}
