/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.options;

import java.util.Optional;

/**
 *
 * @author alessandro
 */
public enum CompanyOptions implements IOptions {
    DATACOPER(1, "Datacoper", "datacoper", Optional.empty()),
    ALFA(2, "Agricola Cooperalfa" , "cooperalfa", Optional.of("Cooperalfa"));
    
    private final int code;
    
    private final String name;
    
    private final String packag;
    
    private final Optional<String> projectIdentifier;

    private CompanyOptions(int codigo, String descricao, String packag, Optional<String> projectIdentifier) {
        this.code = codigo;
        this.name = descricao;
        this.packag = packag;
        this.projectIdentifier = projectIdentifier;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPackag() {
        return packag;
    }

    public Optional<String> getProjectIdentifier() {
        return projectIdentifier;
    }

    @Override
    public String print() {
        StringBuilder toString = new StringBuilder();
        
        for (CompanyOptions value : CompanyOptions.values()) {
            toString.append(value.getCode())
                    .append(" - ")
                    .append(value.getName())
                    .append("\n");
        }
        
        return toString.append("\n").toString();
    }

    @Override
    public CompanyOptions of(String boo) {
        for (CompanyOptions value : CompanyOptions.values()) {
            if (String.valueOf(value.getCode()).equalsIgnoreCase(boo)) {
                return value;
            }
        }
        
        return DATACOPER;
    }
    
    public static CompanyOptions of(int boo) {
        for (CompanyOptions value : CompanyOptions.values()) {
            if (value.getCode() == boo) {
                return value;
            }
        }
        
        return DATACOPER;
    }
    
    public static CompanyOptions ofProjectName(String projectName) {
        for (CompanyOptions value : CompanyOptions.values()) {
            if (value.getProjectIdentifier().isPresent() && projectName.contains(value.getProjectIdentifier().get())) {
                return value;
            }
        }
        
        return DATACOPER;
    }
}
