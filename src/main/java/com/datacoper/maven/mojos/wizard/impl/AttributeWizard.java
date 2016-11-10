/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl;

import com.datacoper.maven.mojos.wizard.AbstractAttributeWizard;

/**
 *
 * @author alessandro
 */
public class AttributeWizard extends AbstractAttributeWizard {

    @Override
    protected boolean questionIsFinal() {
        return true;
    }

    @Override
    protected boolean questionIsStatic() {
        return true;
    }

    @Override
    protected boolean questionEncapsulation() {
        return true;
    }

    @Override
    protected boolean questionAnnotations() {
        return true;
    }    
}