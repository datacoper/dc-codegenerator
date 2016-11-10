<#assign attributes = class.attributes/>
<#assign className = class.className?cap_first>
<#assign classNameUpper = class.className?upper_case>
package ${class.package};

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.AbstractEntity;
<#list class.imports as import>
import ${import};
</#list>

@Entity
public class ${className} extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_${classNameUpper}", sequenceName = "ID${classNameUpper}")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_${classNameUpper}")
    private Long id${className};

    <#include "attributes.ftl">
    
    <#include "defaultConstructor.ftl">

    <#include "getterAndSetterForID.ftl">

    <#include "getterAndSetter.ftl">
    @Override
    public Long getId() {
        return getId${className}();
    }
}