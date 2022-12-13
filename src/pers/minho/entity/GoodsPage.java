package pers.minho.entity;

public class GoodsPage {
    private int currentPage = 1;
    private int pageSize = 5;
    private int begin;
    private int totalPage;
    private int rows;
    private String searchName = null;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public int getCurrentPage() {
		
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getBegin() {
		begin = (this.currentPage - 1)*pageSize;
		return begin;
	}
	
	public void setBegin(int begin) {
		this.begin = begin;
	}
	
	public int getTotalPage() {
		totalPage = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
}
