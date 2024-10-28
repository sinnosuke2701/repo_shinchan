package com.shinnosuke.infra.product;

import java.math.BigDecimal;
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
	private Integer reStar;
	private String memId;
	
	private String pmSeq;
	private String pmName;
	private String pmNum;
	private String pmZipNum;
	private String pmAdr;
	private String pmAdrDt;
	private String pmEmail;
	private String pmDelivery;
	private Integer pmDelNY;
	
	//------------------------------
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
	public String getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(String pmSeq) {
		this.pmSeq = pmSeq;
	}
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	public String getPmNum() {
		return pmNum;
	}
	public void setPmNum(String pmNum) {
		this.pmNum = pmNum;
	}
	public String getPmZipNum() {
		return pmZipNum;
	}
	public void setPmZipNum(String pmZipNum) {
		this.pmZipNum = pmZipNum;
	}
	public String getPmAdr() {
		return pmAdr;
	}
	public void setPmAdr(String pmAdr) {
		this.pmAdr = pmAdr;
	}
	public String getPmAdrDt() {
		return pmAdrDt;
	}
	public void setPmAdrDt(String pmAdrDt) {
		this.pmAdrDt = pmAdrDt;
	}
	public String getPmEmail() {
		return pmEmail;
	}
	public void setPmEmail(String pmEmail) {
		this.pmEmail = pmEmail;
	}
	public String getPmDelivery() {
		return pmDelivery;
	}
	public void setPmDelivery(String pmDelivery) {
		this.pmDelivery = pmDelivery;
	}
	public Integer getPmDelNY() {
		return pmDelNY;
	}
	public void setPmDelNY(Integer pmDelNY) {
		this.pmDelNY = pmDelNY;
	}
	public Integer getReStar() {
		return reStar;
	}
	public void setReStar(Integer reStar) {
		this.reStar = reStar;
	}
}
