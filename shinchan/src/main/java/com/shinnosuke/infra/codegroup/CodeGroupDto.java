package com.shinnosuke.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	
	private String seq;
	private String cg_Name;
	private Integer cg_UseNY;
	private Integer cg_Order;
	private String cg_Desc;
	private Date cg_ReDate;
	private Date cg_MoDate;
	private Integer cg_DelNY;
	
	//----------
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCg_Name() {
		return cg_Name;
	}
	public void setCg_Name(String cg_Name) {
		this.cg_Name = cg_Name;
	}
	public Integer getCg_UseNY() {
		return cg_UseNY;
	}
	public void setCg_UseNY(Integer cg_UseNY) {
		this.cg_UseNY = cg_UseNY;
	}
	public Integer getCg_Order() {
		return cg_Order;
	}
	public void setCg_Order(Integer cg_Order) {
		this.cg_Order = cg_Order;
	}
	public String getCg_Desc() {
		return cg_Desc;
	}
	public void setCg_Desc(String cg_Desc) {
		this.cg_Desc = cg_Desc;
	}
	public Date getCg_ReDate() {
		return cg_ReDate;
	}
	public void setCg_ReDate(Date cg_ReDate) {
		this.cg_ReDate = cg_ReDate;
	}
	public Date getCg_MoDate() {
		return cg_MoDate;
	}
	public void setCg_MoDate(Date cg_MoDate) {
		this.cg_MoDate = cg_MoDate;
	}
	public Integer getCg_DelNY() {
		return cg_DelNY;
	}
	public void setCg_DelNY(Integer cg_DelNY) {
		this.cg_DelNY = cg_DelNY;
	}
	
	
	
}
