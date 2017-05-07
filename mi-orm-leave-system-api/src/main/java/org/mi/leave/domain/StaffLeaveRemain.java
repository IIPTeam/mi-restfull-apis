package org.mi.leave.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class StaffLeaveRemain implements Serializable{

	/**
	 * serial version id
	 */
	@Transient
	private static final long serialVersionUID = -7499307220035587776L;

	@Id
	@GeneratedValue
	private long userID;

	private String staffName;
	
	private String leaveHours;
	

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getLeaveHours() {
		return leaveHours;
	}

	public void setLeaveHours(String leaveHours) {
		this.leaveHours = leaveHours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
