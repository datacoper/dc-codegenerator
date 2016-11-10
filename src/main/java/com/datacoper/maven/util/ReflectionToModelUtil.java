/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.enums.options.ModifierOptions;
import com.datacoper.maven.metadata.TAttribute;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.metadata.builder.TAttributeBuilder;
import com.datacoper.maven.metadata.builder.TClassBuilder;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author alessandro.abegg
 */
public class ReflectionToModelUtil {
    
    public static final List<String> UNPROCESSED_ATTRIBUTES = Arrays.asList("serialVersionUID");

    public static TClass loadClassToModel(Class<?> clazz, MavenProject project) {
        getAttributes(clazz);
        
        return new TClassBuilder()
                .withClassName(clazz.getSimpleName())
                .withAttributes(getAttributes(clazz))
                .withClassNameBasic(clazz.getSimpleName())
                .withModuleBasic(DCProjectUtil.getName(project))
                .withCompany(CompanyOptions.ofProjectName(DCProjectUtil.getName(project)))
                .build();
    }

    private static Set<TAttribute> getAttributes(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        
        Set<TAttribute> attributes = new HashSet<>();
        
        for (Field field : declaredFields) {
            if (isSkipFieldProcess(field)) continue;
            
            TAttribute tAttribute = new TAttributeBuilder()
                    .withName(field.getName())
                    .withImport(field.getType().getCanonicalName())
                    .withEncapsulation(getModifier(field))
                    .build();
            
            attributes.add(tAttribute);
        }
        
        return attributes;
    }

    private static ModifierOptions getModifier(Field field) {
        for(ModifierOptions option : ModifierOptions.values()) {
            int modifiers = field.getModifiers();
            if (option.isModifierPresent(modifiers)) {
                return option;
            }
        }
        
        return null;
    }

    private static boolean isSkipFieldProcess(Field field) {
        return UNPROCESSED_ATTRIBUTES.contains(field.getName());
    }
}
