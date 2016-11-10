/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.exception;

/**
 *
 * @author alessandro
 */
public class DcLogicException extends Exception implements DcException {
    public DcLogicException(String message) {
        super(message);
    }
}
