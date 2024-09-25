package com.shinnosuke.infra.product;

public class ProductVo {
	
	//검색조
	private Integer shDelNY;
	private Integer shUseNY;
	private Integer shSort;
	private String shValue;
	private Integer shOption;
	
	private Integer shOptionDate;
	private String shStartDate;
	private String shEndDate;
	
	//페이징
	private int thisPage = 1;				//현재 페이지
	private int rowNumToShow = 5;			//화면에 보여질 데이터 갯수
	private int pageNumToShow = 5;			//화면에 보여질 페이지 갯수
	
	private int totalRows;					//전체 데이터 수
	private int totalPages;					//전체 페이지 번호
	private int startPage;					//시작 페이지 번호
	private int endPage;					//마지막 페이지 번호
	
	private int startRnumForMysql = 0;		//쿼리 시작 row
	
	//----------
	
	public void setParamsPaging(int totalRows) {
		
	//setThisPage(3);

	setTotalRows(totalRows);

	if (getTotalRows() == 0) {
		setTotalPages(1);
	} else {
		setTotalPages(getTotalRows() / getRowNumToShow());
	}

	if (getTotalRows() % getRowNumToShow() > 0) {
		setTotalPages(getTotalPages() + 1);
	}

	if (getTotalPages() < getThisPage()) {
		setThisPage(getTotalPages());
	}
		
	setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

	setEndPage(getStartPage() + getPageNumToShow() - 1);

	if (getEndPage() > getTotalPages()) {
		setEndPage(getTotalPages());
	}
		
	if (thisPage == 1) {
		setStartRnumForMysql(0);
	} else {
		setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
	}
	System.out.println("thispage: " + getThisPage());
	System.out.println("rowNumToShow: " + getRowNumToShow());
	System.out.println("pageNumToShow: " + getPageNumToShow());
	System.out.println("totalRows: " + getTotalRows());
	System.out.println("totalPages: " + getTotalPages());
	System.out.println("startPage: " + getStartPage());
	System.out.println("endPage: " + getEndPage());
	System.out.println("startRnumForMysql: " + getStartRnumForMysql());
	System.out.println("df" + getStartRnumForMysql());	
}
	
	// get , set
	public Integer getShDelNY() {
		return shDelNY;
	}

	public void setShDelNY(Integer shDelNY) {
		this.shDelNY = shDelNY;
	}

	public Integer getShUseNY() {
		return shUseNY;
	}

	public void setShUseNY(Integer shUseNY) {
		this.shUseNY = shUseNY;
	}

	public Integer getShSort() {
		return shSort;
	}

	public void setShSort(Integer shSort) {
		this.shSort = shSort;
	}

	public String getShValue() {
		return shValue;
	}

	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public Integer getShOption() {
		return shOption;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public Integer getShOptionDate() {
		return shOptionDate;
	}

	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}

	public String getShStartDate() {
		return shStartDate;
	}

	public void setShStartDate(String shStartDate) {
		this.shStartDate = shStartDate;
	}

	public String getShEndDate() {
		return shEndDate;
	}

	public void setShEndDate(String shEndDate) {
		this.shEndDate = shEndDate;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}


	
	
	
}
