package com.datacoper.maven.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCCheckBox;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.impl.EnumScaffold;
import com.datacoper.maven.metadata.TemplateModel;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelClasses extends AbstractPanelWizard {
	private static final long serialVersionUID = 1L;

	private JButton btnGerar = new JButton("Gerar");
	
	private List<AbstractGeneratorCheckBox> abstractGeneratorCheckBoxs = new ArrayList<PanelClasses.AbstractGeneratorCheckBox>();
	
	public PanelClasses(TemplateModel templateModel) {
		super(templateModel);
		
		setLayout(new VerticalFlowLayout());

		EnumProject[] enumProjects = EnumProject.values();

		for (EnumProject enumProject : enumProjects) {

			List<AbstractGenerator> generators = EnumScaffold.getGenerators(enumProject);

			if(!generators.isEmpty()) {
				JLabel  dcLabel = new JLabel(enumProject.getSuffix());
				add(dcLabel);
				for (AbstractGenerator abstractGenerator : generators) {
	
					String className = abstractGenerator.getClassName(getTemplateModel().getEntityName());
					getTemplateModel().setClassName(className);
					getTemplateModel().setClassNameBasic(className);
					
					AbstractGeneratorCheckBox abstractGeneratorCheckBox = new AbstractGeneratorCheckBox(abstractGenerator, className);
					
					abstractGeneratorCheckBoxs.add(abstractGeneratorCheckBox);
					
					File javaFile = abstractGenerator.getJavaFile(getTemplateModel());
					System.out.println("JavaFile: "+javaFile);
					boolean javaFileExits = javaFile.exists();
					
					abstractGeneratorCheckBox.setSelected(!javaFileExits);
					
					add(abstractGeneratorCheckBox);
				}
			}
			
		}
		
		
		add(btnGerar);

		btnGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gerar();
			}
		});
		
	}

	
	private void gerar() {
		
		for (AbstractGeneratorCheckBox abstractGeneratorCheckBox : abstractGeneratorCheckBoxs) {
			
			TemplateModel templateModel = getTemplateModel();
			templateModel.setClassName(abstractGeneratorCheckBox.className);
			templateModel.setClassNameBasic(abstractGeneratorCheckBox.className);
			abstractGeneratorCheckBox.abstractGenerator.process(templateModel);
		}
		
	}


	private static class AbstractGeneratorCheckBox extends DCCheckBox {
		private static final long serialVersionUID = 1L;
		
		private AbstractGenerator abstractGenerator;
		private String className;

		public AbstractGeneratorCheckBox(AbstractGenerator abstractGenerator, String className) {
			this.abstractGenerator = abstractGenerator;
			this.className = className;
			setText(className);
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

}
