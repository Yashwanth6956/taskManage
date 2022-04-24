package com.jazaSoftware.taskManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jazaSoftware.taskManager.model.Label;

@Repository
public interface LabelDao extends JpaRepository<Label, Integer> {

	public Label findLabelBylabelId(Integer id);

}
