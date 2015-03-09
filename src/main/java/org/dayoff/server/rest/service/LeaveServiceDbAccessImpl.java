package org.dayoff.server.rest.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.dayoff.server.rest.dao.LeaveDao;
import org.dayoff.server.rest.dao.LeaveEntity;
import org.dayoff.server.rest.errorhandling.AppException;
import org.dayoff.server.rest.errorhandling.CustomReasonPhraseException;
import org.dayoff.server.rest.filters.AppConstants;
import org.dayoff.server.rest.helpers.NullAwareBeanUtilsBean;
import org.dayoff.server.rest.resource.leave.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class LeaveServiceDbAccessImpl implements LeaveService {

	@Autowired
	LeaveDao LeaveDao;
		
	
	
	 // ******************** Read related methods implementation **********************		
	public List<Leave> getLeaves(String orderByEndDate) throws AppException {
		
		
		if(isOrderByEndDateParameterValid(orderByEndDate)){
			throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Please set either ASC or DESC for the orderByEndDate parameter", null , AppConstants.BLOG_POST_URL);
		}			
		List<LeaveEntity> Leaves = LeaveDao.getLeaves(orderByEndDate);
		
		return getLeavesFromEntities(Leaves);
	}

	private boolean isOrderByEndDateParameterValid(
			String orderByEndDate) {
		return orderByEndDate!=null 
				&& !("ASC".equalsIgnoreCase(orderByEndDate) || "DESC".equalsIgnoreCase(orderByEndDate));
	}
	
	public Leave getLeaveById(Long id) throws AppException {		
		LeaveEntity LeaveById = LeaveDao.getLeaveById(id);
		if(LeaveById == null){
			throw new AppException(Response.Status.NOT_FOUND.getStatusCode(), 
					404, 
					"The Leave you requested with id " + id + " was not found in the database",
					"Verify the existence of the Leave with the id " + id + " in the database",
					AppConstants.BLOG_POST_URL);			
		}
		
		return new Leave(LeaveDao.getLeaveById(id));
	}	

	private List<Leave> getLeavesFromEntities(List<LeaveEntity> LeaveEntities) {
		List<Leave> response = new ArrayList<Leave>();
		for(LeaveEntity LeaveEntity : LeaveEntities){
			response.add(new Leave(LeaveEntity));					
		}
		
		return response;
	}




	@Override
	public void generateCustomReasonPhraseException() throws CustomReasonPhraseException {		
		throw new CustomReasonPhraseException(4000, "message attached to the Custom Reason Phrase Exception");		
	}

	public void setLeaveDao(LeaveDao LeaveDao) {
		this.LeaveDao = LeaveDao;
	}
		
}
