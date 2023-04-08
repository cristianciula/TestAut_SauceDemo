package utils;

import java.text.DecimalFormat;

public class TextModifiers {

    public static String twoDecimalsFormatter(double value) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(value);
    }

    public static String getText(String text) {
        return text;
    }
}
