package com.shinnosuke.infra.member;

import java.util.Date;

public class MemberDto {
	
	private String memseq;
	private String memName;
	private Integer memGender;
	private String memId;
	private String memPassword;
	private String memEmail;
	private String memPhoneNum;
	private Date memReDate;
	private Date memMoDate;
	private Integer memDelNY;
	
	//----------------
	
	public String getMemseq() {
		return memseq;
	}
	public void setMemseq(String memseq) {
		this.memseq = memseq;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Integer getMemGender() {
		return memGender;
	}
	public void setMemGender(Integer memGender) {
		this.memGender = memGender;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPhoneNum() {
		return memPhoneNum;
	}
	public void setMemPhoneNum(String memPhoneNum) {
		this.memPhoneNum = memPhoneNum;
	}
	public Date getMemReDate() {
		return memReDate;
	}
	public void setMemReDate(Date memReDate) {
		this.memReDate = memReDate;
	}
	public Date getMemMoDate() {
		return memMoDate;
	}
	public void setMemMoDate(Date memMoDate) {
		this.memMoDate = memMoDate;
	}
	public Integer getMemDelNY() {
		return memDelNY;
	}
	public void setMemDelNY(Integer memDelNY) {
		this.memDelNY = memDelNY;
	}
	
	
}
