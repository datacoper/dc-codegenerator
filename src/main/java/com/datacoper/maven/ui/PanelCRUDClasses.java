package com.datacoper.maven.ui;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.client.panel.DCCheckBox;
import com.datacoper.cooperate.arquitetura.common.util.ListUtil;
import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.impl.EnumScaffold;
import com.datacoper.maven.generators.impl.EnumScaffoldDetail;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.metadata.TemplateModelDetail;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDClasses extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;

	private List<AbstractGeneratorCheckBox> abstractGeneratorCheckBoxs;
	
	private JCheckBox checkAll = new JCheckBox("Marcar/Desmarcar todas", true);
	
	private JPanel container = new JPanel();
	
	public PanelCRUDClasses(TemplateModel templateModel) {
		super(templateModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(container), BorderLayout.CENTER);
				
		VerticalFlowLayout verticalLayout = new VerticalFlowLayout();
		container.setLayout(verticalLayout);
		
		checkAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAll();
			}
		});
		
		add(checkAll, BorderLayout.NORTH);
		
	}
	
	private void checkAll() {
		for (AbstractGeneratorCheckBox abstractGeneratorCheckBox : ListUtil.notNull(abstractGeneratorCheckBoxs)) {
			abstractGeneratorCheckBox.setSelected(checkAll.isSelected());
		}
		updateWizardButtons();
	}

	public void init() {
		container.removeAll();
		
		abstractGeneratorCheckBoxs = new ArrayList<PanelCRUDClasses.AbstractGeneratorCheckBox>();
		
		TemplateModel templateModel = getTemplateModel();
		
		if(templateModel.getEntityName() != null) {
			EnumProject[] enumProjects = EnumProject.values();
	
			for (EnumProject enumProject : enumProjects) {
	
				List<AbstractGenerator> generators = EnumScaffold.getGenerators(enumProject, templateModel);
				
				Set<TemplateModelDetail> details = templateModel.getDetails();
				
				for (TemplateModelDetail templateModelDetail : details) {
					generators.addAll(EnumScaffoldDetail.getGenerators(enumProject, templateModelDetail));
				}
				
				if(!generators.isEmpty()) {
					JLabel  dcLabel = new JLabel(enumProject.getSuffix());
					container.add(dcLabel);
					for (AbstractGenerator abstractGenerator : generators) {
		
						AbstractGeneratorCheckBox abstractGeneratorCheckBox = new AbstractGeneratorCheckBox(abstractGenerator);
						abstractGeneratorCheckBoxs.add(abstractGeneratorCheckBox);
						
						container.add(abstractGeneratorCheckBox);
					}
				}
				
			}
			
		}
	}


	private void gerar() {
		
		StringBuilder sb = new StringBuilder();
		
		TemplateModel templateModel = getTemplateModel();
		
		for (AbstractGeneratorCheckBox abstractGeneratorCheckBox : abstractGeneratorCheckBoxs) {
			if(abstractGeneratorCheckBox.isSelected()) {
				abstractGeneratorCheckBox.abstractGenerator.process();
				
				String javaFile = abstractGeneratorCheckBox.abstractGenerator.getJavaFile().getPath();
				
				String projectParentFile = templateModel.getProjectParentFile().getPath();
				
				sb.append(javaFile.replace(projectParentFile, ""));
				sb.append("\n");
			}
		}
		
		sb.append("\nFechar?");
		
		int option = JOptionPane.showConfirmDialog(this, sb, "Concluído", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(option == JOptionPane.YES_OPTION) {
			((Window)getRootPane().getParent()).dispose();
		}
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
