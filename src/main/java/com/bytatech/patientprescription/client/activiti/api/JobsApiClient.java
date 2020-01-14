package com.bytatech.patientprescription.client.activiti.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.bytatech.patientprescription.client.activiti.ClientConfiguration;

@FeignClient(name="${activiti.name:activiti}", url="${activiti.url:http://localhost:8080/activiti-rest/service}", configuration = ClientConfiguration.class)
public interface JobsApiClient extends JobsApi {
}