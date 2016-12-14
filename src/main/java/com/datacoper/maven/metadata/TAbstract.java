/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.metadata;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.generators.SourceType;

/**
 *
 * @author alessandro
 */
public interface TAbstract {
    public String getPackage();
    
    public String getClassName();
    
    public CompanyOptions getCompany();
    
    public String getModuleBasic();
    
    public SourceType getSourceType();
}
