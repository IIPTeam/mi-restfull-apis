package org.mi.ot.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OTRequest {

	private OTInfo otInfo;
	
	private ApprovalInfo[] approver;

	public OTInfo getOtInfo() {
		return otInfo;
	}

	public void setOtInfo(OTInfo otInfo) {
		this.otInfo = otInfo;
	}

	public ApprovalInfo[] getApprover() {
		return approver;
	}

	public void setApprover(ApprovalInfo[] approver) {
		this.approver = approver;
	}
}
