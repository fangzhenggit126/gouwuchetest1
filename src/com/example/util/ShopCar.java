package com.example.util;

import java.util.ArrayList;

import com.example.bean.Goods;
/***
 * ���ﳵ������buylist���������洢���ﳵ�����Ʒ
 * @author dell
 *
 */
public class ShopCar {
	//����һ���ܹ��洢��Ʒ���б�����������洢���ﳵ�����Ʒ
	ArrayList buylist=new ArrayList();

	public ArrayList getBuylist() {
		return buylist;
	}
	/**
	 * @���� ���ﳵ�������Ʒ
	 * @���� goodsΪGoods����󣬷�װ��Ҫ��ӵ���Ʒ��Ϣ
	 */
	public void addItem(Goods goods)
	{
		//�ж���ӵ����ﳵ�����Ʒ�Ƿ�Ϊ��
		if(goods!=null)
		{
			//�жϹ��ﳵ���Ƿ������Ʒ
			if(buylist.size()==0)  //���û����Ʒ
			{
				//���buylist�в������κ���Ʒ,����һ����Ʒ����ʱ����
				Goods temp=new Goods();
				temp.setNo(goods.getNo());
				temp.setName(goods.getName());
				temp.setPrice(goods.getPrice());
				temp.setNum(1);
				//�Ѹ���Ʒ��ӵ����ﳵ��
				buylist.add(temp);
			}
			else
			{
				int i=0;
				//����buylist���϶����жϸù��ﳵ���Ƿ��Ѿ����ڵ�ǰҪ��ӵ���Ʒ	
				for(;i<buylist.size();i++)
				{
					//��ȡbuylist�����е�ǰԪ��
					Goods temp=(Goods)buylist.get(i);
					if(temp.getNo()==goods.getNo())//�����ͬ��˵���ڹ��ﳵ���Ѿ������˸���Ʒ��ֻ��Ҫ����Ʒ�Ĺ���������1
					{
						temp.setNum(temp.getNum()+1);
						//����forѭ��
						break;
					}
				}
				if(i>=buylist.size())  //˵��buylist�в�����Ҫ��ӵ���Ʒ
				{
					//����һ����Ʒ����ʱ����
					Goods temp=new Goods();
					temp.setNo(goods.getNo());
					temp.setName(goods.getName());
					temp.setPrice(goods.getPrice());
					temp.setNum(1);
					//�Ѹ���Ʒ��ӵ����ﳵ��
					buylist.add(temp);
				}
			}
		}
	}
	/**
	 * @���� �ӹ��ﳵ���Ƴ�ָ�����Ƶ���Ʒ
	 * @���� no��ʾ��Ʒ���
	 */
	public void removeItem(int no){
		//����buylist���ϣ�����ָ�����Ƶ���Ʒ
		for(int i=0;i<buylist.size();i++)
		{
			Goods temp=(Goods)buylist.get(i);
			if(temp.getNo()==no)
			{
				if(temp.getNum()>1)
				{
					temp.setNum(temp.getNum()-1);
				}
				else if(temp.getNum()==1)
				{
					buylist.remove(i);
				}
			}
		}
	}
	/**
	 * @���� ��չ��ﳵ
	 */
	public void clearCar(){
		buylist.clear();									//���buylist���϶���
	}
}
