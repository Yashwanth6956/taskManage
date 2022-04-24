package com.jazaSoftware.taskManager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jazaSoftware.taskManager.model.Label;
import com.jazaSoftware.taskManager.model.LabelResponse;
import com.jazaSoftware.taskManager.service.LabelService;

@RestController
@RequestMapping("label/api/v1")
public class LabelController {
	@Autowired
	LabelService service;

	@PostMapping("/create")
	public ResponseEntity<LabelResponse> createLabel(@RequestBody Label label) {
		Label createLabel = service.createLabel(label);
		LabelResponse labelResponse = new LabelResponse();
		labelResponse.setData(createLabel);
		labelResponse.setError(false);
		return new ResponseEntity<LabelResponse>(labelResponse, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<LabelResponse> updateLabel(@RequestBody Label label) {
		int labelId = label.getLabelId();
		Label updateLabel = service.updateLabel(labelId, label);
		LabelResponse labelResponse = new LabelResponse();
		labelResponse.setData(updateLabel);
		labelResponse.setError(false);

		return new ResponseEntity<LabelResponse>(labelResponse, HttpStatus.OK);
	}

	@DeleteMapping("/remove")
	public ResponseEntity<LabelResponse> deleteLabel(@RequestParam Integer id) {
		service.deleteLabel(id);
		LabelResponse labelResponse = new LabelResponse();
		labelResponse.setData("deleted sussfully");
		labelResponse.setError(false);

		return new ResponseEntity<LabelResponse>(labelResponse, HttpStatus.OK);

	}

	@GetMapping("/getAllLabel")
	public ResponseEntity<LabelResponse> getAll() {
		List<Label> allLabel = service.getAllLabel();
		LabelResponse labelResponse = new LabelResponse();
		labelResponse.setData(allLabel);
		return new ResponseEntity<LabelResponse>(labelResponse, HttpStatus.OK);
	}

}
