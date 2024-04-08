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
 * @ClassName ShiduanController
 * @Description 时段模块控制层
 */
@Controller
public class ShiduanController extends BaseController{

    @Autowired
    private ShiduanService shiduanService;




    //前台-时段列表页
    @RequestMapping("/shiduanManaQian")
    public ModelAndView shiduanManaQian(Shiduan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shiduanManaQian");
        mav.addObject("actionName","shiduanManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-时段图片列表页
    @RequestMapping("/shiduanManaQiantp")
    public ModelAndView shiduanManaQiantp(Shiduan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shiduanManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-时段管理列表页
    @RequestMapping("/shiduanMana")
    public ModelAndView shiduanMana(Shiduan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shiduanMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-时段查看列表页
    @RequestMapping("/shiduanChakan")
    public ModelAndView shiduanChakan(Shiduan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shiduanChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-时段按id列排序列表页
    @RequestMapping("/shiduanManaQianSort")
    public ModelAndView shiduanManaQianSort(Shiduan  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("shiduanManaQian");
        mav.addObject("actionName","shiduanManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-时段详情页
    @GetMapping("/shiduanDetailQian/{id}")
    @ResponseBody
    public ModelAndView shiduanDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("shiduanDetailQian");
        Shiduan info= shiduanService.findById(id);
        mav.addObject("shiduan", info);

        return mav;
    }

    //后台-时段详情页
    @GetMapping("/shiduanDetail/{id}")
    @ResponseBody
    public ModelAndView shiduanDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("shiduanDetail");
        Shiduan info= shiduanService.findById(id);
        mav.addObject("shiduan", info);
        return mav;
    }

    //获取所有时段数据接口
    @RequestMapping("/shiduanAll")
    @ResponseBody
    public ApiResponse<Shiduan> shiduanAll(){
        List<Shiduan> shiduanList=shiduanService.findAll();
        return ApiResponse.success(shiduanList);
    }

    //根据条件（字符类型模糊匹配查询）获取时段数据接口
    @RequestMapping("/shiduanSearch")
    @ResponseBody
    public ApiResponse<Shiduan> shiduanSearch(Shiduan req){
        List<Shiduan> shiduanList=shiduanService.find(req);
        return ApiResponse.success(shiduanList);
    }

    //根据条件（字符类型完全匹配查询）获取时段数据接口
    @RequestMapping("/shiduanSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Shiduan> shiduanSearchByEqualTo(Shiduan req){
        List<Shiduan> shiduanList=shiduanService.findByEqualTo(req);
        return ApiResponse.success(shiduanList);
    }

    //时段添加或修改接口
    @PostMapping("/shiduanAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> shiduanAddOrUpdate(@RequestBody Shiduan req, HttpSession session, Boolean isUPdateSession){



        int result = shiduanService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //时段修改单独一个字段接口
    @PostMapping("/shiduanSet")
    @ResponseBody
    public ApiResponse<Integer> shiduanSet(Shiduan req){
        int result = shiduanService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //时段删除接口
    @RequestMapping("/shiduanDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> shiduanDel(@PathVariable Integer id){
        int result = shiduanService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-时段修改页
    @RequestMapping("/shiduanGet/{id}")
    @ResponseBody
    public ModelAndView shiduanGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("shiduanSet");
        Shiduan info = shiduanService.findById(id);
        mav.addObject("shiduan", info);
        return mav;
    }








    //时段模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Shiduan req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Shiduan> pageWrap=new PageWrap<Shiduan>();
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
        PageData<Shiduan> pageInfo= shiduanService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //时段完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Shiduan req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Shiduan> pageWrap=new PageWrap<Shiduan>();
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
        PageData<Shiduan> pageInfo= shiduanService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
