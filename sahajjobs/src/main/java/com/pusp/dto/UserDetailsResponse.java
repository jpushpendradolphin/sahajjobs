package com.pusp.dto;

public class UserDetailsResponse {
	private String fName;
	private String lName;
	private String email;
	private String loc;
	private String skills;
	private String industry;
	private long mobileNo;
	private int experience;
	private String successMsg;
	private String errorMsg;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

}
