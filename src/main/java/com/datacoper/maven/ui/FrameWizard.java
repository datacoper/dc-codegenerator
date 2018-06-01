package com.datacoper.maven.ui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;

import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.metadata.TemplateModel;

import se.gustavkarlsson.gwiz.AbstractWizardPage;
import se.gustavkarlsson.gwiz.WizardController;
import se.gustavkarlsson.gwiz.wizards.JFrameWizard;

public class FrameWizard extends JFrameWizard {
	private static final long serialVersionUID = 1L;

	public FrameWizard(String projectParentPath) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		File projectParentFile = getAndValidateProjectFile(projectParentPath);
		
		String moduleName = getModuleName(projectParentFile);
		setTitle(moduleName);
		
		TemplateModel templateModel = new TemplateModel(projectParentFile, moduleName);
		
		WizardController controller = new WizardController(this);
		
		AbstractWizardPage startPage = new PanelEntity(templateModel);
		controller.startWizard(startPage);
		
		
	}
	
	private File getAndValidateProjectFile(String projectParent) {
		File projectParentFile = new File(projectParent);
		if(!projectParentFile.exists()) {
			throw new RuntimeException("Parent project folder not exits: "+projectParent);
		}
		
		if(!projectParent.endsWith(EnumProject.PARENT.getSuffix())) {
			throw new RuntimeException("Invalid Parent project: "+projectParent);
		}
		
		return projectParentFile;
	}
	
	private String getModuleName(File projectParentFile) {
		
		String projectParentName = projectParentFile.getName();
		
		return projectParentName.replace(EnumProject.PARENT.getSuffix(), "");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameWizard frame = new FrameWizard("/home/thiago/dev/projetos/Cooperalfa/Homolog/CooperateEE/Faturamento-Parent");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
