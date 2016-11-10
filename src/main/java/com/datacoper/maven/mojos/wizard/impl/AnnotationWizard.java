/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl;

import com.datacoper.maven.mojos.wizard.AbstractAnnotationWizard;

/**
 *
 * @author alessandro
 */
public class AnnotationWizard extends AbstractAnnotationWizard {

    @Override
    protected boolean questionParams() {
        return true;
    }
}
