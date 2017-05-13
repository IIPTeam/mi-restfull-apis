package org.mi.ot.vo;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalInfo {

	private Long businessID;
	
	private Long approver;
	
	private Long role;
	
	@Length(max = 200)
	private String reason;
	
	private Integer result;

	public Long getBusinessID() {
		return businessID;
	}

	public void setBusinessID(Long businessID) {
		this.businessID = businessID;
	}

	public Long getApprover() {
		return approver;
	}

	public void setApprover(Long approver) {
		this.approver = approver;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}
}
