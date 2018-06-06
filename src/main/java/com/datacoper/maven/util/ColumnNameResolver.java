package com.datacoper.maven.util;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import com.datacoper.cooperate.arquitetura.common.util.Entry;

public class ColumnNameResolver {

	private Properties dictionary = new Properties();
	
	public ColumnNameResolver() {
		try {
			dictionary.load(getClass().getClassLoader().getResourceAsStream("dicionario.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler o dicionário de dados",e);
		}
		
	}
	
	public Entry<String, String> revolverFieldAndLabel(String columnName) {
		
		Set<Entry<String, Integer>> labels = new TreeSet<>(getPositionComparator());
		
		columnName = columnName.toLowerCase();
		
		char[] charArray = columnName.toCharArray();
		
		for (Object wordObj: dictionary.keySet()) {
			
			String word = (String) wordObj;
			
			int indexOfWord = columnName.indexOf(word);
			
			if(indexOfWord != -1) {
				
				String label = dictionary.getProperty(word);
				if(StringUtil.isNotNullOrEmpty(label)) {
					labels.add(Entry.of(label, indexOfWord));
				}
				
				if(indexOfWord != 0) {
					charArray[indexOfWord] = Character.toUpperCase(charArray[indexOfWord]);
				}
				
				int nextWordCaracter = indexOfWord + word.length();
				
				if(columnName.length() > nextWordCaracter) {
					charArray[nextWordCaracter] = Character.toUpperCase(charArray[nextWordCaracter]); 
				}
				
			}
			
		}
		
		return Entry.of(new String(charArray), composeLabels(labels));
	}
	
	private String composeLabels(Set<Entry<String, Integer>> labels) {
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Entry<String, Integer>> iterator = labels.iterator();
		
		while (iterator.hasNext()) {
			Entry<java.lang.String, java.lang.Integer> entry = iterator.next();
			
			sb.append(entry.getKey());
			if(iterator.hasNext()) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}

	private Comparator<Entry<String, Integer>> getPositionComparator(){
		return new Comparator<Entry<String,Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		};
	}
}
