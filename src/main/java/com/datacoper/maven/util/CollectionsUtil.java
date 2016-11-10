/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author alessandro
 */
public abstract class CollectionsUtil {
    
    private CollectionsUtil() { }
    
    public boolean isNotNullOrEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }
    
    public boolean isNullOrEmpty(Collection<?> collection) {
        return collection != null && collection.isEmpty();
    }
    
    public static <E, T extends Collection<E>> List<E> concat(T... collections) {
        Iterable<?> concat = Iterables.concat(collections);
        
        List list = new ArrayList();
        concat.forEach(item -> {
            list.add(item);
        });
        
        return list;
    }
}
