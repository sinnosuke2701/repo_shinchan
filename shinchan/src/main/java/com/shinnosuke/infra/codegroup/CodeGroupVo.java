package com.shinnosuke.infra.codegroup;

public class CodeGroupVo {

	//search
	private Integer sh_DelNY;
	private Integer sh_UseNY;
	private String sh_Value;
	private Integer sh_Option;
	
	private String sh_DateStart;
	private String sh_DateEnd;
	private Integer sh_OptionDate;
	
	//paging
	private int thisPage = 1;					//현재 페이지
	private int rowNumToShow = 5; 				//화면에 보여질 데이터 줄 갯수
	private int pageNumToShow = 5;				//화면에 보여질 페이지 번호 갯수
	
	private int totalRows;						//총 데이터 갯수	
	private int totalPages;						//총 페이지 갯수
	private int startPage;						//시작 페이지 번호
	private int endPage;						//마지막 페이지 번호
	
	private int startRnumForMysql = 0;			//시작 쿼리 row
	
	//--------------
	
	public void setParamsPaging(int totalRows) {
		
//		setThisPage(3);

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
		
		System.out.println("thispage: " + getThisPage());
		System.out.println("rowNumToShow: " + getRowNumToShow());
		System.out.println("pageNumToShow: " + getPageNumToShow());
		System.out.println("totalRows: " + getTotalRows());
		System.out.println("totalPages: " + getTotalPages());
		System.out.println("startPage: " + getStartPage());
		System.out.println("endPage: " + getEndPage());
		System.out.println("startRnumForMysql: " + getStartRnumForMysql());
	}
	
	//get , set
	
	public Integer getSh_DelNY() {
		return sh_DelNY;
	}

	public void setSh_DelNY(Integer sh_DelNY) {
		this.sh_DelNY = sh_DelNY;
	}

	public Integer getSh_UseNY() {
		return sh_UseNY;
	}

	public void setSh_UseNY(Integer sh_UseNY) {
		this.sh_UseNY = sh_UseNY;
	}

	public String getSh_Value() {
		return sh_Value;
	}

	public void setSh_Value(String sh_Value) {
		this.sh_Value = sh_Value;
	}

	public Integer getSh_Option() {
		return sh_Option;
	}

	public void setSh_Option(Integer sh_Option) {
		this.sh_Option = sh_Option;
	}

	public String getSh_DateStart() {
		return sh_DateStart;
	}

	public void setSh_DateStart(String sh_DateStart) {
		this.sh_DateStart = sh_DateStart;
	}

	public String getSh_DateEnd() {
		return sh_DateEnd;
	}

	public void setSh_DateEnd(String sh_DateEnd) {
		this.sh_DateEnd = sh_DateEnd;
	}

	public Integer getSh_OptionDate() {
		return sh_OptionDate;
	}

	public void setSh_OptionDate(Integer sh_OptionDate) {
		this.sh_OptionDate = sh_OptionDate;
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
