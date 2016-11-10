/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard.impl.datacoper;

import com.datacoper.maven.mojos.wizard.AbstractMojoWizard;
import com.datacoper.maven.util.QuestionsUtils;

/**
 *
 * @author alessandro.abegg
 */
public class EntityNameWizzard extends AbstractMojoWizard<String> {

    @Override
    public String start() {
        return QuestionsUtils.questionNonEmpty("Nome entidade base: ");
    }
}
