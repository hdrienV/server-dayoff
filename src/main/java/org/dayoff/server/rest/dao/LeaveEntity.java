package org.dayoff.server.rest.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;
import org.dayoff.server.rest.resource.leave.Leave;

/**
 * Leave entity 
 *
 */
@Entity
@Table(name="test")
public class LeaveEntity implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;

	/** id of the Leave */
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
		
	/** Duration of the Leave*/
	@Column(name="duration")
	private float duration;
	
		
	/** insertion date in the database */
	@Column(name="startdate")
	private Date startDate;
	
	/** insertion date in the database */
	@Column(name="enddate")
	private Date endDate;
	
	/** Duration of the Leave*/
	@Column(name="cause")
	private String cause;

	public LeaveEntity(){}
	
	
	
	public LeaveEntity(Leave Leave){
		try {
			BeanUtils.copyProperties(this, Leave);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
		
}
