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
 * @ClassName LunboController
 * @Description 轮播图模块控制层
 */
@Controller
public class LunboController extends BaseController{

    @Autowired
    private LunboService lunboService;




    //前台-轮播图列表页
    @RequestMapping("/lunboManaQian")
    public ModelAndView lunboManaQian(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboManaQian");
        mav.addObject("actionName","lunboManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-轮播图图片列表页
    @RequestMapping("/lunboManaQiantp")
    public ModelAndView lunboManaQiantp(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-轮播图管理列表页
    @RequestMapping("/lunboMana")
    public ModelAndView lunboMana(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-轮播图查看列表页
    @RequestMapping("/lunboChakan")
    public ModelAndView lunboChakan(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-轮播图按id列排序列表页
    @RequestMapping("/lunboManaQianSort")
    public ModelAndView lunboManaQianSort(Lunbo  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("lunboManaQian");
        mav.addObject("actionName","lunboManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-轮播图详情页
    @GetMapping("/lunboDetailQian/{id}")
    @ResponseBody
    public ModelAndView lunboDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lunboDetailQian");
        Lunbo info= lunboService.findById(id);
        mav.addObject("lunbo", info);

        return mav;
    }

    //后台-轮播图详情页
    @GetMapping("/lunboDetail/{id}")
    @ResponseBody
    public ModelAndView lunboDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lunboDetail");
        Lunbo info= lunboService.findById(id);
        mav.addObject("lunbo", info);
        return mav;
    }

    //获取所有轮播图数据接口
    @RequestMapping("/lunboAll")
    @ResponseBody
    public ApiResponse<Lunbo> lunboAll(){
        List<Lunbo> lunboList=lunboService.findAll();
        return ApiResponse.success(lunboList);
    }

    //根据条件（字符类型模糊匹配查询）获取轮播图数据接口
    @RequestMapping("/lunboSearch")
    @ResponseBody
    public ApiResponse<Lunbo> lunboSearch(Lunbo req){
        List<Lunbo> lunboList=lunboService.find(req);
        return ApiResponse.success(lunboList);
    }

    //根据条件（字符类型完全匹配查询）获取轮播图数据接口
    @RequestMapping("/lunboSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Lunbo> lunboSearchByEqualTo(Lunbo req){
        List<Lunbo> lunboList=lunboService.findByEqualTo(req);
        return ApiResponse.success(lunboList);
    }

    //轮播图添加或修改接口
    @PostMapping("/lunboAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> lunboAddOrUpdate(@RequestBody Lunbo req, HttpSession session, Boolean isUPdateSession){



        int result = lunboService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //轮播图修改单独一个字段接口
    @PostMapping("/lunboSet")
    @ResponseBody
    public ApiResponse<Integer> lunboSet(Lunbo req){
        int result = lunboService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //轮播图删除接口
    @RequestMapping("/lunboDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> lunboDel(@PathVariable Integer id){
        int result = lunboService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-轮播图修改页
    @RequestMapping("/lunboGet/{id}")
    @ResponseBody
    public ModelAndView lunboGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lunboSet");
        Lunbo info = lunboService.findById(id);
        mav.addObject("lunbo", info);
        return mav;
    }








    //轮播图模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Lunbo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lunbo> pageWrap=new PageWrap<Lunbo>();
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
        PageData<Lunbo> pageInfo= lunboService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //轮播图完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Lunbo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lunbo> pageWrap=new PageWrap<Lunbo>();
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
        PageData<Lunbo> pageInfo= lunboService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
