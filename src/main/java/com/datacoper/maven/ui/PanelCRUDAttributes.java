package com.datacoper.maven.ui;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.datacoper.cooperate.arquitetura.client.exception.DCErrorDialog;
import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.common.util.Entry;
import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.metadata.EnumAttributeType;
import com.datacoper.maven.metadata.TemplateAttributeModel;
import com.datacoper.maven.util.ColumnNameResolver;
import com.datacoper.maven.util.StringUtil;
import com.datacoper.testes.persistence.PersistenceProperties;
import com.datacoper.testes.persistence.PersistenceProperties.DBType;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDAttributes extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboAttributeType = new JComboBox<>(EnumAttributeType.types());
	
	private PanelCRUDClasses panelCRUDClasses;
	
	private JTable tableAttributes;
	
	private DefaultTableModel defaultTableModel;
	
	private String entityName;
	
	private Company company;

	public PanelCRUDAttributes(File projectParentFile, String moduleName) {
		super(projectParentFile, moduleName);
		
		VerticalFlowLayout verticalLayout = new VerticalFlowLayout();
		verticalLayout.setVgap(5);
		setLayout(verticalLayout);
		
		defaultTableModel = new DefaultTableModel(new String[] {"Coluna", "Atributo", "Label", "Tipo"}, 0);
		
		tableAttributes = new JTable(defaultTableModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return column != 0;
			}
		};
		
		panelCRUDClasses = new PanelCRUDClasses(projectParentFile, moduleName);
		
		TableColumn columnAttributes = tableAttributes.getColumnModel().getColumn(3);
		
		columnAttributes.setCellEditor(new DefaultCellEditor(comboAttributeType));
		
		add(new JScrollPane(tableAttributes));
		
	}

	public void init(String entityName, Company company) {
		this.entityName = entityName;
		this.company = company;
		
		defaultTableModel.setRowCount(0);
		
		if(entityName != null) {
			
			PersistenceProperties persistenceProperties = new PersistenceProperties(DBType.PHYSICAL, getProjectParentFile().getAbsolutePath()+File.separator);
			
			try (Connection connection = DriverManager.getConnection(persistenceProperties.url, persistenceProperties.user, persistenceProperties.password)){
				
				try(Statement statement = connection.createStatement()){
				
					ResultSet resultSet = statement.executeQuery("select * from "+entityName+" where 0 = 1");
					
					ResultSetMetaData metaData = resultSet.getMetaData();
					
					int columnCount = metaData.getColumnCount();
					
					ColumnNameResolver columnNameResolver = new ColumnNameResolver();
					
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnName(i);
						
						if(!isPrimaryKey(entityName, columnName)) {
							Entry<String, String> revolverFieldAndLabel = columnNameResolver.revolverFieldAndLabel(columnName);
							String attributeName = revolverFieldAndLabel.getKey();
							String attributeLabel = StringUtil.isNotNullOrEmpty(revolverFieldAndLabel.getValue()) ? revolverFieldAndLabel.getValue() : attributeName;
							
							String columnClassName = metaData.getColumnClassName(i);
							
							defaultTableModel.addRow(new String[] {columnName, attributeName, attributeLabel, columnClassName});
						}
						
					}
					
				}
				
			} catch (SQLException e) {
				DCErrorDialog.reportException(e, this);
			}
		
		}
		
	}
	
	private boolean isPrimaryKey(String entityName, String columnName) {
		return ("id"+entityName.toLowerCase()).equals(columnName.toLowerCase());
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
		
		Vector<?> dataVector = defaultTableModel.getDataVector();
		
		Set<TemplateAttributeModel> attributes = new HashSet<TemplateAttributeModel>(dataVector.size());
		
		for (Object object : dataVector) {
			
			Vector<?> rowValues = (Vector<?>) object;
			
			String name = (String)rowValues.get(1);
			String label = (String)rowValues.get(2);
			String type = (String)rowValues.get(3);
			
			attributes.add(new TemplateAttributeModel(name, type, label));
		}
		
		
		panelCRUDClasses.init(entityName, company, attributes);
	}

	@Override
	void onFinish() {
	}

}
