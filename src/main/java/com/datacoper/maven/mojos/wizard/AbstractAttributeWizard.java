/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.wizard;

import com.datacoper.maven.enums.options.BooleanOptions;
import com.datacoper.maven.enums.options.ModifierOptions;
import com.datacoper.maven.exception.OperationCanceledByUser;
import com.datacoper.maven.metadata.TAnnotation;
import com.datacoper.maven.metadata.TAttribute;
import com.datacoper.maven.mojos.wizard.impl.AnnotationWizard;
import com.datacoper.maven.util.Converters;
import com.datacoper.maven.util.LambdaExceptionUtil;
import static com.datacoper.maven.util.QuestionsUtils.*;
import java.util.Optional;
import java.util.Set;

/**
 * @author alessandro
 */
public abstract class AbstractAttributeWizard extends AbstractMojoWizard<Set<TAttribute>> {
    
    @Override
    public Set<TAttribute> start() {
        Set<TAttribute> attributes = questionGroup("ATTRIBUTES", LambdaExceptionUtil.rethrowSupplier(this::loadQuestions));
        
        return attributes;
    }
    
    private Optional<TAttribute> loadQuestions() throws OperationCanceledByUser {
        AbstractAnnotationWizard annotationWizard = getAbstractAnnotationWizard();

        String name = null;
        String alias = null;
        Optional<Class<?>> type = Optional.empty();
        ModifierOptions encapsulation = ModifierOptions.PRIVATE;
        BooleanOptions staticc = BooleanOptions.FALSE;
        BooleanOptions finall = BooleanOptions.FALSE;
        Set<TAnnotation> annotations = null;
        
        if (questionName()) {
            name = questionInGroupNonEmpty("Attribute name : ");
            alias = name;
        }
        
        try {
            if (questionType()) {
                type = questionInGroupNonEmpty(Converters::toClass, "{0} type: ", name);
            }
            
            if (questionAlias()) {
                alias = questionInGroupNonEmpty("alias for {0}: ", name);
            }

            if (questionEncapsulation()) {
                encapsulation = questionParamterNonEmpty("{0} encapsulation: ", ModifierOptions.class, name);
            }

            if (questionIsStatic()) {
                staticc = questionParamterNonEmpty("{0} is static? ", BooleanOptions.class, name);
            }

            if (questionIsFinal()) {
                finall = questionParamterNonEmpty("{0} is final? ", BooleanOptions.class, name);
            }

            if (questionAnnotations()) {
                annotations = annotationWizard.start();
            }
        } catch (OperationCanceledByUser e) {}
        
        String canonicalNameType = type.map(t -> t.getCanonicalName()).orElse(null);
        
        TAttribute attribute = new TAttribute(
                canonicalNameType,
                encapsulation,
                staticc,
                finall,
                name,
                alias,
                BooleanOptions.TRUE,
                BooleanOptions.TRUE,
                annotations);
        
        return Optional.ofNullable(attribute);
        
    }
    
    protected boolean questionName() {
        return true;
    }
    
    protected boolean questionAlias() {
    	return true;
    }
    
    protected boolean questionType() {
        return true;
    }
    
    protected abstract boolean questionIsFinal();
    
    protected abstract boolean questionIsStatic();
    
    protected abstract boolean questionEncapsulation();
    
    protected abstract boolean questionAnnotations();
    
    protected AbstractAnnotationWizard getAbstractAnnotationWizard() {
        return new AnnotationWizard();
    }
}
