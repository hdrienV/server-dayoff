package org.dayoff.server.rest.dao;

import java.util.List;


public interface LeaveDao {
	
	public List<LeaveEntity> getLeaves(String orderByInsertionDate);

	
	/**
	 * Returns a leave given its id
	 * 
	 * @param id
	 * @return
	 */
	public LeaveEntity getLeaveById(Long id);


}
