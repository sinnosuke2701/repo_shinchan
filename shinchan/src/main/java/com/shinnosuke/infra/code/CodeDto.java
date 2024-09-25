package com.shinnosuke.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeDto {
	
	private String cdseq;
	private String cd_Name;
	private Integer cd_UseNY;
	private String cd_Order;
	private String cd_Desc;
	private Date cd_ReDate;
	private Date cd_MoDate;
	private Integer cd_DelNY;
	
	private String CodeGroup_seq;
	private String cg_Name;
	//-------------
	
	//for cache 캐시
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	//get ,set
	public String getCdseq() {
		return cdseq;
	}
	public void setCdseq(String cdseq) {
		this.cdseq = cdseq;
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
	public String getCd_Order() {
		return cd_Order;
	}
	public void setCd_Order(String cd_Order) {
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
	public String getCodeGroup_seq() {
		return CodeGroup_seq;
	}
	public void setCodeGroup_seq(String codeGroup_seq) {
		CodeGroup_seq = codeGroup_seq;
	}
	public String getCg_Name() {
		return cg_Name;
	}
	public void setCg_Name(String cg_Name) {
		this.cg_Name = cg_Name;
	}
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
}
