package com.jazaSoftware.taskManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LABEL")
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "label_id")
	private int labelId;

	@Column(name = "label_name")
	private String labelName;

	public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

}
