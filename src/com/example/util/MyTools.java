package com.example.util;

public class MyTools {
	/***
	 * 解决中文乱码
	 * @param str
	 * @return
	 */
	public static String toChinese(String str)
	{
		if(str==null)
		{
			str="";
		}
		try
		{
			str=new String(str.getBytes("ISO-8859-1"),"UTF-8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}
	/***
	 * 将String型数据转换为int型数据的方法
	 * @param str
	 * @return
	 */
	public static Integer strToint(String str)
	{
		int i=0;
		if(str==null)
		{
			str="0";
		}
		try
		{
			i=Integer.parseInt(str);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
}
