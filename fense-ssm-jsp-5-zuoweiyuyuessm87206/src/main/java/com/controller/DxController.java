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
 * @ClassName DxController
 * @Description 介绍模块控制层
 */
@Controller
public class DxController extends BaseController{

    @Autowired
    private DxService dxService;




    //前台-介绍列表页
    @RequestMapping("/dxManaQian")
    public ModelAndView dxManaQian(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxManaQian");
        mav.addObject("actionName","dxManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-介绍图片列表页
    @RequestMapping("/dxManaQiantp")
    public ModelAndView dxManaQiantp(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-介绍管理列表页
    @RequestMapping("/dxMana")
    public ModelAndView dxMana(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-介绍查看列表页
    @RequestMapping("/dxChakan")
    public ModelAndView dxChakan(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-介绍按id列排序列表页
    @RequestMapping("/dxManaQianSort")
    public ModelAndView dxManaQianSort(Dx  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("dxManaQian");
        mav.addObject("actionName","dxManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-介绍详情页
    @GetMapping("/dxDetailQian/{id}")
    @ResponseBody
    public ModelAndView dxDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("dxDetailQian");
        Dx info= dxService.findById(id);
        mav.addObject("dx", info);

        return mav;
    }

    //后台-介绍详情页
    @GetMapping("/dxDetail/{id}")
    @ResponseBody
    public ModelAndView dxDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("dxDetail");
        Dx info= dxService.findById(id);
        mav.addObject("dx", info);
        return mav;
    }

    //获取所有介绍数据接口
    @RequestMapping("/dxAll")
    @ResponseBody
    public ApiResponse<Dx> dxAll(){
        List<Dx> dxList=dxService.findAll();
        return ApiResponse.success(dxList);
    }

    //根据条件（字符类型模糊匹配查询）获取介绍数据接口
    @RequestMapping("/dxSearch")
    @ResponseBody
    public ApiResponse<Dx> dxSearch(Dx req){
        List<Dx> dxList=dxService.find(req);
        return ApiResponse.success(dxList);
    }

    //根据条件（字符类型完全匹配查询）获取介绍数据接口
    @RequestMapping("/dxSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Dx> dxSearchByEqualTo(Dx req){
        List<Dx> dxList=dxService.findByEqualTo(req);
        return ApiResponse.success(dxList);
    }

    //介绍添加或修改接口
    @PostMapping("/dxAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> dxAddOrUpdate(@RequestBody Dx req, HttpSession session, Boolean isUPdateSession){



        int result = dxService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //介绍修改单独一个字段接口
    @PostMapping("/dxSet")
    @ResponseBody
    public ApiResponse<Integer> dxSet(Dx req){
        int result = dxService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //介绍删除接口
    @RequestMapping("/dxDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> dxDel(@PathVariable Integer id){
        int result = dxService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-介绍修改页
    @RequestMapping("/dxGet/{id}")
    @ResponseBody
    public ModelAndView dxGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("dxSet");
        Dx info = dxService.findById(id);
        mav.addObject("dx", info);
        return mav;
    }








    //介绍模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Dx req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Dx> pageWrap=new PageWrap<Dx>();
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
        PageData<Dx> pageInfo= dxService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //介绍完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Dx req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Dx> pageWrap=new PageWrap<Dx>();
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
        PageData<Dx> pageInfo= dxService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
