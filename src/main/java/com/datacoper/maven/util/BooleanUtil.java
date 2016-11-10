package com.datacoper.maven.util;

public abstract class BooleanUtil {

    public static boolean toBoolean(String value) {
        try {
            return toBoolean(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            return "true".equals(value.toLowerCase());
        }
    }

    public static boolean toBoolean(int value) {
        return value == 1;
    }

    public static String toString(boolean value) {
        return value ? "true" : "false";
    }

    public static int toInt(boolean value) {
        return value ? 1 : 0;
    }
}
