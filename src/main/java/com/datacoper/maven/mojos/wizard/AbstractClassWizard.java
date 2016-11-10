package com.datacoper.maven.mojos.wizard;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.exception.OperationCanceledByUser;
import com.datacoper.maven.metadata.TAnnotation;
import com.datacoper.maven.metadata.TAttribute;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.mojos.wizard.impl.AnnotationWizard;
import com.datacoper.maven.mojos.wizard.impl.AttributeWizard;
import com.datacoper.maven.util.Converters;
import com.datacoper.maven.util.LogUtil;
import static com.datacoper.maven.util.QuestionsUtils.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractClassWizard extends AbstractMojoWizard<TClass> {

    private TClass clazz;

    public AbstractClassWizard() { }

    @Override
    public TClass start() {
        
        sysOutSeparatorHelper("START CLASS");
       
        try {
            loadQuestions();
            
            sysOutSeparatorHelper("END CLASS");
        } catch (OperationCanceledByUser e) {
            LogUtil.warn("Operation Canceled by User");
        }
        

        return clazz;
    }

    private void loadQuestions() throws OperationCanceledByUser {
        AbstractAnnotationWizard annotationWizard = getAnnotationWizard();
        AbstractAttributeWizard attributeWizard = getAttributeWizard();
        
        String className = "";
        String packag = "";
        Optional<Class<?>> superClass = Optional.empty();
        Set<Class<?>> implement = new HashSet<>();
        Set<TAnnotation> annotations = new HashSet<>();
        Set<TAttribute> attributes = new HashSet<>();
        CompanyOptions company = CompanyOptions.DATACOPER;
        
        if (questionCompany()) {
            company = questionParamterNonEmpty("This scaffold belongs to which company? ", CompanyOptions.class);
        }
        
        if (questionPackage()) {
            className = questionNonEmpty("Package for class generate: ");
        }
        
        if (questionEntityName()) {
            className = questionNonEmpty("Name for entity generate: ");
        }
        
        if(questionSuperClass()) {
            superClass = question(Converters::toClass, "Complete name extends class: ");
        }
        
        if (questionImplements()) {
            implement = questionGroupSingleQuestion(Converters::toClass, "Implements", "Implemented class: ");
        }
        
        if (questionAnnotations()) {
            annotations = annotationWizard.start();
        }
        
        if (questionAttributes()) {
            attributes = attributeWizard.start();
        }
        
        String canonicalNameSuperClass = superClass.map(ext -> ext.getCanonicalName()).orElse(null);
        
        clazz = new TClass(
                company,
                packag,
                className,
                className,
                canonicalNameSuperClass,
                new HashSet<>(),
                prepareToModel(implement),
                attributes,
                annotations);
    }
    
    private Set<String> prepareToModel(Set<Class<?>> values) {
        return values.stream()
                .map(value -> value.getCanonicalName())
                .collect(Collectors.toSet());
    }
    
    protected boolean questionCompany() {
        return true;
    }
    
    protected boolean questionEntityName() {
        return true;
    }
    
    protected boolean questionPackage() {
        return false;
    }
    
    protected abstract boolean questionSuperClass();
    
    protected abstract boolean questionImplements();
    
    protected abstract boolean questionAnnotations();
    
    protected abstract boolean questionAttributes();

    protected AbstractAttributeWizard getAttributeWizard() {
        return new AttributeWizard();
    }

    protected AbstractAnnotationWizard getAnnotationWizard() {
        return new AnnotationWizard();
    }
    
}
