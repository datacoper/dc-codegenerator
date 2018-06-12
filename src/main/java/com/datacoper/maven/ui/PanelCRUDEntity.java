package com.datacoper.maven.ui;

import javax.swing.JComboBox;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCPanelTitled;
import com.datacoper.cooperate.arquitetura.client.textfield.DCTextField;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.metadata.TemplateModelDetail;
import com.datacoper.maven.util.StringUtil;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDEntity extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Company> comboCompany = new JComboBox<>(Company.values());
	
	private DCTextField fieldEntity = new DCTextField();
	
	private DCTextField fieldEntityDetail1 = new DCTextField();
	
	private DCTextField fieldEntityDetail2 = new DCTextField();
	
	private DCTextField fieldEntityDetail3 = new DCTextField();
	
	private PanelCRUDAttributes panelCRUDAttributes;
	
	public PanelCRUDEntity(TemplateModel templateModel) {
		super(templateModel);
		
		setLayout(new VerticalFlowLayout());
		
		DCPanelTitled panelCompany = new DCPanelTitled();
		panelCompany.setTitle("Empresa");
		panelCompany.setMandatory(true);
		panelCompany.add(comboCompany);
		
		DCPanelTitled panelEntity = new DCPanelTitled();
		panelEntity.setTitle("Entidade Master");
		panelEntity.setMandatory(true);
		panelEntity.add(fieldEntity);
		
		DCPanelTitled panelEntityDetail1 = new DCPanelTitled();
		panelEntityDetail1.setTitle("Entidade Detail 1");
		panelEntityDetail1.setMandatory(true);
		panelEntityDetail1.add(fieldEntityDetail1);
		
		DCPanelTitled panelEntityDetail2 = new DCPanelTitled();
		panelEntityDetail2.setTitle("Entidade Detail 2");
		panelEntityDetail2.setMandatory(true);
		panelEntityDetail2.add(fieldEntityDetail2);
		
		DCPanelTitled panelEntityDetail3 = new DCPanelTitled();
		panelEntityDetail3.setTitle("Entidade Detail 1");
		panelEntityDetail3.setMandatory(true);
		panelEntityDetail3.add(fieldEntityDetail3);
		
		add(panelCompany);
		add(panelEntity);
		
		panelCRUDAttributes = new PanelCRUDAttributes(templateModel);
		
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return panelCRUDAttributes;
	}

	@Override
	protected boolean isCancelAllowed() {
		return true;
	}

	@Override
	protected boolean isPreviousAllowed() {
		return true;
	}

	@Override
	protected boolean isNextAllowed() {
		return true;
	}

	@Override
	protected boolean isFinishAllowed() {
		return false;
	}

	@Override
	void onNext() {
		String entityName = fieldEntity.getText();
		
		TemplateModel templateModel = getTemplateModel();
		templateModel.setEntityName(entityName);
		templateModel.setCompany((Company)comboCompany.getSelectedItem());
		
		String entityDetail1 = fieldEntityDetail1.getText();
		
		if(StringUtil.isNotNullOrEmpty(entityDetail1)) {
			templateModel.addDetail(new TemplateModelDetail(entityDetail1));
		}
		
		String entityDetail2 = fieldEntityDetail2.getText();
		
		if(StringUtil.isNotNullOrEmpty(entityDetail2)) {
			templateModel.addDetail(new TemplateModelDetail(entityDetail2));
		}
		
		String entityDetail3 = fieldEntityDetail3.getText();
		
		if(StringUtil.isNotNullOrEmpty(entityDetail3)) {
			templateModel.addDetail(new TemplateModelDetail(entityDetail3));
		}
		
		panelCRUDAttributes.init();
	}

	@Override
	void onFinish() {
		
	}

}
