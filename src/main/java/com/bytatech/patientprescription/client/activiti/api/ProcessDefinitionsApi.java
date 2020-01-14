/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.patientprescription.client.activiti.api;

import com.bytatech.patientprescription.client.activiti.model.BpmnModel;
import com.bytatech.patientprescription.client.activiti.model.DataResponse;
import com.bytatech.patientprescription.client.activiti.model.ProcessDefinitionActionRequest;
import com.bytatech.patientprescription.client.activiti.model.ProcessDefinitionResponse;
import com.bytatech.patientprescription.client.activiti.model.RestIdentityLink;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-11T15:36:26.002+05:30[Asia/Colombo]")

@Api(value = "ProcessDefinitions", description = "the ProcessDefinitions API")
public interface ProcessDefinitionsApi {

    @ApiOperation(value = "Add a candidate starter to a process definition", nickname = "createIdentityLink", notes = "## For a User   ```JSON {   \"user\" : \"kermit\" } ```  ## For a Group   ```JSON {   \"groupId\" : \"sales\" } ```", response = RestIdentityLink.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RestIdentityLink.class),
        @ApiResponse(code = 201, message = "Indicates the process definition was found and the identity link was created."),
        @ApiResponse(code = 400, message = "Indicates the body doesn't contains the correct information."),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/identitylinks",
        produces = "application/json", 
        method = RequestMethod.POST)
    ResponseEntity<RestIdentityLink> createIdentityLink(@ApiParam(value = "The id of the process definition.",required=true) @PathVariable("processDefinitionId") String processDefinitionId,@ApiParam(value = ""  )  @Valid @RequestBody RestIdentityLink restIdentityLink);


    @ApiOperation(value = "Delete a candidate starter from a process definition", nickname = "deleteIdentityLink", notes = "", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Indicates the process definition was found and the identity link was removed. The response body is intentionally empty."),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found or the process definition doesn�t have an identity-link that matches the url.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteIdentityLink(@ApiParam(value = "The id of the process definition.",required=true) @PathVariable("processDefinitionId") String processDefinitionId,@ApiParam(value = "Either users or groups, depending on the type of identity link.",required=true) @PathVariable("family") String family,@ApiParam(value = "Either the user or group of the identity to remove as candidate starter.",required=true) @PathVariable("identityId") String identityId);


    @ApiOperation(value = "Execute actions for a process definition (Update category, Suspend or Activate)", nickname = "executeProcessDefinitionAction", notes = "## Update category for a process definition   ```JSON {   \"category\" : \"updatedcategory\" } ```   ## Suspend a process definition  ```JSON  {   \"action\" : \"suspend\",   \"includeProcessInstances\" : \"false\",   \"date\" : \"2013-04-15T00:42:12Z\" } ```   ## Activate a process definition  ```JSON  {   \"action\" : \"activate\",   \"includeProcessInstances\" : \"true\",   \"date\" : \"2013-04-15T00:42:12Z\" } ```", response = ProcessDefinitionResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates action has been executed for the specified process. (category altered, activate or suspend)", response = ProcessDefinitionResponse.class),
        @ApiResponse(code = 400, message = "Indicates no category was defined in the request body."),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found."),
        @ApiResponse(code = 409, message = "Indicates the requested process definition is already suspended or active.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}",
        produces = "application/json", 
        method = RequestMethod.PUT)
    ResponseEntity<ProcessDefinitionResponse> executeProcessDefinitionAction(@ApiParam(value = "",required=true) @PathVariable("processDefinitionId") String processDefinitionId,@ApiParam(value = "" ,required=true )  @Valid @RequestBody ProcessDefinitionActionRequest processDefinitionActionRequest);


    @ApiOperation(value = "Get a process definition BPMN model", nickname = "getBpmnModelResource", notes = "", response = BpmnModel.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates the process definition was found and the model is returned. The response contains the full process definition model.", response = BpmnModel.class),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/model",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<BpmnModel> getBpmnModelResource(@ApiParam(value = "The id of the process definition to get the model for.",required=true) @PathVariable("processDefinitionId") String processDefinitionId);


    @ApiOperation(value = "Get a candidate starter from a process definition", nickname = "getIdentityLink", notes = "", response = RestIdentityLink.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = RestIdentityLink.class),
        @ApiResponse(code = 204, message = "Indicates the process definition was found and the identity link was returned."),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found or the process definition doesn�t have an identity-link that matches the url.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<RestIdentityLink> getIdentityLink(@ApiParam(value = "The id of the process definition.",required=true) @PathVariable("processDefinitionId") String processDefinitionId,@ApiParam(value = "Either users or groups, depending on the type of identity link.",required=true) @PathVariable("family") String family,@ApiParam(value = "Either the user or group of the identity to get as candidate starter.",required=true) @PathVariable("identityId") String identityId);


    @ApiOperation(value = "Get all candidate starters for a process-definition", nickname = "getIdentityLinks", notes = "", response = RestIdentityLink.class, responseContainer = "List", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates the process definition was found and the requested identity links are returned.", response = RestIdentityLink.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/identitylinks",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<List<RestIdentityLink>> getIdentityLinks(@ApiParam(value = "The id of the process definition to get the identity links for.",required=true) @PathVariable("processDefinitionId") String processDefinitionId);


    @ApiOperation(value = "Get a process definition image", nickname = "getModelResource", notes = "", response = byte[].class, responseContainer = "List", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates request was successful and the process-definitions are returned", response = byte[].class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/image",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<byte[]>> getModelResource(@ApiParam(value = "",required=true) @PathVariable("processDefinitionId") String processDefinitionId);


    @ApiOperation(value = "Get a process definition", nickname = "getProcessDefinition", notes = "", response = ProcessDefinitionResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates request was successful and the process-definitions are returned", response = ProcessDefinitionResponse.class),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<ProcessDefinitionResponse> getProcessDefinition(@ApiParam(value = "The id of the process definition to get.",required=true) @PathVariable("processDefinitionId") String processDefinitionId);


    @ApiOperation(value = "Get a process definition resource content", nickname = "getProcessDefinitionResource", notes = "", response = byte[].class, responseContainer = "List", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates both process definition and resource have been found and the resource data has been returned.", response = byte[].class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Indicates the requested process definition was not found or there is no resource with the given id present in the process definition. The status-description contains additional information.") })
    @RequestMapping(value = "/repository/process-definitions/{processDefinitionId}/resourcedata",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<byte[]>> getProcessDefinitionResource(@ApiParam(value = "The id of the process definition to get the resource data for.",required=true) @PathVariable("processDefinitionId") String processDefinitionId);


    @ApiOperation(value = "List of process definitions", nickname = "getProcessDefinitions", notes = "", response = DataResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Process Definitions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates request was successful and the process-definitions are returned", response = DataResponse.class),
        @ApiResponse(code = 400, message = "Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.") })
    @RequestMapping(value = "/repository/process-definitions",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<DataResponse> getProcessDefinitions(@ApiParam(value = "Only return process definitions with the given version.") @Valid @RequestParam(value = "version", required = false) Integer version,@ApiParam(value = "Only return process definitions with the given name.") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "Only return process definitions with a name like the given name.") @Valid @RequestParam(value = "nameLike", required = false) String nameLike,@ApiParam(value = "Only return process definitions with the given key.") @Valid @RequestParam(value = "key", required = false) String key,@ApiParam(value = "Only return process definitions with a name like the given key.") @Valid @RequestParam(value = "keyLike", required = false) String keyLike,@ApiParam(value = "Only return process definitions with the given resource name.") @Valid @RequestParam(value = "resourceName", required = false) String resourceName,@ApiParam(value = "Only return process definitions with a name like the given resource name.") @Valid @RequestParam(value = "resourceNameLike", required = false) String resourceNameLike,@ApiParam(value = "Only return process definitions with the given category.") @Valid @RequestParam(value = "category", required = false) String category,@ApiParam(value = "Only return process definitions with a category like the given name.") @Valid @RequestParam(value = "categoryLike", required = false) String categoryLike,@ApiParam(value = "Only return process definitions which don�t have the given category.") @Valid @RequestParam(value = "categoryNotEquals", required = false) String categoryNotEquals,@ApiParam(value = "Only return process definitions with the given category.") @Valid @RequestParam(value = "deploymentId", required = false) String deploymentId,@ApiParam(value = "Only return process definitions which are part of a deployment with the given id.") @Valid @RequestParam(value = "startableByUser", required = false) String startableByUser,@ApiParam(value = "Only return the latest process definition versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response.") @Valid @RequestParam(value = "latest", required = false) Boolean latest,@ApiParam(value = "If true, only returns process definitions which are suspended. If false, only active process definitions (which are not suspended) are returned.") @Valid @RequestParam(value = "suspended", required = false) Boolean suspended,@ApiParam(value = "Property to sort on, to be used together with the order.", allowableValues = "name, id, key, category, deploymentId, version") @Valid @RequestParam(value = "sort", required = false) String sort);

}
