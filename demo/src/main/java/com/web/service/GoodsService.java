package com.web.service;

import com.web.entity.Goods;

import java.util.List;

public interface GoodsService {

    boolean addGoods(Goods goods);

    List<Goods> GoodsList();
}
