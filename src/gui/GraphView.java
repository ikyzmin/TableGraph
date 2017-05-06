package gui;

import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import mvc.BaseModel;


public class GraphView extends LineChart<Number, Number> implements GraphContract.View {

    GraphContract.Model model;

    public GraphView(Axis<Number> integerAxis, Axis<Number> integerAxis2) {
        super(integerAxis, integerAxis2);
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
    public void update() {
        XYChart.Series series = new XYChart.Series();
        series.setName("y=sin(x)");
        getData().clear();
        for (model.Point point : model.getObservableData()) {
            series.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
        }
        getData().addAll(series);
    }
}
