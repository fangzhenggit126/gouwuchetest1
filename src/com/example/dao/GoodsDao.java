package com.example.dao;

import java.util.ArrayList;

import com.example.bean.Goods;
import com.example.util.PageModel;

public interface GoodsDao {
   public ArrayList<Goods> getGoodsList();
//   //��ҳ��ѯ
   public ArrayList<Goods> getGoodsListByPageModel(PageModel pageModel);
  
}
