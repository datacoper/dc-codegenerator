package com.datacoper.maven.mojos.wizard;

import static com.datacoper.maven.util.QuestionsUtils.questionGroup;
import static com.datacoper.maven.util.QuestionsUtils.questionInGroupNonEmpty;
import static com.datacoper.maven.util.QuestionsUtils.questionMapValues;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.datacoper.maven.exception.OperationCanceledByUser;
import com.datacoper.maven.metadata.TAnnotation;
import com.datacoper.maven.util.Converters;
import com.datacoper.maven.util.LambdaExceptionUtil;

/**
 *
 * @author alessandro
 */
public abstract class AbstractAnnotationWizard extends AbstractMojoWizard<Set<TAnnotation>> {

    public static enum AnnotationLacale {
        ATTRIBUTE, CLASS, METHOD
    }

    public AbstractAnnotationWizard() {
        
    }

    @Override
    public Set<TAnnotation> start() {
        
        Set<TAnnotation> annotations = new HashSet<>();
        
        questionGroup("Annotations", LambdaExceptionUtil.rethrowSupplier(this::questionAttributeAnnotations));
        
        return annotations;
    }
    
    private Optional<TAnnotation> questionAttributeAnnotations() throws OperationCanceledByUser {
        Optional<Class<?>> annotationClass = questionInGroupNonEmpty(Converters::toClass, "Annotation class: ");
        if (!annotationClass.isPresent()) return Optional.empty();

        Map<String, String> properties = null;
        
        if (questionParams()) {
            properties = questionMapValues("ANNOTATION ", annotationClass);
        }
        
        String canonicalNameAnnotation = annotationClass.map(ann -> ann.getCanonicalName()).orElse(null);
        
        return Optional.ofNullable(new TAnnotation(canonicalNameAnnotation, properties));
    }
    
    protected abstract boolean questionParams();
}
