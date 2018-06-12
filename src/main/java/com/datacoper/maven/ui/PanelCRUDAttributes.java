package com.datacoper.maven.ui;

import java.awt.BorderLayout;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.datacoper.cooperate.arquitetura.client.layout.VerticalFlowLayout;
import com.datacoper.cooperate.arquitetura.common.beans.BeanUtil;
import com.datacoper.cooperate.arquitetura.common.util.DateUtil;
import com.datacoper.cooperate.arquitetura.common.util.Entry;
import com.datacoper.maven.metadata.TemplateAttributeModel;
import com.datacoper.maven.metadata.TemplateModel;
import com.datacoper.maven.metadata.TemplateModelDetail;
import com.datacoper.maven.util.ColumnNameResolver;
import com.datacoper.maven.util.StringUtil;
import com.datacoper.testes.persistence.PersistenceProperties;
import com.datacoper.testes.persistence.PersistenceProperties.DBType;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class PanelCRUDAttributes extends AbstractCRUDPanelWizard {
	private static final long serialVersionUID = 1L;
	
	private PanelCRUDClasses panelCRUDClasses;
	
	private Map<String, TableAttributes> tablesAttributes = new HashMap<String, TableAttributes>();
	
	private JPanel container = new JPanel();
	
	public PanelCRUDAttributes(TemplateModel templateModel) {
		super(templateModel);
		
		VerticalFlowLayout verticalLayout = new VerticalFlowLayout();
		verticalLayout.setVgap(2);
		container.setLayout(verticalLayout);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(container), BorderLayout.CENTER);
		
		panelCRUDClasses = new PanelCRUDClasses(templateModel);
		
	}

	public void init() {
		TemplateModel templateModel = getTemplateModel();
		String entityName = templateModel.getEntityName();
		
		container.removeAll();
		tablesAttributes.clear();
		
		if(entityName != null) {
			
			TableAttributes tableAttributes = createAndAddTableAttribute(entityName);
			
			PersistenceProperties persistenceProperties = new PersistenceProperties(DBType.PHYSICAL, templateModel.getProjectParentFile().getAbsolutePath()+File.separator);
			
			try (Connection connection = DriverManager.getConnection(persistenceProperties.url, persistenceProperties.user, persistenceProperties.password)){
				
				populateAttributes(entityName, connection, tableAttributes);
				
				for (TemplateModelDetail entityDetail: templateModel.getDetails()) {
					
					TableAttributes tableAttributesDetail = createAndAddTableAttribute(entityDetail.getEntityName());
					
					populateAttributes(entityDetail.getEntityName(), connection, tableAttributesDetail);
					
				}
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		}
		
		revalidate();
		repaint();
		
	}

	private TableAttributes createAndAddTableAttribute(String entityName) {
		TableAttributes tableAttributes = new TableAttributes();
		
		container.add(new JLabel(entityName));
		container.add(new JScrollPane(tableAttributes));
		
		tablesAttributes.put(entityName, tableAttributes);
		
		return tableAttributes;
		
	}

	private void populateAttributes(String entityName, Connection connection, TableAttributes tableAttributes) throws SQLException {
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
					
					Boolean nullable = metaData.isNullable(i) == 1;
					
					int precision = metaData.getPrecision(i);
					int scale = metaData.getScale(i);
					
					columnClassName = replaceColumnClassName(columnClassName, precision ,scale);
					
					String mask = getMascaraDefault(columnClassName);
					
					boolean updatable = isUpdatable(attributeName);
					
					tableAttributes.addRow(columnName, attributeName, attributeLabel, columnClassName, !nullable, mask, precision, scale, updatable);
					
				}
				
			}
			
		}
	}
	
	private boolean isUpdatable(String attributeName) {
		attributeName = attributeName.toUpperCase();
		return  !attributeName.equals("CODIGO") &&
				!attributeName.equals("IDGRUPOEMPRESARIAL") &&
				!attributeName.equals("IDFILIAL") &&
				!attributeName.equals("IDEMPRESA") &&
				!attributeName.equals("IDUSUARIO") &&
				!attributeName.contains("DATA") &&
				!attributeName.contains("FLAG");
		
	}

	private String replaceColumnClassName(String columnClassName, int precision, int scale) {
		if(BigDecimal.class.getName().equals(columnClassName) && !(scale > 0)) {
			
			if(precision == 1) {
				return Boolean.class.getName();
			}
			return Long.class.getName();
		}
		return columnClassName;
	}

	private Class<?> tryCreateClass(String className){
		try {
			return BeanUtil.createClass(className);
		}catch (Exception e) {
			return null;
		}
	}
	
	private String getMascaraDefault(String columnClassName) {
		
		Class<?> typeClass = tryCreateClass(columnClassName);
		
		if(typeClass != null) {
			if(Date.class.isAssignableFrom(typeClass)) {
				return DateUtil.DDMMYYYYHHMMSS.toPattern();
			}
		}
		return null;
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
		
		TemplateModel templateModel = getTemplateModel();
		
		Set<TemplateAttributeModel> attributes = tablesAttributes.get(templateModel.getEntityName()).getAsTemplateAttributeModel();		
		templateModel.setAttributes(attributes);
		
		Set<TemplateModelDetail> details = templateModel.getDetails();
		
		for (TemplateModelDetail templateModelDetail : details) {
			TableAttributes tableAttributesDetail = tablesAttributes.get(templateModelDetail.getEntityName());
			
			templateModelDetail.setAttributes(tableAttributesDetail.getAsTemplateAttributeModel());
			
		}
		
		panelCRUDClasses.init();
	}

	@Override
	void onFinish() {
	}

}
