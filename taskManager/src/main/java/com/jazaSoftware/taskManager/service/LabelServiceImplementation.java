package com.jazaSoftware.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jazaSoftware.taskManager.dao.LabelDao;
import com.jazaSoftware.taskManager.model.Label;

@Service
public class LabelServiceImplementation implements LabelService {

	@Autowired
	LabelDao dao;

	@Override
	public Label createLabel(Label label) {
		if (label != null) {
			return dao.save(label);
		} else {
			throw new RuntimeException("something went wrong");

		}
	}

	@Override
	public Label updateLabel(int id, Label label) {
		Label findLabelBylabelId = dao.findLabelBylabelId(id);
		if (findLabelBylabelId != null) {
			return dao.save(label);
		} else {
			throw new RuntimeException("something went wrong");

		}

	}

	@Override
	public void deleteLabel(Integer id) {
		if (id != null) {
			dao.deleteById(id);
		} else {
			throw new RuntimeException("something went wrong");

		}
	}

	@Override
	public List<Label> getAllLabel() {
		if (dao.findAll() != null) {
			return dao.findAll();
		} else {
			throw new RuntimeException("no label found");

		}

	}

}
