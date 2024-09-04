package com.shinnosuke.infra.member;

import java.util.Date;

public class MemberDto {
	
	private String seq;
	private Integer mem_Authority;
	private String mem_Name;
	private String mem_Id;
	private String mem_Password;
	private String mem_Gender;
	private Integer mem_Birth;
	private String mem_Email;
	private String mem_Phone;
	private String mem_Desc;
	private Date mem_ReDate;
	private Date mem_MoDate;
	private Integer mem_DelNY;
	
	//----------------
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getMem_Authority() {
		return mem_Authority;
	}
	public void setMem_Authority(Integer mem_Authority) {
		this.mem_Authority = mem_Authority;
	}
	public String getMem_Name() {
		return mem_Name;
	}
	public void setMem_Name(String mem_Name) {
		this.mem_Name = mem_Name;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public String getMem_Password() {
		return mem_Password;
	}
	public void setMem_Password(String mem_Password) {
		this.mem_Password = mem_Password;
	}
	public String getMem_Gender() {
		return mem_Gender;
	}
	public void setMem_Gender(String mem_Gender) {
		this.mem_Gender = mem_Gender;
	}
	public Integer getMem_Birth() {
		return mem_Birth;
	}
	public void setMem_Birth(Integer mem_Birth) {
		this.mem_Birth = mem_Birth;
	}
	public String getMem_Email() {
		return mem_Email;
	}
	public void setMem_Email(String mem_Email) {
		this.mem_Email = mem_Email;
	}
	public String getMem_Phone() {
		return mem_Phone;
	}
	public void setMem_Phone(String mem_Phone) {
		this.mem_Phone = mem_Phone;
	}
	public String getMem_Desc() {
		return mem_Desc;
	}
	public void setMem_Desc(String mem_Desc) {
		this.mem_Desc = mem_Desc;
	}
	public Date getMem_ReDate() {
		return mem_ReDate;
	}
	public void setMem_ReDate(Date mem_ReDate) {
		this.mem_ReDate = mem_ReDate;
	}
	public Date getMem_MoDate() {
		return mem_MoDate;
	}
	public void setMem_MoDate(Date mem_MoDate) {
		this.mem_MoDate = mem_MoDate;
	}
	public Integer getMem_DelNY() {
		return mem_DelNY;
	}
	public void setMem_DelNY(Integer mem_DelNY) {
		this.mem_DelNY = mem_DelNY;
	}
	
	
}
