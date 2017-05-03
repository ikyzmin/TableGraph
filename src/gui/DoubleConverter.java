package gui;

import javafx.util.StringConverter;

/**
 * Created by Илья on 03.05.2017.
 */
public class DoubleConverter extends StringConverter<Double> {
    @Override
    public String toString(Double object) {
        return Double.toString(object);
    }

    @Override
    public Double fromString(String string) {
        return Double.valueOf(string);
    }
}
