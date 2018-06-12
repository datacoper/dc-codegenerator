package com.datacoper.maven.ui;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.datacoper.maven.metadata.EnumAttributeType;
import com.datacoper.maven.metadata.TemplateAttributeModel;

public class TableAttributes extends JTable{
	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboAttributeType = new JComboBox<>(EnumAttributeType.types()); 
	
	private DefaultTableModel defaultTableModel;
	
	public TableAttributes() {
	
		defaultTableModel = new DefaultTableModel(getColumnsNames(), 0);
		
		setModel(defaultTableModel);
		
		TableColumn columnAttributes = getColumnModel().getColumn(3);
		
		columnAttributes.setCellEditor(new DefaultCellEditor(comboAttributeType));
	
	}

	private String[] getColumnsNames() {
		return new String[] {"Coluna", "Atributo", "Label", "Tipo", "Obrigatório", "Máscara", "Precisão", "Scala", "Atualizável"};
	}
	
	private Class<?>[] columnsClasses = new Class<?>[] {String.class, String.class, String.class, String.class, Boolean.class, String.class, Integer.class, Integer.class, Boolean.class};
	
	@Override
	public Class<?> getColumnClass(int column) {
		return columnsClasses[column];
	}
	
	public boolean isCellEditable(int row, int column){
		return column > 0 & column < 6; 
	}

	public void setRowCount(int rowCount) {
		defaultTableModel.setRowCount(rowCount);
	}

	public Vector<?> getDataVector() {
		return defaultTableModel.getDataVector();
	}

	public void addRow(String columnName, String attributeName, String attributeLabel, String columnClassName, Boolean nullable, String mask, int precision, int scale, boolean updatable) {
		defaultTableModel.addRow(new Object[] {columnName, attributeName, attributeLabel, columnClassName, nullable, mask, precision, scale, updatable});
	}

	public Set<TemplateAttributeModel> getAsTemplateAttributeModel() {
		Vector<?> dataVector = defaultTableModel.getDataVector();
		
		Set<TemplateAttributeModel> attributes = new HashSet<TemplateAttributeModel>(dataVector.size());
		
		for (Object object : dataVector) {
			
			Vector<?> rowValues = (Vector<?>) object;
			
			String name = (String)rowValues.get(1);
			String label = (String)rowValues.get(2);
			String type = (String)rowValues.get(3);
			boolean required = (boolean)rowValues.get(4);
			String mask= (String)rowValues.get(5);
			
			int precision = (int)rowValues.get(6);
			int scale = (int)rowValues.get(7);
			
			boolean updatable = (boolean)rowValues.get(8);
			
			attributes.add(new TemplateAttributeModel(name, type, label, mask, precision, scale, required, updatable));
		}
		
		return attributes;
		
	}
	
}
