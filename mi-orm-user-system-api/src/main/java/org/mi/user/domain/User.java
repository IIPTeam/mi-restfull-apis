package org.mi.user.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User implements Serializable{
	/**
	 * serial version id
	 */
	@Transient
	private static final long serialVersionUID = -7499307220035587776L;

	@Id
	@GeneratedValue
	private long userID;
	
	@Column(length=8,unique=true)
	private String staffID;
	
	//EHR is the mandatory unique attribute for our staff, hence turn off the update feature
	@Column(length=10,unique=true,updatable=false)
	private String EHR;
	
	@Column(length=60)
	private String chineseName;
	
	@Column(length=60)
	private String englishName;
	
	private Gendar gender;
	
	@Embedded
	private LevelInfo levelInfo;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Valid
	private Date onboardDate;
	
	@Column(length=16)
	private String phoneNumber;
	
	@Column(length=60)
	private String email;
	
	@Column(insertable=false)
	private Date createDate = Calendar.getInstance().getTime();
	
	@JsonFormat(pattern="yyyy-MM-dd",with=JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
	@Valid
	private Date deboardDate;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getEHR() {
		return EHR;
	}

	public void setEHR(String eHR) {
		EHR = eHR;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Gendar getGender() {
		return gender;
	}

	public void setGender(Gendar gender) {
		this.gender = gender;
	}

	public LevelInfo getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(LevelInfo levelInfo) {
		this.levelInfo = levelInfo;
	}

	public Date getOnboardDate() {
		return onboardDate;
	}

	public void setOnboardDate(Date onboardDate) {
		this.onboardDate = onboardDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeboardDate() {
		return deboardDate;
	}

	public void setDeboardDate(Date deboardDate) {
		this.deboardDate = deboardDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
