package pers.minho.entity;

public class GoodsPage {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
    private Integer begin;
    private Integer totalPage;
    private Integer rows;
    private String searchName = null;
    private Integer categorize;

	public Integer getCategorize() {
		return categorize;
	}

	public void setCategorize(Integer categorize) {
		this.categorize = categorize;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Integer getCurrentPage() {
		
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getBegin() {
		begin = (this.currentPage - 1)*pageSize;
		return begin;
	}
	
	public void setBegin(int begin) {
		this.begin = begin;
	}
	
	public Integer getTotalPage() {
		totalPage = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public Integer getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
}
