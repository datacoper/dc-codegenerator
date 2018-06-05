
<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
package ${class.package};

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.datacoper.arquitetura.common.itemmenu.PaginaItemMenu;
import com.datacoper.arquitetura.common.itemmenu.PaginaItemMenuBean;
import com.datacoper.cooperate.arquitetura.web.generic.form.RestConfigurationBase;
import com.datacoper.cooperate.arquitetura.web.generic.list.ListagemGenericaManager;

import com.${company}.cooperate.${module?lower_case}.web.Enum${module}ResourceConfiguration;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.rest.common.dto.${class.classNameBasic}DTO;
import com.${company}.cooperate.${module?lower_case}.rest.common.resources.${class.classNameBasic}Resource;

@ManagedBean
@ViewScoped
public class Listagem${class.classNameBasic}Manager extends ListagemGenericaManager<${class.classNameBasic}VO, ${class.classNameBasic}DTO, ${class.classNameBasic}Resource> {

    private static final long serialVersionUID = 1L;

    @Override
    protected PaginaItemMenuBean getFormPageItem() {
        return PaginaItemMenu.${module?upper_case}_${class.classNameBasic?upper_case}_EDITAR;
    }

    @Override
    public RestConfigurationBase[] getResourceConfiguration() {
        return Enum${module}ResourceConfiguration.values();
    }
}

