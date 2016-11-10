/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

/**
 *
 * @author aline.cardoso
 */
public abstract class SystemUtil {
    private SystemUtil() { }
    
    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }
}
