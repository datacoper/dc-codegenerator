<#assign className = class.className>
<#assign attributes = class.attributes/>
package ${class.package};

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.datacoper.cooperate.arquitetura.common.beans.attribute.AttributeAnnot;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EqualsIdentifier;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ${className} extends EqualsIdentifier {
    private static final long serialVersionUID = 1L;
<#list attributes as attribute>
    
    @AttributeAnnot(alias = "${attribute.name}")
    private ${attribute.type} ${attribute.name};
</#list>

    <#include "defaultConstructor.ftl">

    private Long id${class.entityName};

    <#include "getterAndSetterForID.ftl">

    <#include "getterAndSetter.ftl">
<<<<<<< HEAD
    
=======
    @Override
    public String getDescricaoCustomizada() {
        // TODO Auto-generated
        return getId() + " - ";
    }

>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    @Override
    public Long getId() {
        return getId${class.entityName}();
    }
    
}
