/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;


/**
 *
 * @author alessandro
 */
public class Converters {
    public static String toString(String value) {
        return value;
    }
    
    public static Class<?> toClass(String value) {
        if (!value.contains(".")) {
            try {
                return ClassUtil.forName("java.lang.".concat(value));
            } catch (Throwable t) { }
        }
        
        return ClassLoaderUtil.loadClass(value);
    }
}
