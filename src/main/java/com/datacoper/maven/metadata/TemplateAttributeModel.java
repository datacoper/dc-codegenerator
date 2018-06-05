package com.datacoper.maven.metadata;

import com.datacoper.maven.enums.options.ModifierOptions;

public class TemplateAttributeModel {

	private String importt;

	private ModifierOptions encapsulation = ModifierOptions.PRIVATE;

	private boolean staticAttribute;

	private boolean finalAttribute;

	private String name;

	private boolean generateGet;

	private boolean generateSet;

	public String getImportt() {
		return importt;
	}

	public void setImportt(String importt) {
		this.importt = importt;
	}

	public ModifierOptions getEncapsulation() {
		return encapsulation;
	}

	public void setEncapsulation(ModifierOptions encapsulation) {
		this.encapsulation = encapsulation;
	}

	public boolean isStaticAttribute() {
		return staticAttribute;
	}

	public void setStaticAttribute(boolean staticAttribute) {
		this.staticAttribute = staticAttribute;
	}

	public boolean isFinalAttribute() {
		return finalAttribute;
	}

	public void setFinalAttribute(boolean finalAttribute) {
		this.finalAttribute = finalAttribute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGenerateGet() {
		return generateGet;
	}

	public void setGenerateGet(boolean generateGet) {
		this.generateGet = generateGet;
	}

	public boolean isGenerateSet() {
		return generateSet;
	}

	public void setGenerateSet(boolean generateSet) {
		this.generateSet = generateSet;
	}
}
