package org.mi.leave.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class StaffLeave implements Serializable{

	/**
	 * serial version id
	 */
	@Transient
	private static final long serialVersionUID = -7499307220035587776L;

	@Id
	@GeneratedValue
	private long userID;

			
	@JsonFormat(pattern="yyyy-MM-dd")
	@Valid
	private Date startTime;
		
	
	@JsonFormat(pattern="yyyy-MM-dd",with=JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
	@Valid
	private Date endTime;
	
	@Column
	private String leaveReason;
	
	//backup userId
	@Column(length=10)
	private Long backup;
	
	private  LeaveType leaveType;
	
	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}


	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	


}
