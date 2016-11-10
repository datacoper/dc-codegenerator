/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl.datacoper;

import com.datacoper.maven.mojos.wizard.AbstractAttributeWizard;

/**
 *
 * @author alessandro
 */
public class AttributeDatacoperWizard extends AbstractAttributeWizard {

    @Override
    protected boolean questionIsFinal() {
        return false;
    }

    @Override
    protected boolean questionIsStatic() {
        return false;
    }

    @Override
    protected boolean questionEncapsulation() {
        return false;
    }

    @Override
    protected boolean questionAnnotations() {
        return false;
    }    
}