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
 * @ClassName GonggaoController
 * @Description 公告模块控制层
 */
@Controller
public class GonggaoController extends BaseController{

    @Autowired
    private GonggaoService gonggaoService;




    //前台-公告列表页
    @RequestMapping("/gonggaoManaQian")
    public ModelAndView gonggaoManaQian(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoManaQian");
        mav.addObject("actionName","gonggaoManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-公告图片列表页
    @RequestMapping("/gonggaoManaQiantp")
    public ModelAndView gonggaoManaQiantp(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-公告管理列表页
    @RequestMapping("/gonggaoMana")
    public ModelAndView gonggaoMana(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-公告查看列表页
    @RequestMapping("/gonggaoChakan")
    public ModelAndView gonggaoChakan(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-公告按id列排序列表页
    @RequestMapping("/gonggaoManaQianSort")
    public ModelAndView gonggaoManaQianSort(Gonggao  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("gonggaoManaQian");
        mav.addObject("actionName","gonggaoManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-公告详情页
    @GetMapping("/gonggaoDetailQian/{id}")
    @ResponseBody
    public ModelAndView gonggaoDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("gonggaoDetailQian");
        Gonggao info= gonggaoService.findById(id);
        mav.addObject("gonggao", info);

        return mav;
    }

    //后台-公告详情页
    @GetMapping("/gonggaoDetail/{id}")
    @ResponseBody
    public ModelAndView gonggaoDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("gonggaoDetail");
        Gonggao info= gonggaoService.findById(id);
        mav.addObject("gonggao", info);
        return mav;
    }

    //获取所有公告数据接口
    @RequestMapping("/gonggaoAll")
    @ResponseBody
    public ApiResponse<Gonggao> gonggaoAll(){
        List<Gonggao> gonggaoList=gonggaoService.findAll();
        return ApiResponse.success(gonggaoList);
    }

    //根据条件（字符类型模糊匹配查询）获取公告数据接口
    @RequestMapping("/gonggaoSearch")
    @ResponseBody
    public ApiResponse<Gonggao> gonggaoSearch(Gonggao req){
        List<Gonggao> gonggaoList=gonggaoService.find(req);
        return ApiResponse.success(gonggaoList);
    }

    //根据条件（字符类型完全匹配查询）获取公告数据接口
    @RequestMapping("/gonggaoSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Gonggao> gonggaoSearchByEqualTo(Gonggao req){
        List<Gonggao> gonggaoList=gonggaoService.findByEqualTo(req);
        return ApiResponse.success(gonggaoList);
    }

    //公告添加或修改接口
    @PostMapping("/gonggaoAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> gonggaoAddOrUpdate(@RequestBody Gonggao req, HttpSession session, Boolean isUPdateSession){



        int result = gonggaoService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //公告修改单独一个字段接口
    @PostMapping("/gonggaoSet")
    @ResponseBody
    public ApiResponse<Integer> gonggaoSet(Gonggao req){
        int result = gonggaoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //公告删除接口
    @RequestMapping("/gonggaoDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> gonggaoDel(@PathVariable Integer id){
        int result = gonggaoService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-公告修改页
    @RequestMapping("/gonggaoGet/{id}")
    @ResponseBody
    public ModelAndView gonggaoGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("gonggaoSet");
        Gonggao info = gonggaoService.findById(id);
        mav.addObject("gonggao", info);
        return mav;
    }








    //公告模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Gonggao req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Gonggao> pageWrap=new PageWrap<Gonggao>();
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
        PageData<Gonggao> pageInfo= gonggaoService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //公告完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Gonggao req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Gonggao> pageWrap=new PageWrap<Gonggao>();
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
        PageData<Gonggao> pageInfo= gonggaoService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
