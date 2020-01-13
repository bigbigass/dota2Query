package dota2Query.util.common;

import static dota2Query.util.common.Dota2Constants.*;

public class PageModel {
	public PageModel() {}
	
	/**分页总数据条数*/
	private int recordCount;
	//当前页面
	private int pageIndex;
	//每一页分多少条数据
	private int pageSize = PAGE_DEFAULT_SIZE;
	//总页数
	private int totalSize;
	//开始查询的位置
	private int firstLimitParam;
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getFirstLimitParam() {
		return (this.getPageIndex()-1)*this.getPageSize();
	}
	public void setFirstLimitParam(int firstLimitParam) {
		this.firstLimitParam = firstLimitParam;
	}
}
