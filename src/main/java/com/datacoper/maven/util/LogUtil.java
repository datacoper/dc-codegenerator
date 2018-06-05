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
        if(log != null) {
        	log.info(message);
        }else {
    		System.out.println(message);
        }
    	
    }
    
    public static void info(Throwable throwable) {
    	if(log != null) {
    		log.info(throwable);
    	}else {
    		System.out.println(throwable.getMessage());
    	}
    }
    
<<<<<<< HEAD
    public static void error(String message, Object... params) {
        error(StringUtil.format(message, params));
    }
    
    public static void error(String message) {
    	if(log != null) {
    		log.error(message);
    	}
    }
    
    public static void error(Throwable throwable) {
    	if(log != null) {
    		log.error(throwable);
    	}else {
    		System.out.println(throwable.getMessage());
    	}
=======
    public static void error(Throwable throwable) {
        if(throwable.getMessage() != null){
            log.error(throwable.getMessage());            
        }else{
            log.error(throwable);
        }
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    }
    
    public static void warn(String message, Object... params) {
        warn(StringUtil.format(message, params));
    }
    
    public static void warn(String message) {
    	if(log != null) {
    		log.warn(message);
    	}else {
    		System.out.println(message);
    	}
    }
    
    public static void warn(Throwable throwable) {
    	if(log != null) {
    		log.warn(throwable);
    	}else {
    		System.out.println(throwable.getMessage());
    	}
    }
}
