package org.mi.project.domain;

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
@Table(name = "project")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectInfo implements Serializable {

	@Transient
	private static final long serialVersionUID = -3026822034547908183L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 10)
	private String code;

	@Column
	private String name;

	/**
	 * 项目类型：人员外包、项目外包
	 */
	@Column
	private String type;

	/**
	 * 项目级别：A级 B级 C级
	 */
	@Column
	private String level;

	/**
	 * 项目金额
	 */
	@Column
	private Long amount;
	
	/**
	 * 结算货币类型
	 */
	@Column
	private String currency;

	/**
	 * 立项时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Valid
	@Column
	private Date setupDate;

	/**
	 * 项目开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Valid
	@Column
	private Date startDate;

	/**
	 * 项目结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Valid
	@Column
	private Date endDate;

	/**
	 * 项目总监，一般为交付部经理
	 */
	@Column(length = 8)
	private String director;

	/**
	 * 所属交付部
	 */
	@Column
	private String department;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getSetupDate() {
		return setupDate;
	}

	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
