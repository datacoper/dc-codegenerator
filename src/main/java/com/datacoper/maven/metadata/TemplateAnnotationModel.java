package com.datacoper.maven.metadata;

import java.util.Map;

public class TemplateAnnotationModel {
    
    private final String annotation;
    
    private final Map<String, String> params;

    public TemplateAnnotationModel(String annotation, Map<String, String> params) {
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
