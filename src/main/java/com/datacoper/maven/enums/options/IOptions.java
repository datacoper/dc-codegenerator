/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.enums.options;

/**
 *
 * @author alessandro
 */
public interface IOptions {
    String print();

    IOptions of(String answer);
}
