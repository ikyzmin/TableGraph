package gui;

import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import mvc.BaseModel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Илья on 03.05.2017.
 */
public class GraphView extends LineChart<Number, Number> implements GraphContract.View {

    GraphContract.Model model;

    public GraphView(Axis<Number> integerAxis, Axis<Number> integerAxis2) {
        super(integerAxis, integerAxis2);
    }

    public GraphView(Axis<Number> integerAxis, Axis<Number> integerAxis2, ObservableList<Series<Number, Number>> data) {
        super(integerAxis, integerAxis2, data);
    }

    @Override
    public void setController(GraphContract.Controller baseController) {
        //stub
    }

    @Override
    public void setModel(BaseModel model) {
        this.model = (GraphContract.Model) model;
        update();
    }

    @Override
    public void show() {

    }

    @Override
    public void update() {
        XYChart.Series series = new XYChart.Series();
        series.setName("Graph");
        getData().clear();
        for (model.Point point : model.getObservableData()) {
            series.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
        }
        getData().addAll(series);
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
