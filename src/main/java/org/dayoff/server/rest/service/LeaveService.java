package org.dayoff.server.rest.service;

import java.util.List;

import org.dayoff.server.rest.errorhandling.AppException;
import org.dayoff.server.rest.errorhandling.CustomReasonPhraseException;
import org.dayoff.server.rest.resource.leave.Leave;


public interface LeaveService {
	
	
	/*
	 ******************** Read related methods ********************
	  */ 	
	/**
	 * 
	 * @param orderByEndDate - if set, it represents the order by criteria (ASC or DESC) for displaying leave
	 * @return list with leaves corresponding to search criterias
	 * @throws AppException
	 */
	public List<Leave> getLeaves(String orderByEndDate) throws AppException;
	
	/**
	 * Returns a leave given its id
	 * 
	 * @param id
	 * @return
	 * @throws AppException 
	 */
	public Leave getLeaveById(Long id) throws AppException;


	
	/**
	 * Empty method generating a Business Exception
	 * @throws CustomReasonPhraseException
	 */
	public void generateCustomReasonPhraseException() throws CustomReasonPhraseException;

}
