package gui;

import mvc.BaseController;
import mvc.BaseModel;
import mvc.BaseView;

import java.awt.*;

/**
 * Created by Илья on 02.05.2017.
 */
public interface GraphContract {

    interface View extends BaseView<Controller> {

        void show();

        void update();

        void addPoint(Point point);

        void removePoint(int index);

        void editPoint(int index, Point point);
    }

    interface Controller extends BaseController {

        void addPoint(Point point);

        void removePoint(int index);

        void editPoint(int index, Point point);

        void onPointRemove(int index);

        void onPointEdit(int index);

        void onPointAdd(int index);
    }

    interface Model extends BaseModel<Controller> {
        void addPoint(Point point);

        void removePoint(int index);

        void editPoint(int index, Point point);
    }
}
