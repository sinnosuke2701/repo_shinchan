package com.shinnosuke.infra.code;

import java.util.Date;

public class CodeDto {
	
	private String seq;
	private String cd_Name;
	private Integer cd_UseNY;
	private Integer cd_Order;
	private String cd_Desc;
	private Date cd_ReDate;
	private Date cd_MoDate;
	private Integer cd_DelNY;
	private Integer CodeGroup_seq;
	
	//-------------
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCd_Name() {
		return cd_Name;
	}
	public void setCd_Name(String cd_Name) {
		this.cd_Name = cd_Name;
	}
	public Integer getCd_UseNY() {
		return cd_UseNY;
	}
	public void setCd_UseNY(Integer cd_UseNY) {
		this.cd_UseNY = cd_UseNY;
	}
	public Integer getCd_Order() {
		return cd_Order;
	}
	public void setCd_Order(Integer cd_Order) {
		this.cd_Order = cd_Order;
	}
	public String getCd_Desc() {
		return cd_Desc;
	}
	public void setCd_Desc(String cd_Desc) {
		this.cd_Desc = cd_Desc;
	}
	public Date getCd_ReDate() {
		return cd_ReDate;
	}
	public void setCd_ReDate(Date cd_ReDate) {
		this.cd_ReDate = cd_ReDate;
	}
	public Date getCd_MoDate() {
		return cd_MoDate;
	}
	public void setCd_MoDate(Date cd_MoDate) {
		this.cd_MoDate = cd_MoDate;
	}
	public Integer getCd_DelNY() {
		return cd_DelNY;
	}
	public void setCd_DelNY(Integer cd_DelNY) {
		this.cd_DelNY = cd_DelNY;
	}
	public Integer getCodeGroup_seq() {
		return CodeGroup_seq;
	}
	public void setCodeGroup_seq(Integer codeGroup_seq) {
		CodeGroup_seq = codeGroup_seq;
	}
	
	
	
	
}
