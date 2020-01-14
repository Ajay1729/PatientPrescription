package com.bytatech.patientprescription.service;


public interface CommandService {
	  String initiate();
	  String  checkStatus(String taskId, String choice);
}
