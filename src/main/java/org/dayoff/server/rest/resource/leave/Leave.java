package org.dayoff.server.rest.resource.leave;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.beanutils.BeanUtils;
import org.dayoff.server.rest.dao.LeaveEntity;
import org.dayoff.server.rest.helpers.DateISO8601Adapter;

/**
 * Leave resource placeholder for json/xml representation 
 */
@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Leave implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;

	/** id of the Leave */
	@XmlElement(name = "id")	
	private Long id;
		
	/** Duration of the Leave*/
	@XmlElement(name="duration")
	private float duration;
	
		
	/** insertion date in the database */
	@XmlElement(name="startdate")
	@XmlJavaTypeAdapter(DateISO8601Adapter.class)
	private Date startDate;
	
	/** insertion date in the database */
	@XmlElement(name="enddate")
	@XmlJavaTypeAdapter(DateISO8601Adapter.class)
	private Date endDate;
	
	/** Duration of the Leave*/
	@XmlElement(name="cause")
	private String cause;

	

	public Leave(){}
	
	
	
	public Leave(LeaveEntity LeaveEntity){
		try {
			BeanUtils.copyProperties(this, LeaveEntity);
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
