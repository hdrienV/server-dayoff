package org.dayoff.server.rest.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

public class LeaveDaoJPA2Impl implements LeaveDao {

	@PersistenceContext(unitName="demoRestPersistence")
	private EntityManager entityManager;


	
	public List<LeaveEntity> getLeaves(String orderByEndDate) {
		String sqlString = null;
		if(orderByEndDate != null){
			sqlString = "SELECT p.id, p.duration, p.startDate FROM LeaveEntity p" + " ORDER BY p.endDate " + orderByEndDate;
		} else {
			sqlString = "SELECT p FROM LeaveEntity p";
		}		 
		TypedQuery<LeaveEntity> query = entityManager.createQuery(sqlString, LeaveEntity.class);		

		return query.getResultList();
	}

	
	public LeaveEntity getLeaveById(Long id) {
		
		try {
			String qlString = "SELECT p FROM LeaveEntity p WHERE p.id = ?1";
			TypedQuery<LeaveEntity> query = entityManager.createQuery(qlString, LeaveEntity.class);		
			query.setParameter(1, id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}



}
