package com.jazaSoftware.taskManager.service;

import java.util.List;
import com.jazaSoftware.taskManager.model.Label;

public interface LabelService {
	public Label createLabel(Label label);

	public Label updateLabel(int id, Label label);

	public void deleteLabel(Integer id);

	public List<Label> getAllLabel();

}
