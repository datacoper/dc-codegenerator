package com.datacoper.maven.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.datacoper.cooperate.arquitetura.common.util.Entry;

public class ColumnNameResolver {

	private static final String ID_WORD = "id";
	private Properties dictionary = new Properties();
	private List<Object> wordSortedByLargest = new ArrayList<Object>();  
	
	public ColumnNameResolver() {
		try {
			InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("dicionario.properties");
			dictionary.load( new InputStreamReader(resourceAsStream, "UTF-8"));
			
			wordSortedByLargest = dictionary.keySet()
					.stream()
					.sorted(
						(a, b)-> b.toString().length() - a.toString().length()
					).collect(Collectors.toList());
			
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler o dicionário de dados",e);
		}
		
	}
	
	public Entry<String, String> revolverFieldAndLabel(String columnName) {
		
		Set<Entry<String, Integer>> labels = new TreeSet<>(getPositionComparator());
		
		columnName = columnName.toLowerCase();
		
		List<String> foundWords = new ArrayList<String>();
		char[] charArray = columnName.toCharArray();
		
		for (Object wordObj: wordSortedByLargest) {
			
			String word = (String) wordObj;
			if (ID_WORD.equals(word)
					|| foundWords.stream().anyMatch(w -> w.startsWith(word)))
			{
				continue;
			}
			
			int indexOfWord = columnName.indexOf(word);
			
			if(indexOfWord != -1) {
				
				foundWords.add(word);
				
				String label = dictionary.getProperty(word);
				if(StringUtil.isNotNullOrEmpty(label)) {
					labels.add(Entry.of(label, indexOfWord));
				}
				
				if(indexOfWord != 0) {
					charArray[indexOfWord] = Character.toUpperCase(charArray[indexOfWord]);
				}
				
				int nextWordCaracter = indexOfWord + word.length();
				
				if(columnName.length() > nextWordCaracter && !columnName.substring(nextWordCaracter).startsWith(ID_WORD)) {
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
