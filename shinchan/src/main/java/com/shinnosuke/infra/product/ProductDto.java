package com.shinnosuke.infra.product;

import java.util.Date;

public class ProductDto {
	
	private String prseq;
	private String prProdName;
	private Integer prUseNY;
	private Integer prSort;
	private Integer prSize;
	private Integer prColor;
	private String prProdDesc;
	private String prReguPrice;
	private String prSalePrice;
	private Integer prInventory;
	private Date prReDate;
	private Date prMoDate;
	private Integer prDelNY;
	
	private String Product_prseq;
	private String Member_memseq;
	private String reTitle;
	private String reComment;
	private String memId;
	
	private String orseq;
	private String orName;
	private String orNum;
	private String orZipNum;
	private String orAdr;
	private String orAdrDt;
	private String orEmail;
	private String orDelivery;
	private Integer orDelNY;
	
	//------------------------------
	public String getProduct_prseq() {
		return Product_prseq;
	}
	public void setProduct_prseq(String product_prseq) {
		Product_prseq = product_prseq;
	}
	public String getMember_memseq() {
		return Member_memseq;
	}
	public void setMember_memseq(String member_memseq) {
		Member_memseq = member_memseq;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public String getReComment() {
		return reComment;
	}
	public void setReComment(String reComment) {
		this.reComment = reComment;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	//--------
	public String getPrseq() {
		return prseq;
	}
	public void setPrseq(String prseq) {
		this.prseq = prseq;
	}
	public String getPrProdName() {
		return prProdName;
	}
	public void setPrProdName(String prProdName) {
		this.prProdName = prProdName;
	}
	public Integer getPrUseNY() {
		return prUseNY;
	}
	public void setPrUseNY(Integer prUseNY) {
		this.prUseNY = prUseNY;
	}
	public Integer getPrSort() {
		return prSort;
	}
	public void setPrSort(Integer prSort) {
		this.prSort = prSort;
	}
	public Integer getPrSize() {
		return prSize;
	}
	public void setPrSize(Integer prSize) {
		this.prSize = prSize;
	}
	public Integer getPrColor() {
		return prColor;
	}
	public void setPrColor(Integer prColor) {
		this.prColor = prColor;
	}
	public String getPrProdDesc() {
		return prProdDesc;
	}
	public void setPrProdDesc(String prProdDesc) {
		this.prProdDesc = prProdDesc;
	}
	public String getPrReguPrice() {
		return prReguPrice;
	}
	public void setPrReguPrice(String prReguPrice) {
		this.prReguPrice = prReguPrice;
	}
	public String getPrSalePrice() {
		return prSalePrice;
	}
	public void setPrSalePrice(String prSalePrice) {
		this.prSalePrice = prSalePrice;
	}
	public Integer getPrInventory() {
		return prInventory;
	}
	public void setPrInventory(Integer prInventory) {
		this.prInventory = prInventory;
	}
	public Date getPrReDate() {
		return prReDate;
	}
	public void setPrReDate(Date prReDate) {
		this.prReDate = prReDate;
	}
	public Date getPrMoDate() {
		return prMoDate;
	}
	public void setPrMoDate(Date prMoDate) {
		this.prMoDate = prMoDate;
	}
	public Integer getPrDelNY() {
		return prDelNY;
	}
	public void setPrDelNY(Integer prDelNY) {
		this.prDelNY = prDelNY;
	}
	public String getOrseq() {
		return orseq;
	}
	public void setOrseq(String orseq) {
		this.orseq = orseq;
	}
	public String getOrName() {
		return orName;
	}
	public void setOrName(String orName) {
		this.orName = orName;
	}
	public String getOrNum() {
		return orNum;
	}
	public void setOrNum(String orNum) {
		this.orNum = orNum;
	}
	public String getOrZipNum() {
		return orZipNum;
	}
	public void setOrZipNum(String orZipNum) {
		this.orZipNum = orZipNum;
	}
	public String getOrAdr() {
		return orAdr;
	}
	public void setOrAdr(String orAdr) {
		this.orAdr = orAdr;
	}
	public String getOrAdrDt() {
		return orAdrDt;
	}
	public void setOrAdrDt(String orAdrDt) {
		this.orAdrDt = orAdrDt;
	}
	public String getOrEmail() {
		return orEmail;
	}
	public void setOrEmail(String orEmail) {
		this.orEmail = orEmail;
	}
	public String getOrDelivery() {
		return orDelivery;
	}
	public void setOrDelivery(String orDelivery) {
		this.orDelivery = orDelivery;
	}
	public Integer getOrDelNY() {
		return orDelNY;
	}
	public void setOrDelNY(Integer orDelNY) {
		this.orDelNY = orDelNY;
	}

}
