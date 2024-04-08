package com.controller;

import com.entity.*;
import com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FangjianController
 * @Description 房间模块控制层
 */
@Controller
public class FangjianController extends BaseController{

    @Autowired
    private FangjianService fangjianService;




    //前台-房间列表页
    @RequestMapping("/fangjianManaQian")
    public ModelAndView fangjianManaQian(Fangjian req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("fangjianManaQian");
        mav.addObject("actionName","fangjianManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-房间图片列表页
    @RequestMapping("/fangjianManaQiantp")
    public ModelAndView fangjianManaQiantp(Fangjian req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("fangjianManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-房间管理列表页
    @RequestMapping("/fangjianMana")
    public ModelAndView fangjianMana(Fangjian req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("fangjianMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-房间查看列表页
    @RequestMapping("/fangjianChakan")
    public ModelAndView fangjianChakan(Fangjian req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("fangjianChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-房间按id列排序列表页
    @RequestMapping("/fangjianManaQianSort")
    public ModelAndView fangjianManaQianSort(Fangjian  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("fangjianManaQian");
        mav.addObject("actionName","fangjianManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-房间详情页
    @GetMapping("/fangjianDetailQian/{id}")
    @ResponseBody
    public ModelAndView fangjianDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("fangjianDetailQian");
        Fangjian info= fangjianService.findById(id);
        mav.addObject("fangjian", info);

        return mav;
    }

    //后台-房间详情页
    @GetMapping("/fangjianDetail/{id}")
    @ResponseBody
    public ModelAndView fangjianDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("fangjianDetail");
        Fangjian info= fangjianService.findById(id);
        mav.addObject("fangjian", info);
        return mav;
    }

    //获取所有房间数据接口
    @RequestMapping("/fangjianAll")
    @ResponseBody
    public ApiResponse<Fangjian> fangjianAll(){
        List<Fangjian> fangjianList=fangjianService.findAll();
        return ApiResponse.success(fangjianList);
    }

    //根据条件（字符类型模糊匹配查询）获取房间数据接口
    @RequestMapping("/fangjianSearch")
    @ResponseBody
    public ApiResponse<Fangjian> fangjianSearch(Fangjian req){
        List<Fangjian> fangjianList=fangjianService.find(req);
        return ApiResponse.success(fangjianList);
    }

    //根据条件（字符类型完全匹配查询）获取房间数据接口
    @RequestMapping("/fangjianSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Fangjian> fangjianSearchByEqualTo(Fangjian req){
        List<Fangjian> fangjianList=fangjianService.findByEqualTo(req);
        return ApiResponse.success(fangjianList);
    }

    //房间添加或修改接口
    @PostMapping("/fangjianAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> fangjianAddOrUpdate(@RequestBody Fangjian req, HttpSession session, Boolean isUPdateSession){



        int result = fangjianService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //房间修改单独一个字段接口
    @PostMapping("/fangjianSet")
    @ResponseBody
    public ApiResponse<Integer> fangjianSet(Fangjian req){
        int result = fangjianService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //房间删除接口
    @RequestMapping("/fangjianDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> fangjianDel(@PathVariable Integer id){
        int result = fangjianService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-房间修改页
    @RequestMapping("/fangjianGet/{id}")
    @ResponseBody
    public ModelAndView fangjianGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("fangjianSet");
        Fangjian info = fangjianService.findById(id);
        mav.addObject("fangjian", info);
        return mav;
    }








    //房间模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Fangjian req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Fangjian> pageWrap=new PageWrap<Fangjian>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        //设置每页最多几条数据，默认为8条
        //pageWrap.setPageSize(8);
        PageWrap.SortData sortData=new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        PageData<Fangjian> pageInfo= fangjianService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //房间完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Fangjian req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Fangjian> pageWrap=new PageWrap<Fangjian>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        //设置每页最多几条数据，默认为8条
        //pageWrap.setPageSize(8);
        PageWrap.SortData sortData=new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        PageData<Fangjian> pageInfo= fangjianService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
