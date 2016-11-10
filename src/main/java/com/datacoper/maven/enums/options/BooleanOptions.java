/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.options;

/**
 *
 * @author alessandro
 */
public enum BooleanOptions implements IOptions {
    TRUE(0, 1, "True"),
    FALSE(1, 2, "False");
    
    private int id;
    
    private int code;
    
    private String description;

    private BooleanOptions(int id, int codigo, String description) {
        this.id = id;
        this.code = codigo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public BooleanOptions of(String boo) {
        for (BooleanOptions value : BooleanOptions.values()) {
            if (value.getDescription().equalsIgnoreCase(boo)) {
                return value;
            }
        }
        
        return FALSE;
    }
    
    public static BooleanOptions of(int boo) {
        for (BooleanOptions value : BooleanOptions.values()) {
            if (value.getCode() == boo) {
                return value;
            }
        }
        
        return FALSE;
    }
    
    @Override
    public String print() {
        StringBuilder toString = new StringBuilder();
        
        for (BooleanOptions value : BooleanOptions.values()) {
            toString.append(value.getCode())
                    .append(" - ")
                    .append(value.getDescription())
                    .append("\n");
        }
        
        return toString.append("\n").toString();
    }
}
