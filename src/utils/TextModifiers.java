package utils;

import java.text.DecimalFormat;

public class TextModifiers {

    public static String decimalsFormatter(double value) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return decimalFormat.format(value);
    }
}
