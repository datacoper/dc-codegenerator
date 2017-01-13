/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl.datacoper;

import com.datacoper.maven.mojos.IMojo;
import com.datacoper.maven.mojos.wizard.AbstractAttributeWizard;
import com.datacoper.maven.mojos.wizard.AbstractClassWizard;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 *
 * @author alessandro
 */
public class ClassDatacoperWizard extends AbstractClassWizard {

    public ClassDatacoperWizard(IMojo mojo) {
        super(mojo);
    }

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


    /**
     * Verifica se deve ser perguntado o nome da entidade.
     * @return <code>true</code> se o nome da entidade não foi
     * informado por parâmetro.
     */
    @Override
    protected boolean questionEntityName() {
        return isEmpty(getMojo().getEntityName());
    }

    @Override
    protected AbstractAttributeWizard getAttributeWizard() {
        return new AttributeDatacoperWizard();
    }
}
