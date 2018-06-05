<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
<#assign classNameVar = class.classNameBasic?uncap_first>
package ${class.package};

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module?lower_case}.server.cooperalfa.eao.impl.${class.classNameBasic}EAO;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.entities.builder.${class.classNameBasic}Builder;
import com.datacoper.testes.persistence.GenericEAOTestUtil;
import com.datacoper.testes.persistence.PersistenceConfig;
import com.datacoper.testes.persistence.PersistenceRunner;

@RunWith(PersistenceRunner.class)
@PersistenceConfig(entities = {${class.classNameBasic}.class})
public class ${className} {

    private GenericEAOTestUtil genericEAOTestUtil = new GenericEAOTestUtil();
    private ${module}EAO ${module?uncap_first}EAO = new ${module}EAO();

    private ${class.classNameBasic}EAO ${classNameVar}EAO = ${module?uncap_first}EAO.get${class.classNameBasic}EAO();

    @Test
    public void deveRetornarRegistroPeloFindFetch() {
        ${class.classNameBasic} ${classNameVar}Persistido = new ${class.classNameBasic}Builder()
                .build();
        genericEAOTestUtil.persist(${classNameVar}Persistido);

        ${class.classNameBasic} ${classNameVar}Localizado = ${classNameVar}EAO.findFetch(${classNameVar}Persistido.getId());

        assertThat(${classNameVar}Localizado, equalTo(${classNameVar}Persistido));
    }

    @Test
    public void deveRetornarRegistroPeloFindVO() {
        ${class.classNameBasic} ${classNameVar}Persistido = new ${class.classNameBasic}Builder()
                //.withA()
                //.withB()    
                .build();
        genericEAOTestUtil.persist(${classNameVar}Persistido);

        PageResult<${class.classNameBasic}VO> pageResult = ${classNameVar}EAO.find(new BeanConsultaGroup());

        assertThat(pageResult.getItems(), hasSize(1));

        ${class.classNameBasic}VO ${classNameVar}VO = pageResult.getItems().get(0);
        assertThat(${classNameVar}VO.getId(), equalTo(${classNameVar}Persistido.getId()));

        //assertThat(${classNameVar}VO.getA(), equalTo(${classNameVar}Persistido.getA()));
        //assertThat(${classNameVar}VO.getB(), equalTo(${classNameVar}Persistido.getB()));
    }
}
