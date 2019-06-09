package com.example.service.impl;

import java.util.ArrayList;

import com.example.bean.Goods;
import com.example.dao.GoodsDao;
import com.example.dao.impl.GoodsDaoImpl;
import com.example.service.GoodsService;
import com.example.util.PageModel;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsdao=new GoodsDaoImpl();
	@Override
	public ArrayList<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return goodsdao.getGoodsList();
	}
	@Override
	public ArrayList<Goods> getGoodsListByPageModel(PageModel pageModel) {
		// TODO Auto-generated method stub
		return goodsdao.getGoodsListByPageModel(pageModel);
	}

}
