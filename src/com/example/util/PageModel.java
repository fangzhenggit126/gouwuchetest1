package com.example.util;

public class PageModel {
   private static final int ResultLimit=4;    //ÿҳ������ʾ������
   private int ResultCount;                   //�ܼ�¼����
   private int pageIndex;                    //��ǰҳ���ҳ��
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
	//��ȡSQL��limit������������е���ʼ���� select * from goods limit StartPosition,ResultLimit
	public int getStartPosition()
	{
		return (pageIndex-1)*ResultLimit;
	}
	//��ȡ��ҳ�����ҳ��
	public int getPageTotal()
	{
		return (ResultCount%ResultLimit)==0?(ResultCount/ResultLimit):(ResultCount/ResultLimit+1);
	}
}
