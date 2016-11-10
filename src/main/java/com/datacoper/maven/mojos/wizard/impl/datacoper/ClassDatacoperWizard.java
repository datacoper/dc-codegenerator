/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl.datacoper;

import com.datacoper.maven.mojos.wizard.AbstractAttributeWizard;
import com.datacoper.maven.mojos.wizard.AbstractClassWizard;

/**
 *
 * @author alessandro
 */
public class ClassDatacoperWizard extends AbstractClassWizard {

    @Override
    protected boolean questionSuperClass() {
        return false;
    }

    @Override
    protected boolean questionImplements() {
        return false;
    }

    @Override
    protected boolean questionAnnotations() {
        return false;
    }

    @Override
    protected boolean questionAttributes() {
        return true;
    }

    @Override
    protected AbstractAttributeWizard getAttributeWizard() {
        return new AttributeDatacoperWizard();
    }
}
