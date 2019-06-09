package com.example.util;

public class PageModel {
   private static final int ResultLimit=4;    //每页限制显示的条数
   private int ResultCount;                   //总记录条数
   private int pageIndex;                    //当前页面的页码
	public int getResultCount() {
		return ResultCount;
	}
	public void setResultCount(int resultCount) {
		ResultCount = resultCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public static int getResultlimit() {
		return ResultLimit;
	}
	//获取SQL的limit语句两个参数中的起始参数 select * from goods limit StartPosition,ResultLimit
	public int getStartPosition()
	{
		return (pageIndex-1)*ResultLimit;
	}
	//获取分页后的总页数
	public int getPageTotal()
	{
		return (ResultCount%ResultLimit)==0?(ResultCount/ResultLimit):(ResultCount/ResultLimit+1);
	}
}
