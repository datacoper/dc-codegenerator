/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.exception;

import com.datacoper.maven.util.StringUtil;

/**
 *
 * @author alessandro
 */
public class DcRuntimeException extends RuntimeException implements DcException {
    
    public DcRuntimeException(Throwable throwable) {
        super(throwable);
    }
    
    public DcRuntimeException(String message) {
        super(message);
    }
    
    public DcRuntimeException(String message, Object... params) {
        super(StringUtil.format(message, params));
    }
}
