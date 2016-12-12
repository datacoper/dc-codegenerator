/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author aline.cardoso
 */
public class LinkedProperties extends Properties {
    private final HashSet<Object> keys = new LinkedHashSet<>();

    private static final long serialVersionUID = 1L;

    private final Map<Object, Object> linkMap = new LinkedHashMap<>();

    @Override
    public synchronized Object put(Object key, Object value){
        return linkMap.put(key, value);
    }

    @Override
    public synchronized boolean contains(Object value){
        return linkMap.containsValue(value);
    }

    @Override
    public boolean containsValue(Object value){
        return linkMap.containsValue(value);
    }

    @Override
    public synchronized Enumeration<Object> elements(){
        throw new UnsupportedOperationException(
          "Enumerations are so old-school, don't use them, "
        + "use keySet() or entrySet() instead");
    }

    @Override
    public Set<Entry<Object, Object>> entrySet(){
        return linkMap.entrySet();
    }

    @Override
    public synchronized void clear(){
        linkMap.clear();
    }

    @Override
    public synchronized boolean containsKey(Object key){
        return linkMap.containsKey(key);
    }

    @Override
    public void list(PrintStream out) {
        linkMap.forEach((k, v) -> out.println(k.toString().concat(" = ").concat(v.toString())));
    }
}
