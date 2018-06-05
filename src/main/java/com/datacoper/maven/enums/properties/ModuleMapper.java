/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.properties;

/**
 *
 * @author alessandro.abegg
 */
public enum ModuleMapper {
    BUSINESS_CORE("businesscore", "nucleo");
    
    private final String to;
    private final String from;

    private ModuleMapper(String de, String para) {
        this.to = de;
        this.from = para;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }
    
    public static String from(String to) {
        for (ModuleMapper value : values()) {
            if (value.getTo().equalsIgnoreCase(to)) {
                return value.from;
            }
        }
        
        return to;
    }
}
