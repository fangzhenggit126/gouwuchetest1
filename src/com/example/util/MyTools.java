package com.example.util;

public class MyTools {
	/***
	 * �����������
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
	 * ��String������ת��Ϊint�����ݵķ���
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
