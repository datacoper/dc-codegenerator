<#assign className = class.className>
<#assign attributes = class.attributes/>
package ${class.package};

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.datacoper.cooperate.arquitetura.common.beans.attribute.AttributeAnnot;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EqualsIdentifier;
import com.datacoper.cooperate.arquitetura.common.interfaces.IDescricaoCustomizada;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ${className} extends EqualsIdentifier implements IDescricaoCustomizada {
    private static final long serialVersionUID = 1L;
<#list attributes as attribute>
    
    @AttributeAnnot(alias = "${attribute.name}")
    private ${attribute.type} ${attribute.name};
</#list>

    <#include "defaultConstructor.ftl">

    private Long id${class.classNameBasic};

    <#include "getterAndSetterForID.ftl">

    <#include "getterAndSetter.ftl">
    @Override
    public String getDescricaoCustomizada() {
        //TODO auto generated
        return getId();
    }

    @Override
    public Long getId() {
        return getId${class.classNameBasic}();
    }
    
}
