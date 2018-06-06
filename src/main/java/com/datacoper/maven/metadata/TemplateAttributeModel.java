package com.datacoper.maven.metadata;

public class TemplateAttributeModel {

	private String type;

	private String name;
	
	private String label;
	
	public TemplateAttributeModel(String name, String type, String label) {
		this.type = type;
		this.name = name;
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}
	
}
