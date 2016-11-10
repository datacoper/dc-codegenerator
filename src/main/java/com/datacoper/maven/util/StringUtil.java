package com.datacoper.maven.util;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StringUtil {

    public static final String PROPERTY_SEPARATOR = ",";

    public static final String ATTRIBUTE_SEPARATOR = ":";
    
    public static final boolean EXTRA_COMPLETE_RIGHT = true;
    
    public static final boolean EXTRA_COMPLETE_LEFT = false;

    public static final String REGEX_CAMEL_CASE = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";

    private StringUtil() {
    }

    public static String upperFirstCharacter(String value) {
        if (isNullOrEmpty(value)) {
            return value;
        }

        char charUpper = Character.toUpperCase(value.charAt(0));

        return charUpper + value.substring(1, value.length());
    }

    public static String getLastString(String value, String separator) {
        if (value != null && value.contains(".")) {
            return value.substring(value.lastIndexOf(".") + 1, value.length());
        }

        return null;
    }

    public static String format(String str, Object... name) {
        return MessageFormat.format(str, name);
    }

    public static List<String> separateProperties(String str) {
        return separate(str, PROPERTY_SEPARATOR);
    }

    public static List<String> separateAttributes(String str) {
        return separate(str, ATTRIBUTE_SEPARATOR);
    }

    public static List<String> separate(String str, String separator) {
        if (str == null || !str.contains(separator)) {
            return Arrays.asList();
        }

        return Arrays.asList(str.split(separator))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static boolean isNotNullOrEmpty(String superClass) {
        return !isNullOrEmpty(superClass);
    }

    public static boolean isNullOrEmpty(String superClass) {
        return superClass == null || superClass.isEmpty();
    }

    public static String convertToCamelCase(String text) {
        String[] parts = text.split(REGEX_CAMEL_CASE);

        StringBuilder retorno = new StringBuilder();
        for (String part : parts) {
            retorno.append(part).append("_");
        }

        return retorno.toString();
    }

    public static String completeWith(String str, int maxCharacterInString, String complete) {
        return completeWith(str, maxCharacterInString, 0, complete);
    }
    
    public static String completeWith(String str, int maxCharacterInString, int blankSpace, String complete) {
        return completeWith(str, maxCharacterInString, blankSpace, complete, EXTRA_COMPLETE_LEFT);
    }
    
    public static String completeWith(String str, int maxCharacterInString, int blankSpace, String complete, boolean extraCompleteRigth) {
        maxCharacterInString = maxCharacterInString - (blankSpace * 2);
                
        if (str.length() > maxCharacterInString) {
            str = str.substring(0, maxCharacterInString);
        }
        
        for (int i = 0; i < blankSpace; i++) {
            str = " ".concat(str).concat(" ");
        }

        int qtdComplete = maxCharacterInString - str.length();

        if (qtdComplete > 0) {
            for (int i = 0; i < qtdComplete; i++) {
                str = complete.concat(str).concat(complete);
            }
        }
        
        if (qtdComplete % 2 != 0) {
            str = extraCompleteRigth ? str.concat(complete) : complete.concat(str);
        }

        return str;
    }
    
    public static boolean isTerminateWith(String str, String terminate) {
        return isTerminateWith(str, terminate, false);
    }
    
    public static boolean isIgnoteCaseTerminateWith(String str, String terminate) {
        return isTerminateWith(str, terminate, true);
    }
    
    public static boolean isTerminateWith(String str, String terminate, boolean ignoreCase) {
        if (isNullOrEmpty(str) || isNullOrEmpty(terminate)) return false;
        
        int strSize = str.length();
        int size = terminate.length();
        
        if (strSize < size) return false;
        
        String extractFinish = str.substring(strSize - size, strSize);
        
        return ignoreCase ? extractFinish.equalsIgnoreCase(terminate) : extractFinish.equals(terminate);
    }
}