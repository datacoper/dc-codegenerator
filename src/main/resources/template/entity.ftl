<#assign attributes = model.attributes/>
<#assign className = model.className?cap_first>
<#assign classNameUpper = model.className?upper_case>
package ${model.package};

<#include "attributeImports.ftl">

import javax.persistence.*;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EntityImpl;
<#if model.hasAttributeBoolean()>import com.datacoper.cooperate.arquitetura.common.util.ByteUtil;</#if>

@Entity
public class ${className} extends EntityImpl {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_${classNameUpper}", sequenceName = "ID${classNameUpper}")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_${classNameUpper}")
    private Long id${className};

<#list model.attributes as attribute>		
    <#if attribute.hasDCAnnotation()>${attribute.getDCAnnotation()}</#if>
    <#if attribute.boolean>
    private Byte ${attribute.name?uncap_first};
    <#elseif attribute.entity>
    @JoinColumn(name="${attribute.columnName}")
    @ManyToOne(fetch=FetchType.LAZY)
    private ${attribute.typeSimpleName} ${attribute.name?uncap_first};
    <#else>
    private ${attribute.typeSimpleName} ${attribute.name?uncap_first};
    </#if>
    
</#list>
	
<#list model.details as detail>
	@OneToMany(mappedBy="${className?uncap_first}")
	private java.util.Set<${detail.entityName}> ${detail.entityName?uncap_first}s = new java.util.HashSet<>();
</#list>
	
	<#include "defaultConstructor.ftl">
	            
    <#include "getterAndSetterForID.ftl">

<#list attributes as attribute>
    <#assign attributeType = attribute.type>
    <#assign attributeName = attribute.name?uncap_first>
	
	<#if attribute.boolean>
    public void set${attributeName?cap_first}(Boolean ${attributeName}) {
        this.${attributeName} = ByteUtil.toByte(${attributeName});
    }
	
    public ${attributeType} get${attributeName?cap_first}() {
        return ByteUtil.toBoolean(${attributeName});
    }
    
    <#else>
    public void set${attributeName?cap_first}(${attribute.typeSimpleName} ${attributeName}) {
        this.${attributeName} = ${attributeName};
    }
	
    public ${attribute.typeSimpleName} get${attributeName?cap_first}() {
        return ${attributeName};
    }
    </#if>
	
</#list>
    
<#list model.details as detail>
	<#assign detailVarName = detail.entityName?uncap_first>
	public void set${detail.entityName}s(java.util.Set<${detail.entityName}> ${detailVarName}s) {
        this.${detailVarName}s = ${detailVarName}s;
    }
	
    public java.util.Set<${detail.entityName}> get${detail.entityName}s() {
        return ${detailVarName}s;
    }	
	
</#list>
    
    
    @Override
    public Long getId() {
        return getId${className}();
    }
}