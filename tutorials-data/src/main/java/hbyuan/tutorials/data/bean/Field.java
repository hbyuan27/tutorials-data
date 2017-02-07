package hbyuan.tutorials.data.bean;

import java.io.Serializable;
import java.util.List;

public class Field implements Serializable {

	private static final long serialVersionUID = -6477802671163385860L;

	private Long fieldId;
	private String fieldName;
	private String type;
	private List<FieldEnumOption> enumOptions;
	private List<Field> tableFields;

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FieldEnumOption> getEnumOptions() {
		return enumOptions;
	}

	public void setEnumOptions(List<FieldEnumOption> enumOptions) {
		this.enumOptions = enumOptions;
	}

	public List<Field> getTableFields() {
		return tableFields;
	}

	public void setTableFields(List<Field> tableFields) {
		this.tableFields = tableFields;
	}

}
