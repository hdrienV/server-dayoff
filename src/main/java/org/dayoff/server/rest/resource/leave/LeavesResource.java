package org.dayoff.server.rest.resource.leave;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dayoff.server.rest.errorhandling.AppException;
import org.dayoff.server.rest.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 
 * Service class that handles REST requests
 * 
 */
@Component
@Path("/leaves")
public class LeavesResource {

	@Autowired
	private LeaveService leaveService;

	
	
	/*
	 * *********************************** READ ***********************************
	 */
	/**
	 * Returns all resources (leaves) from the database
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * @throws AppException
	 */
	@GET
	//@Compress //can be used only if you want to SELECTIVELY enable compression at the method level. By using the EncodingFilter everything is compressed now. 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Leave> getLeaves(
			@QueryParam("orderByEndDate") String orderByEndDate)
			throws IOException,	AppException {
		List<Leave> leaves = leaveService.getLeaves(
				orderByEndDate);
		return leaves;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getLeaveById(@PathParam("id") Long id, @QueryParam("detailed") boolean detailed)
			throws IOException,	AppException {
		Leave leaveById = leaveService.getLeaveById(id);
		return Response.status(200)
				.entity(leaveById,  new Annotation[0])
				.header("Access-Control-Allow-Headers", "X-extra-header")
				.allow("OPTIONS").build();
	}
	
	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
	


}
