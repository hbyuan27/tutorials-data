package hbyuan.tutorials.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FIELD")
public class FieldEO implements Serializable {

	private static final long serialVersionUID = 567561867562818822L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FIELD_ID")
	private Long fieldId;

	@Column(name = "FIELD_NAME")
	private String fieldName;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<FieldEO> tableFields;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private FieldEO parent;

	@OneToMany(mappedBy = "standardField", cascade = CascadeType.PERSIST)
	private List<FieldEnumOptionEO> enumOptions;

	/**
	 * text, textarea, percent, date, link, numbering, enum, table
	 */
	@Column(name = "TYPE", nullable = false)
	private String type;

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

	public List<FieldEO> getTableFields() {
		return tableFields;
	}

	public void setTableFields(List<FieldEO> tableFields) {
		this.tableFields = tableFields;
	}

	public FieldEO getParent() {
		return parent;
	}

	public void setParent(FieldEO parent) {
		this.parent = parent;
	}

	public List<FieldEnumOptionEO> getEnumOptions() {
		return enumOptions;
	}

	public void setEnumOptions(List<FieldEnumOptionEO> enumOptions) {
		this.enumOptions = enumOptions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
