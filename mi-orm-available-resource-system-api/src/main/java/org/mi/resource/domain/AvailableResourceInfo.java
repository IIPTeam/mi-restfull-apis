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
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "available_resource")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableResourceInfo implements Serializable {

	@Transient
	private static final long serialVersionUID = -3026822034547908183L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Resources type;

	@Column
	private Float availableHour;

	@Column
	private String userCode;

	/**
	 * 过期时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Valid
	@Column
	private Date expiredTime;

	/**
	 * 资源年份，一般用于年假
	 */
	@Column
	private String availableYear;

	@Column
	private String remark;

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

	public Float getAvailableHour() {
		return availableHour;
	}

	public void setAvailableHour(Float availableHour) {
		this.availableHour = availableHour;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public String getAvailableYear() {
		return availableYear;
	}

	public void setAvailableYear(String availableYear) {
		this.availableYear = availableYear;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
