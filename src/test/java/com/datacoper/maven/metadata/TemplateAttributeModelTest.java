package com.datacoper.maven.metadata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TemplateAttributeModelTest {

	@Test
	public void deveResolverOTypeEPackage() {
		
		TemplateAttributeModel templateAttributeModel = new TemplateAttributeModel("", String.class.getName(), "", "", 0, 0, false, false);
		
		assertEquals("java.lang", templateAttributeModel.getTypePackage());
		assertEquals("String", templateAttributeModel.getTypeSimpleName());
		assertEquals("java.lang.String", templateAttributeModel.getType());
	}

}
