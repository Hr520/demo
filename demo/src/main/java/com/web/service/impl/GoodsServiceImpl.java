package com.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.entity.Goods;
import com.web.mapper.GoodsMapper;
import com.web.service.GoodsService;
import com.web.util.rBool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public boolean addGoods(Goods goods) {
         boolean flg= rBool.ChangeIntToBoolean(goodsMapper.insert(goods)) ;
        return flg;
    }

    @Override
    public List<Goods> GoodsList() {
        return goodsMapper.selectList(null);
    }

    @Override
    public IPage<Goods> GoodsListPage(Page<Goods> goodsPage,Integer state) {
        return goodsMapper.selectPageVo(goodsPage,state);
    }
}
