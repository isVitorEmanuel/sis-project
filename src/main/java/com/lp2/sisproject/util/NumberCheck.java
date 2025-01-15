package com.lp2.sisproject.util;

public class NumberCheck {
    public static boolean isInt(String str) {
        try {
            Integer integer = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double dbl = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
