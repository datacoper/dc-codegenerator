package com.datacoper.maven.util;

import com.datacoper.maven.exception.DcLogicException;
import com.datacoper.maven.exception.DcRuntimeException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ClassUtil {

    private ClassUtil() { }

    public static List<Class<?>> forName(List<String> names) {
        return names.stream().map(ClassUtil::forName).collect(Collectors.toList());
    }

    public static Class<?> forName(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new DcRuntimeException(StringUtil.format("class {0} not found in ClassLoader", name));
        }
    }
    
    public static Class<?> forNameThrowException(String name) throws DcLogicException {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new DcLogicException(StringUtil.format("Classe {0} não foi localizada no ClassLoader", name));
        }
    }
    
    public static Optional<Class<?>> forNameIfNotNullOrEmpty(String name) {
        if (StringUtil.isNullOrEmpty(name)) return Optional.empty();
        
        return Optional.of(forName(name));
    }
    
    public static String extractSimpleName(String className) {
        int lastIndexOf = className.lastIndexOf(".");
        
        if (lastIndexOf == -1) return className;
        
        return className.substring(lastIndexOf + 1, className.length());
    }
    
    public static Optional<String> extractPackage(String className) {
        int lastIndexOf = className.lastIndexOf(".");
        
        if (lastIndexOf == -1) return Optional.empty();
        
        return Optional.of(className.substring(0, lastIndexOf));
    }
}
