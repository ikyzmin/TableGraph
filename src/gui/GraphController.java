package gui;

import mvc.BaseModel;

import java.awt.*;

/**
 * Created by Илья on 02.05.2017.
 */
public class GraphController implements GraphContract.Controller {

    private GraphContract.Model model;

    public GraphController(GraphContract.Model model) {
        setModel(model);
    }

    @Override
    public void setModel(BaseModel baseModel) {
        model = (GraphContract.Model) baseModel;
        this.model.setController(this);
    }

    @Override
    public void addPoint(model.Point point) {
        model.addPoint(point);
    }

    @Override
    public void removePoint(int index) {
        model.removePoint(index);
    }

    @Override
    public void editPoint(int index, model.Point point) {
        model.editPoint(index, point);
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
