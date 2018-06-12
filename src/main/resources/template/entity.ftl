<#assign attributes = model.attributes/>
<#assign className = model.className?cap_first>
<#assign classNameUpper = model.className?upper_case>
package ${model.package};

<#include "attributeImports.ftl">

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    <#if attribute.boolean>
    private Byte ${attribute.name?uncap_first};
    <#else>
    private ${attribute.typeSimpleName} ${attribute.name?uncap_first};
    </#if>
    
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
        return getId${className}();
    }
}