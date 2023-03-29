package utils;

import java.util.Arrays;
import java.util.List;

public class HexConverter {

    public static String rgbaToHex(String rgba) {

        //Replace everything that is not a positive number with space, using regex
        rgba = rgba.replaceAll("[^?0-9]+"," ");
        //Create a list containing the remaining positive numbers and trim it
        List<String> rgbaValues = Arrays.asList(rgba.trim().split(" "));
        //Assign value from each index to their respective variable (r,g,b,a)
        int r = Integer.parseInt(rgbaValues.get(0));
        int g = Integer.parseInt(rgbaValues.get(1));
        int b = Integer.parseInt(rgbaValues.get(2));
        int a = Integer.parseInt(rgbaValues.get(3));
        //Convert rgba values to hex string
        return String.format("#%02x%02x%02x", r, g, b, a);
    }
}
