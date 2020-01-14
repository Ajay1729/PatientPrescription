package com.bytatech.patientprescription.service.impl;


import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytatech.patientprescription.client.activiti.api.FormsApi;
import com.bytatech.patientprescription.client.activiti.api.ProcessInstancesApi;
import com.bytatech.patientprescription.client.activiti.model.ProcessInstanceCreateRequest;
import com.bytatech.patientprescription.client.activiti.model.ProcessInstanceResponse;
import com.bytatech.patientprescription.client.activiti.model.RestFormProperty;
import com.bytatech.patientprescription.client.activiti.model.RestVariable;
import com.bytatech.patientprescription.client.activiti.model.SubmitFormRequest;
import com.bytatech.patientprescription.service.CommandService;
@Service
@Transactional
public class CommandServiceImpl implements CommandService {

    private final Logger log = LoggerFactory.getLogger(CommandServiceImpl.class);
    @Autowired
    private ProcessInstancesApi processInstanceApi;
    @Autowired
    private FormsApi formsApi;
    @Override
	public String initiate() {
		ProcessInstanceCreateRequest processInstanceCreateRequest=new ProcessInstanceCreateRequest();
   		 List<RestVariable> variables=new ArrayList<RestVariable>(); 
   		processInstanceCreateRequest.setProcessDefinitionId("PrescriptionAccception:4:10034");
   		log.info("*****************************************************"+processInstanceCreateRequest.getProcessDefinitionId());
   		RestVariable driverRestVariable=new RestVariable();
   		driverRestVariable.setName("patient");
   		driverRestVariable.setType("string");
   		driverRestVariable.setValue("patient");
   		
   		variables.add(driverRestVariable);
   		processInstanceCreateRequest.setVariables(variables);
   		ResponseEntity<ProcessInstanceResponse> processInstanceResponse = processInstanceApi.createProcessInstance(processInstanceCreateRequest);
		String processInstanceId = processInstanceResponse.getBody().getId();
		String processDefinitionId = processInstanceCreateRequest.getProcessDefinitionId();
		log.info("++++++++++++++++processDefinitionId++++++++++++++++++"+ processDefinitionId);
		log.info("++++++++++++++++ProcessInstanceId is+++++++++++++ " + processInstanceId);
		
   		processInstanceApi.createProcessInstance(processInstanceCreateRequest);
   		
		
		return processInstanceId;
	}
    @Override
	public String checkStatus(String taskId,String choice){
		log .info("into ====================customerStatus()");
   		List<RestFormProperty>formProperties=new ArrayList<RestFormProperty>();
   		SubmitFormRequest submitFormRequest = new SubmitFormRequest();
   		submitFormRequest.setAction("completed");
   		submitFormRequest.setTaskId(taskId);
		 RestFormProperty statusFormProperty = new RestFormProperty();
   		statusFormProperty.setId("choice");
   		statusFormProperty.setName("choice");
   		statusFormProperty.setType("String");
   		statusFormProperty.setReadable(true);
   		 statusFormProperty.setValue(choice);
   		formProperties.add(statusFormProperty);
   		 submitFormRequest.setProperties(formProperties); 
   		formsApi.submitForm(submitFormRequest);
   		 
		String res="";
		if(choice.equals("Accept")) {
    		res="Prescription Accepted";
    	}
    	else {
    		res="Prescription Rejected";
    	}
    	return res;
	}
}
