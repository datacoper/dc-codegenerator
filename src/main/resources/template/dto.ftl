<#assign className = class.className>
<#global attributes = class.attributes/>
package ${class.package};

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.datacoper.cooperate.arquitetura.common.dto.formgeneric.SelectableObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ${className} extends SelectableObject<Long> {
    private static final long serialVersionUID = 1L;
    
    private Long id${class.entityName};

    <#include "attributes.ftl">

    <#include "defaultConstructor.ftl">

    <#include "getterAndSetterForID.ftl">

    <#include "getterAndSetter.ftl">
    @Override
    public Long getId() {
        return getId${class.entityName}();
    }

    @Override
    public Long getCodigo() {
        return 0L;
    }

    @Override
    public String getDescricao() {
        return "";
    }
}