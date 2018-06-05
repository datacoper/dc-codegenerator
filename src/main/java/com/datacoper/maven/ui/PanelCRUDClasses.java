package com.datacoper.maven.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCCheckBox;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractCRUDGenerator;
import com.datacoper.maven.generators.impl.EnumScaffold;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDClasses extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;

	private List<AbstractGeneratorCheckBox> abstractGeneratorCheckBoxs;
	
	public PanelCRUDClasses(File projectParentFile, String moduleName) {
		super(projectParentFile, moduleName);
		
		VerticalFlowLayout verticalLayout = new VerticalFlowLayout();
		verticalLayout.setVgap(5);
		setLayout(verticalLayout);
	}
	
	public void init(String entityName, Company company) {
		removeAll();
		
		abstractGeneratorCheckBoxs = new ArrayList<PanelCRUDClasses.AbstractGeneratorCheckBox>();
		
		if(entityName != null) {
			EnumProject[] enumProjects = EnumProject.values();
	
			for (EnumProject enumProject : enumProjects) {
	
				List<AbstractCRUDGenerator> generators = EnumScaffold.getGenerators(enumProject, getProjectParentFile(), entityName, company, getModuleName());
	
				if(!generators.isEmpty()) {
					JLabel  dcLabel = new JLabel(enumProject.getSuffix());
					add(dcLabel);
					for (AbstractCRUDGenerator abstractGenerator : generators) {
		
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
			abstractGeneratorCheckBox.abstractGenerator.process();
			
			String javaFile = abstractGeneratorCheckBox.abstractGenerator.getJavaFile().getPath();
			
			String projectParentFile = getProjectParentFile().getPath();
			
			sb.append(javaFile.replace(projectParentFile, ""));
			sb.append("\n");
		}
		
		JOptionPane.showMessageDialog(this, sb);
	}


	private static class AbstractGeneratorCheckBox extends DCCheckBox {
		private static final long serialVersionUID = 1L;
		
		private AbstractCRUDGenerator abstractGenerator;

		public AbstractGeneratorCheckBox(AbstractCRUDGenerator abstractGenerator) {
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
