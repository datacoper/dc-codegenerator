<#assign className = model.className>
<#assign company = model.company.packag>
<#assign module = model.moduleBasic>
<#assign classNameVar = model.classNameBasic?uncap_first>
package ${model.package};

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module?lower_case}.server.cooperalfa.eao.impl.${model.classNameBasic}EAO;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${model.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.common.entities.${model.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.entities.builder.${model.classNameBasic}Builder;
import com.datacoper.testes.persistence.GenericEAOTestUtil;
import com.datacoper.testes.persistence.PersistenceConfig;
import com.datacoper.testes.persistence.PersistenceRunner;

@RunWith(PersistenceRunner.class)
@PersistenceConfig(entities = {${model.classNameBasic}.class})
public class ${className} {

    private GenericEAOTestUtil genericEAOTestUtil = new GenericEAOTestUtil();
    private ${module}EAO ${module?uncap_first}EAO = new ${module}EAO();

    private ${model.classNameBasic}EAO ${classNameVar}EAO = ${module?uncap_first}EAO.get${model.classNameBasic}EAO();

    @Test
    public void deveRetornarRegistroPeloFindFetch() {
        ${model.classNameBasic} ${classNameVar}Persistido = new ${model.classNameBasic}Builder()
                .build();
        genericEAOTestUtil.persist(${classNameVar}Persistido);

        ${model.classNameBasic} ${classNameVar}Localizado = ${classNameVar}EAO.findFetch(${classNameVar}Persistido.getId());

        assertThat(${classNameVar}Localizado, equalTo(${classNameVar}Persistido));
    }

    @Test
    public void deveRetornarRegistroPeloFindVO() {
        ${model.classNameBasic} ${classNameVar}Persistido = new ${model.classNameBasic}Builder()
                //.withA()
                //.withB()    
                .build();
        genericEAOTestUtil.persist(${classNameVar}Persistido);

        PageResult<${model.classNameBasic}VO> pageResult = ${classNameVar}EAO.find(new BeanConsultaGroup());

        assertThat(pageResult.getItems(), hasSize(1));

        ${model.classNameBasic}VO ${classNameVar}VO = pageResult.getItems().get(0);
        assertThat(${classNameVar}VO.getId(), equalTo(${classNameVar}Persistido.getId()));

        //assertThat(${classNameVar}VO.getA(), equalTo(${classNameVar}Persistido.getA()));
        //assertThat(${classNameVar}VO.getB(), equalTo(${classNameVar}Persistido.getB()));
    }
}
