package org.mi.user.vo;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserView {

	private long userID;

	private String staffID;

	// EHR is the mandatory unique attribute for our staff, hence turn off the
	// update feature
	private String EHR;

	@NotNull
	@Length(min = 1, max = 60)
	private String chineseName;

	private String englishName;

	private Gendar gender;

	@Valid
	private LevelInfo levelInfo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date onboardDate;

	private String phoneNumber;

	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd")
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
