package com.bytatech.patientprescription.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.patientprescription.service.CommandService;
@RestController
@RequestMapping("/api")
public class CommandResource {
    @Autowired
	private final CommandService commandService;

    public CommandResource(CommandService commandService) {
        this.commandService = commandService;
    }
    @PostMapping("/initiate")
    public String initiates() {
    	String s= commandService.initiate();
    	   return s;
    	}
    @PostMapping("/selectChoice/{choice}/{taskId}")
    public String checkStatus(@PathVariable String taskId,@PathVariable String choice ) {
    	String res=commandService.checkStatus(taskId,choice);
    	return res;
    }
    @PostMapping("/viewPrescription/{taskId}")
    public String prescriptionAccept(@PathVariable String taskId) {
    	return "Prescription Downloaded";
    }
}
