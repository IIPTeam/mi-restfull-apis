package org.mi.resource.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pending_resource")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PendingResourceInfo implements Serializable {

	@Transient
	private static final long serialVersionUID = -3026822034547908183L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Resources type;

	@Column
	private Float pendingHour;

	@Column
	private String userCode;

	@Column(updatable = false)
	private Date createTime = Calendar.getInstance().getTime();

	@Column
	private Date modifyTime = Calendar.getInstance().getTime();

	@Version
	private long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Resources getType() {
		return type;
	}

	public void setType(Resources type) {
		this.type = type;
	}

	public Float getPendingHour() {
		return pendingHour;
	}

	public void setPendingHour(Float pendingHour) {
		this.pendingHour = pendingHour;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
