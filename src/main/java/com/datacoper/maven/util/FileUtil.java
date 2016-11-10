/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.util;

import com.datacoper.maven.exception.DcRuntimeException;
import java.io.File;

/**
 *
 * @author alessandro
 */
public abstract class FileUtil {

    public static void validateExistsFile(File file) {
        validateExists(file);
        
        if (!file.isFile()) {
            throw new DcRuntimeException("don't is File ({0}).", file.getPath());
        }
    }
    
    public static void validateExistsFolder(File folder) {
        validateExists(folder);
        
        if (!folder.isDirectory()) {
            throw new DcRuntimeException("don't is Folder ({0}).", folder.getPath());
        }
    }
    
    public static void validateExists(File file) {
        if (!file.exists()) {
            throw new DcRuntimeException("File ({0}) not exists.", file.getPath());
        }
    }

    private FileUtil() {
    }

    public static File createOrUseFolder(String folderClass) {
        File file = new File(folderClass);
        
        createFolderIfNecessary(file);
        
        return file;
    }
    
    public static boolean createFolderIfNecessary(String path) {
        File file = new File(path);
        
        return createFolderIfNecessary(file);
    }
    
    public static boolean createFolderIfNecessary(File file) {
        return file.mkdirs();
    }
}
