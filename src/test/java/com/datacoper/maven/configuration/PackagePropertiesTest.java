package com.datacoper.maven.configuration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.datacoper.maven.enums.options.CompanyOptions;

public class PackagePropertiesTest {

	private PackageProperties packageProperties = new PackageProperties(CompanyOptions.DATACOPER, "agricola", "teste");
	
	@Test
	public void deveSubstituirValorDePropriedadesExternas() {
		String value = packageProperties.getValue("default.basedir");
		
		assertEquals("com.datacoper.cooperate.agricola", value);
	}
	
	@Test
	public void deveSubstituirValorDePropriedadesInternas() {
		String value = packageProperties.getValue("default.restcommon.dto");
		assertEquals("com.datacoper.cooperate.rest.common.dto", value);
		
		value = packageProperties.getValue("default.restapi.resource");
		assertEquals("com.datacoper.cooperate.rest.resources.impl", value);
	}
}