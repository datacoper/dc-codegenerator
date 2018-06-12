<#assign className = class.className>
<#global attributes = class.attributes/>
package ${class.package};

<#include "attributeImports.ftl">

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.datacoper.cooperate.arquitetura.common.dto.AbstractDTO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ${className} extends AbstractDTO {
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
}