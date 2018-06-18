<#assign className = model.className>
<#assign attributes = model.attributes/>
package ${model.package};

<#list model.attributeImportsJava as import>
import ${import};
</#list>

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
    <#if attribute.entity>
    private Long id${attribute.name};    
    <#else>    
    @AttributeAnnot(alias = "${attribute.label}")
    private ${attribute.typeSimpleName} ${attribute.name};
    </#if>
</#list>

    <#include "defaultConstructor.ftl">

    <#include "getterAndSetterForID.ftl">

<#list attributes as attribute>
    <#assign attributeType = attribute.typeSimpleName>
    <#assign attributeName = attribute.name>
	
	<#if attribute.entity>
    public void setId${attributeName}(Long id${attributeName}) {
        this.id${attributeName} = id${attributeName};
    }
	
    public Long getId${attributeName}() {
        return id${attributeName};
    }
	<#else>
	public void set${attributeName?cap_first}(${attributeType} ${attributeName}) {
        this.${attributeName} = ${attributeName};
    }
	
    public ${attributeType} get${attributeName?cap_first}() {
        return ${attributeName};
    }
	</#if>
	
</#list>
    
    @Override
    public Long getId() {
        return getId${model.entityName}();
    }
    
}
