package com.datacoper.maven.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColumnNameResolverTest {

	private ColumnNameResolver columnNameResolver = new ColumnNameResolver();
	
	@Test
	public void testRevolverAsFieldWithMultiplesField() {
	
		assertEquals("id", columnNameResolver.revolverFieldAndLabel("ID").getKey());
		assertEquals("codigo", columnNameResolver.revolverFieldAndLabel("CODIGO").getKey());
		assertEquals("idUsuarioFilial", columnNameResolver.revolverFieldAndLabel("IDUSUARIOFILIAL").getKey());
		assertEquals("codigoParceiro", columnNameResolver.revolverFieldAndLabel("CODIGOPARCEIRO").getKey());
		assertEquals("dataCadastro", columnNameResolver.revolverFieldAndLabel("DATACADASTRO").getKey());
		assertEquals("inicioVigencia", columnNameResolver.revolverFieldAndLabel("INICIOVIGENCIA").getKey());
		assertEquals("fimVigencia", columnNameResolver.revolverFieldAndLabel("FIMVIGENCIA").getKey());
		assertEquals("idDocumentoFaturamento", columnNameResolver.revolverFieldAndLabel("IDDOCUMENTOFATURAMENTO").getKey());
		assertEquals("idGrupoEmpresarial", columnNameResolver.revolverFieldAndLabel("IDGRUPOEMPRESARIAL").getKey());
	
	}
	
	@Test
	public void testRevolverAsLabelWithMultiplesField() {
	
		assertEquals("Código", columnNameResolver.revolverFieldAndLabel("CODIGO").getValue());
		assertEquals("Id Usuário Filial", columnNameResolver.revolverFieldAndLabel("IDUSUARIOFILIAL").getValue());
		assertEquals("Código Parceiro", columnNameResolver.revolverFieldAndLabel("CODIGOPARCEIRO").getValue());
		assertEquals("Data Cadastro", columnNameResolver.revolverFieldAndLabel("DATACADASTRO").getValue());
		assertEquals("Início Vigência", columnNameResolver.revolverFieldAndLabel("INICIOVIGENCIA").getValue());
		assertEquals("Id Documento Faturamento", columnNameResolver.revolverFieldAndLabel("IDDOCUMENTOFATURAMENTO").getValue());
	
	}
	
}
