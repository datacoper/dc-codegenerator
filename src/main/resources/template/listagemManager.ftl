
<#assign className = model.className>
<#assign company = model.company.packag>
<#assign module = model.moduleBasic>
package ${model.package};

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.datacoper.arquitetura.common.itemmenu.PaginaItemMenu;
import com.datacoper.arquitetura.common.itemmenu.PaginaItemMenuBean;
import com.datacoper.cooperate.arquitetura.web.generic.form.RestConfigurationBase;
import com.datacoper.cooperate.arquitetura.web.generic.list.ListagemGenericaManager;

import com.${company}.cooperate.${module?lower_case}.web.Enum${module}ResourceConfiguration;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${model.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.rest.common.dto.${model.classNameBasic}DTO;
import com.${company}.cooperate.${module?lower_case}.rest.common.resources.${model.classNameBasic}Resource;

@ManagedBean
@ViewScoped
public class Listagem${model.classNameBasic}Manager extends ListagemGenericaManager<${model.classNameBasic}VO, ${model.classNameBasic}DTO, ${model.classNameBasic}Resource> {

    private static final long serialVersionUID = 1L;

    @Override
    protected PaginaItemMenuBean getFormPageItem() {
        return PaginaItemMenu.${module?upper_case}_${model.classNameBasic?upper_case}_EDITAR;
    }

    @Override
    public RestConfigurationBase[] getResourceConfiguration() {
        return Enum${module}ResourceConfiguration.values();
    }
}

