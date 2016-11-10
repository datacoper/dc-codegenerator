/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import java.util.Scanner;
import static java.lang.System.out;

/**
 *
 * @author alessandro
 */
public abstract class ConsoleUtil {

    private ConsoleUtil() { }
    
    private static final Scanner in = new Scanner(System.in);

    public static String question() {
        return in.next();
    }

    public static void sysOutl(String message, Object... params) {
        sysOut("\n".concat(message), params);
    }
    
    public static void sysOut(String message, Object... params) {
        message = StringUtil.format(message, params);
        
        out.print(message);
    }
    
    public static String question(String message, Object... params) {
        sysOut(message, params);
        return in.nextLine();
    }
}
