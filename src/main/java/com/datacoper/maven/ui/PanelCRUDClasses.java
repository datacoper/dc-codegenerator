package com.datacoper.maven.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCCheckBox;
import com.datacoper.cooperate.arquitetura.common.util.ListUtil;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.impl.EnumScaffold;
import com.datacoper.maven.metadata.TemplateAttributeModel;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDClasses extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;

	private List<AbstractGeneratorCheckBox> abstractGeneratorCheckBoxs;
	
	private Set<TemplateAttributeModel> attributes;
	
	private JCheckBox checkAll = new JCheckBox("Marcar/Desmarcar todas", true);
	
	public PanelCRUDClasses(File projectParentFile, String moduleName) {
		super(projectParentFile, moduleName);
		
		VerticalFlowLayout verticalLayout = new VerticalFlowLayout();
		verticalLayout.setVgap(5);
		setLayout(verticalLayout);
		
		checkAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAll();
			}
		});
		
	}
	
	private void checkAll() {
		for (AbstractGeneratorCheckBox abstractGeneratorCheckBox : ListUtil.notNull(abstractGeneratorCheckBoxs)) {
			abstractGeneratorCheckBox.setSelected(checkAll.isSelected());
		}
		updateWizardButtons();
	}

	public void init(String entityName, Company company, Set<TemplateAttributeModel> attributes) {
		removeAll();
		
		abstractGeneratorCheckBoxs = new ArrayList<PanelCRUDClasses.AbstractGeneratorCheckBox>();
		
		this.attributes = attributes;
		
		if(entityName != null) {
			
			add(checkAll);
			
			EnumProject[] enumProjects = EnumProject.values();
	
			for (EnumProject enumProject : enumProjects) {
	
				List<AbstractGenerator> generators = EnumScaffold.getGenerators(enumProject, getProjectParentFile(), entityName, company, getModuleName());
	
				if(!generators.isEmpty()) {
					JLabel  dcLabel = new JLabel(enumProject.getSuffix());
					add(dcLabel);
					for (AbstractGenerator abstractGenerator : generators) {
		
						AbstractGeneratorCheckBox abstractGeneratorCheckBox = new AbstractGeneratorCheckBox(abstractGenerator);
						abstractGeneratorCheckBoxs.add(abstractGeneratorCheckBox);
						
						add(abstractGeneratorCheckBox);
					}
				}
				
			}
			
		}
	}


	private void gerar() {
		
		StringBuilder sb = new StringBuilder();
		
		for (AbstractGeneratorCheckBox abstractGeneratorCheckBox : abstractGeneratorCheckBoxs) {
			if(abstractGeneratorCheckBox.isSelected()) {
				abstractGeneratorCheckBox.abstractGenerator.process(attributes);
				
				String javaFile = abstractGeneratorCheckBox.abstractGenerator.getJavaFile().getPath();
				
				String projectParentFile = getProjectParentFile().getPath();
				
				sb.append(javaFile.replace(projectParentFile, ""));
				sb.append("\n");
			}
		}
		
		JOptionPane.showMessageDialog(this, sb);
	}


	private static class AbstractGeneratorCheckBox extends DCCheckBox {
		private static final long serialVersionUID = 1L;
		
		private AbstractGenerator abstractGenerator;

		public AbstractGeneratorCheckBox(AbstractGenerator abstractGenerator) {
			this.abstractGenerator = abstractGenerator;
			
			File javaFile = abstractGenerator.getJavaFile();
			
			setSelected(!javaFile.exists());
			
			addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateText();
				}
			});
			
			updateText();
			
		}
		
		private void updateText() {
			
			String className = abstractGenerator.getClassName();
			
			File javaFile = abstractGenerator.getJavaFile();
			
			String text = className;
			
			if(javaFile.exists()) {
				text += "   (arquivo já existe. Sobrescrever: ";
				if(isSelected()) {
					text += "sim)";
				}else {
					text += "não)";
				}
			}
			
			setText(text);
			
		}
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return null;
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
		return true;
	}

	@Override
	void onNext() {
	}

	@Override
	void onFinish() {
		gerar();
	}

}
