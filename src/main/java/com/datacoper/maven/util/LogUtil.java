/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import org.apache.maven.plugin.logging.Log;

/**
 *
 * @author alessandro
 */
public abstract class LogUtil {
    private static Log log;
    
    private LogUtil() { }
    
    public static void setLog(Log log) {
        LogUtil.log = log;
    }
    
    public static void info(String message, Object... params) {
        info(StringUtil.format(message, params));
    }
    
    public static void info(String message) {
        log.info(message);
    }
    
    public static void info(Throwable throwable) {
        log.info(throwable);
    }
    
    public static void error(Throwable throwable) {
        if(throwable.getMessage() != null){
            log.error(throwable.getMessage());            
        }else{
            log.error(throwable);
        }
    }
    
    public static void warn(String message, Object... params) {
        warn(StringUtil.format(message, params));
    }
    
    public static void warn(String message) {
        log.warn(message);
    }
    
    public static void warn(Throwable throwable) {
        log.warn(throwable);
    }
}
