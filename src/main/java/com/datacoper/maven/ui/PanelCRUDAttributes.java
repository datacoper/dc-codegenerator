package com.datacoper.maven.ui;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.datacoper.cooperate.arquitetura.client.exception.DCErrorDialog;
import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.testes.persistence.PersistenceProperties;
import com.datacoper.testes.persistence.PersistenceProperties.DBType;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDAttributes extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;
	
	private PanelCRUDClasses panelCRUDClasses;
	
	private JTable tableAttributes = new JTable();
	
	private String entityName;
	
	private Company company;

	public PanelCRUDAttributes(File projectParentFile, String moduleName) {
		super(projectParentFile, moduleName);
		
		VerticalFlowLayout verticalLayout = new VerticalFlowLayout();
		verticalLayout.setVgap(5);
		setLayout(verticalLayout);
		
		add(new JScrollPane(tableAttributes));
		
		panelCRUDClasses = new PanelCRUDClasses(projectParentFile, moduleName);
	}

	public void init(String entityName, Company company) {
		this.entityName = entityName;
		this.company = company;
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(new String[] {"Atributo", "Tipo"}, 0);
		
		if(entityName != null) {
			
			PersistenceProperties persistenceProperties = new PersistenceProperties(DBType.PHYSICAL, getProjectParentFile().getAbsolutePath()+File.separator);
			
			try (Connection connection = DriverManager.getConnection(persistenceProperties.url, persistenceProperties.user, persistenceProperties.password)){
				
				try(Statement statement = connection.createStatement()){
				
					ResultSet resultSet = statement.executeQuery("select * from "+entityName+" where 0 = 1");
					
					ResultSetMetaData metaData = resultSet.getMetaData();
					
					int columnCount = metaData.getColumnCount();
					
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnName(i);
						String columnClassName = metaData.getColumnClassName(i);
						
						defaultTableModel.addRow(new String[] {columnName, columnClassName});
						
					}
					
				}
				
			} catch (SQLException e) {
				DCErrorDialog.reportException(e, this);
			}
		
		}
		
		tableAttributes.setModel(defaultTableModel);
		
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return panelCRUDClasses;
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
		panelCRUDClasses.init(entityName, company);
	}

	@Override
	void onFinish() {
	}

}
