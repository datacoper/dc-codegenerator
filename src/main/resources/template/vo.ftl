<#assign className = model.className>
<#assign attributes = model.attributes/>
package ${model.package};

<#include "attributeImports.ftl">

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.datacoper.cooperate.arquitetura.common.beans.attribute.AttributeAnnot;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EqualsIdentifier;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ${className} extends EqualsIdentifier {
    private static final long serialVersionUID = 1L;
    
    private Long id${model.entityName};
    
<#list attributes as attribute>
    <#if !attribute.entity>
    @AttributeAnnot(alias = "${attribute.label}")
    private ${attribute.typeSimpleName} ${attribute.name};
    <#if>
</#list>

    <#include "defaultConstructor.ftl">

    <#include "getterAndSetterForID.ftl">

    <#include "getterAndSetter.ftl">
    
    @Override
    public Long getId() {
        return getId${model.entityName}();
    }
    
}
