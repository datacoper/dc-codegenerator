/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl;

import com.datacoper.maven.mojos.wizard.AbstractClassWizard;

/**
 *
 * @author alessandro
 */
public class ClassWizard extends AbstractClassWizard {

    @Override
    protected boolean questionSuperClass() {
        return true;
    }

    @Override
    protected boolean questionImplements() {
        return true;
    }

    @Override
    protected boolean questionAnnotations() {
        return true;
    }

    @Override
    protected boolean questionAttributes() {
        return true;
    }
}
