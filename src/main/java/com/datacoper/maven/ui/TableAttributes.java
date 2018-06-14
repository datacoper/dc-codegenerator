package com.datacoper.maven.ui;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.datacoper.maven.enums.options.Company;
import com.datacoper.maven.enums.properties.EnumDCModule;
import com.datacoper.maven.metadata.EnumAttributeType;
import com.datacoper.maven.metadata.TemplateAttributeModel;

public class TableAttributes extends JTable{
	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboAttributeType = new JComboBox<>(EnumAttributeType.toStringArray());
	private JComboBox<String> comboModule = new JComboBox<>(EnumDCModule.toStringArray()); 
	
	private DefaultTableModel defaultTableModel;
	
	private Company company;
	
	private static Class<?>[] columnClasses;
	private static String[] columnNames;
	private static Boolean[] columnEditables;
	
	static {
		Object[][] columns = new Object[][] {
			{"Coluna", String.class, false},
			{"Atributo", String.class, true},
			{"Label", String.class, true},
			{"Tipo", String.class, true},
			{"Módulo", String.class, true},
			{"Obrigatório", Boolean.class, true},
			{"Atualizável", Boolean.class, true},
			{"Máscara", String.class, true},
			{"Precisão", Integer.class, false},
			{"Escala", Integer.class, false},
		};
		
		columnClasses = new Class<?>[columns.length];
		columnNames = new String[columns.length];
		columnEditables = new Boolean[columns.length];
		
		for (int i = 0; i < columns.length; i++) {
			columnNames[i] = (String)columns[i][0];
			columnClasses[i] = (Class<?>)columns[i][1];
			columnEditables[i] = (Boolean)columns[i][2];
		}
	}
	
	public TableAttributes(Company company) {
		this.company = company;
		
		defaultTableModel = new DefaultTableModel(getColumnsNames(), 0);
		
		setModel(defaultTableModel);
		
		TableColumn columnAttributes = getColumn("Tipo");
		
		columnAttributes.setCellEditor(new DefaultCellEditor(comboAttributeType));
		
		TableColumn columnModules = getColumn("Módulo");
		columnModules.setCellEditor(new DefaultCellEditor(comboModule));
	
	}

	private String[] getColumnsNames() {
		return columnNames;
	}
	
	@Override
	public Class<?> getColumnClass(int column) {
		return columnClasses[column];
	}
	
	public boolean isCellEditable(int row, int column){
		return columnEditables[column]; 
	}

	public void setRowCount(int rowCount) {
		defaultTableModel.setRowCount(rowCount);
	}

	public Vector<?> getDataVector() {
		return defaultTableModel.getDataVector();
	}

	public void addRow(String columnName, String attributeName, String attributeLabel, String columnClassName, EnumDCModule enumDCModule, Boolean nullable, String mask, int precision, int scale, boolean updatable) {
		defaultTableModel.addRow(new Object[] {columnName, attributeName, attributeLabel, columnClassName, enumDCModule != null ? enumDCModule.name() : null, nullable, updatable, mask, precision, scale});
	}

	public Set<TemplateAttributeModel> getAsTemplateAttributeModel() {
		Vector<?> dataVector = defaultTableModel.getDataVector();
		
		Set<TemplateAttributeModel> attributes = new HashSet<TemplateAttributeModel>(dataVector.size());
		
		for (Object object : dataVector) {
			
			Vector<?> rowValues = (Vector<?>) object;
			
			String columnName = (String)rowValues.get(0);
			String attributeName = (String)rowValues.get(1);
			String label = (String)rowValues.get(2);
			EnumAttributeType attributeType = EnumAttributeType.from((String)rowValues.get(3));
			
			EnumDCModule entityModule = EnumDCModule.from((String)rowValues.get(4));
			
			boolean required = (boolean)rowValues.get(5);
			boolean updatable = (boolean)rowValues.get(6);
			String mask = (String)rowValues.get(7);
			
			int precision = (int)rowValues.get(8);
			int scale = (int)rowValues.get(9);
			
			String type = attributeType.getType().getName();
			
			if(attributeType == EnumAttributeType.ENTITY) {
				if(entityModule == null) {
					throw new RuntimeException("Erro no atributo "+columnName+". Para o Tipo "+EnumAttributeType.ENTITY+" é necessário informar o Módulo.");
				}
				type = entityModule.resolveEntityType(company, attributeName);
			}
			
			attributes.add(new TemplateAttributeModel(columnName, attributeName, type, entityModule, label, mask, precision, scale, required, updatable));
		}
		
		return attributes;
		
	}
	
}
