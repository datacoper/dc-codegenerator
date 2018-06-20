<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
<#global attributes = model.attributes/>
package ${model.package};

<#list attributes as attribute>		
<#if attribute.entity>		
import com.${company}.cooperate.${attribute.modulePackageName}.rest.common.dto.${attribute.typeSimpleName}DTO;    
<#else>
import ${attribute.type};
</#if>
</#list>

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.datacoper.cooperate.arquitetura.common.dto.AbstractDTO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ${className} extends AbstractDTO {
    private static final long serialVersionUID = 1L;
    
    private Long id${model.entityName};

<#list model.attributes as attribute>		
    <#if attribute.entity>
    private ${attribute.typeSimpleName}DTO ${attribute.name?uncap_first};
    <#else>
    private ${attribute.typeSimpleName} ${attribute.name?uncap_first};
    </#if>
    
</#list>

    <#include "defaultConstructor.ftl">

    <#include "getterAndSetterForID.ftl">

<#list attributes as attribute>
    <#assign attributeType = attribute.typeSimpleName>
    <#assign attributeName = attribute.name?uncap_first>
	
    public void set${attributeName?cap_first}(${attributeType}<#if attribute.entity>DTO</#if> ${attributeName}) {
        this.${attributeName} = ${attributeName};
    }
	
    public ${attributeType}<#if attribute.entity>DTO</#if> get${attributeName?cap_first}() {
        return ${attributeName};
    }
	
</#list>
    @Override
    public Long getId() {
        return getId${model.entityName}();
    }
}