package com.datacoper.maven.metadata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.datacoper.maven.enums.EnumDCAnnotation;
import com.datacoper.maven.enums.EnumDCModule;

public class TemplateAttributeModelTest {

	@Test
	public void deveResolverOTypeEPackage() {
		
		TemplateAttributeModel templateAttributeModel = new TemplateAttributeModel(null, "", "", String.class.getName(), EnumDCModule.BUSINESSCORE, "", EnumDCAnnotation.DCCONTEXTFIELD_EMPRESA, "", 0, 0, false, false);
		
		assertEquals("java.lang", templateAttributeModel.getTypePackage());
		assertEquals("String", templateAttributeModel.getTypeSimpleName());
		assertEquals("java.lang.String", templateAttributeModel.getType());
	}

}
