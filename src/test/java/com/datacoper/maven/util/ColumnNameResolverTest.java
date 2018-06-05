package com.datacoper.maven.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColumnNameResolverTest {

	private ColumnNameResolver columnNameResolver = new ColumnNameResolver();
	
	@Test
	public void testRevolverAsFieldWithSingleField() {
	
		assertEquals("id", columnNameResolver.revolverAsField("ID"));
		assertEquals("idUsuario", columnNameResolver.revolverAsField("IDUSUARIO"));
	
	}

	@Test
	public void testRevolverAsFieldWithMultiplesField() {
	
		assertEquals("id", columnNameResolver.revolverAsField("ID"));
		assertEquals("codigo", columnNameResolver.revolverAsField("CODIGO"));
		assertEquals("idUsuarioFilial", columnNameResolver.revolverAsField("IDUSUARIOFILIAL"));
		assertEquals("codigoParceiro", columnNameResolver.revolverAsField("CODIGOPARCEIRO"));
		assertEquals("dataCadastro", columnNameResolver.revolverAsField("DATACADASTRO"));
		assertEquals("inicioVigencia", columnNameResolver.revolverAsField("INICIOVIGENCIA"));
		assertEquals("fimVigencia", columnNameResolver.revolverAsField("FIMVIGENCIA"));
		assertEquals("idDocumentoFaturamento", columnNameResolver.revolverAsField("IDDOCUMENTOFATURAMENTO"));
	
	}
	
}
