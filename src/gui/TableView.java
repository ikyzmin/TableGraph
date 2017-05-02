package gui;

import mvc.BaseController;
import mvc.BaseView;

import java.awt.*;

/**
 * Created by Илья on 02.05.2017.
 */
public class TableView extends javafx.scene.control.TableView implements GraphContract.View {

    BaseController controller;

    @Override
    public void setController(GraphContract.Controller baseController) {
        this.controller = controller;
    }

    @Override
    public void show() {

    }

    @Override
    public void update() {

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
}
