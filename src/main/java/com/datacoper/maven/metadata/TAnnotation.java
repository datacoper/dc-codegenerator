/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.metadata;

import java.util.Map;

/**
 *
 * @author alessandro
 */
public class TAnnotation {
    
    private final String annotation;
    
    private final Map<String, String> params;

    public TAnnotation(String annotation, Map<String, String> params) {
        this.annotation = annotation;
        this.params = params;
    }

    public String getAnnotation() {
        return annotation;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
