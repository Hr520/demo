package com.web.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.base.BaseController;
import com.web.entity.Goods;
import com.web.service.GoodsService;
import com.web.util.DateUtil;
import com.web.util.General;
import com.web.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "goodsApi")
public class GoodsApi extends BaseController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("addGoods")
    public ResponseEntity<?> addGoods(Goods goods){
        goods.setUuid(idWorker.nextId());
        goods.setAddDate(DateUtil.getDay());
        String time=DateUtil.getTime();
        goods.setAddTime(time);
        goods.setUpdateTime(time);
        boolean flag=goodsService.addGoods(goods);
        if (flag){
            return new ResponseEntity<>().setState(General.SUCCESS).setMsg("新增成功");
        }else {
            return new ResponseEntity<>().setState(General.ERROR_0000).setMsg("新增失败");
        }
    }

    @PostMapping("GoodsList")
    public ResponseEntity<?> GoodsList(){
        List<Goods> goodsList=goodsService.GoodsList();
        return new ResponseEntity<>().setData(goodsList).setState(General.SUCCESS).setMsg("数据获取成功");
    }

}
