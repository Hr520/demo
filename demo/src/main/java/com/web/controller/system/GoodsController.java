package com.web.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.base.BaseController;
import com.web.entity.Goods;
import com.web.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("GoodsListPage")
    public String goodsListPage(Page<Goods> goodsPage, Integer state, Model model){
        saveMenuUrl("goods/GoodsListPage",getRequest());
        state=1;
        IPage<Goods> GoodsListPage=goodsService.GoodsListPage(goodsPage,state);
        model.addAttribute("goodsListPage",GoodsListPage);
        return "/view/goods/goodsList";
    }

}
