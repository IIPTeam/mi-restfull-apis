package org.mi.ot.vo;

import java.io.Serializable;

public class OTResponse implements Serializable {

	private static final long serialVersionUID = 4431394762410429136L;

	private Integer code;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
