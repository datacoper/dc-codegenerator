package com.datacoper.maven.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class ColumnNameResolver {

	private Set<String> dictionary = new HashSet<>();
	
	public ColumnNameResolver() {
		add("id");
		add("usuario");
		add("filial");
		add("data");
		add("inicio");
		add("fim");
		add("vigencia");
		add("codigo");
		add("documento");
		add("inscricao");
		add("rural");
		add("produtor");
		add("numero");
		add("fiscal");
		add("email");
		add("nfe");
		add("geografico");
		add("simplificado");
		add("ultima");
		add("atualizacao");
		add("descricao");
		add("nome");
		add("movimento");
		add("movimentacao");
		
	}
	
	public String revolverAsField(String columnName) {
		
		columnName = columnName.toLowerCase();
		
		char[] charArray = columnName.toCharArray();
		
		for (String word: dictionary) {
			
			int indexOf = columnName.indexOf(word);
			
			if(indexOf != -1) {
				
				int position = indexOf + word.length();
				
				if(columnName.length() > position) {
					charArray[position] = Character.toUpperCase(charArray[position]); 
				}
			}
			
		}
		
		return new String(charArray);
	}

	public String capitalize(String word) {
		return StringUtils.capitalize(word);
	}
	

	public boolean add(String word) {
		return dictionary.add(word.toLowerCase());
	}


	public boolean addAll(Collection<? extends String> words) {
		return dictionary.addAll(words);
	}
	
	
	
}
