package com.datacoper.maven.metadata;

import java.util.HashSet;
import java.util.Set;

public class TemplateModelDetail {

	private String entityName;

	private Set<TemplateAttributeModel> attributes = new HashSet<>();

	public TemplateModelDetail() {
	}

	public TemplateModelDetail(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityName() {
		return entityName;
	}

	public Set<TemplateAttributeModel> getAttributes() {
		return attributes;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setAttributes(Set<TemplateAttributeModel> attributes) {
		this.attributes = attributes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemplateModelDetail other = (TemplateModelDetail) obj;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

}
