package gui;

import mvc.BaseController;
import mvc.BaseModel;

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
    public void update() {
        setItems(model.getObservableData());
    }

}
