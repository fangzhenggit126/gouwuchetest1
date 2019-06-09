package com.example.dao;

import java.util.ArrayList;

import com.example.bean.Goods;
import com.example.util.PageModel;

public interface GoodsDao {
   public ArrayList<Goods> getGoodsList();
//   //∑÷“≥≤È—Ø
   public ArrayList<Goods> getGoodsListByPageModel(PageModel pageModel);
  
}
