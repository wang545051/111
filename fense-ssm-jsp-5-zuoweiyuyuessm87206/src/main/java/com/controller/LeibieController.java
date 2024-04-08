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
 * @ClassName LeibieController
 * @Description 类别模块控制层
 */
@Controller
public class LeibieController extends BaseController{

    @Autowired
    private LeibieService leibieService;




    //前台-类别列表页
    @RequestMapping("/leibieManaQian")
    public ModelAndView leibieManaQian(Leibie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leibieManaQian");
        mav.addObject("actionName","leibieManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类别图片列表页
    @RequestMapping("/leibieManaQiantp")
    public ModelAndView leibieManaQiantp(Leibie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leibieManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-类别管理列表页
    @RequestMapping("/leibieMana")
    public ModelAndView leibieMana(Leibie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leibieMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-类别查看列表页
    @RequestMapping("/leibieChakan")
    public ModelAndView leibieChakan(Leibie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leibieChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类别按id列排序列表页
    @RequestMapping("/leibieManaQianSort")
    public ModelAndView leibieManaQianSort(Leibie  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("leibieManaQian");
        mav.addObject("actionName","leibieManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类别详情页
    @GetMapping("/leibieDetailQian/{id}")
    @ResponseBody
    public ModelAndView leibieDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("leibieDetailQian");
        Leibie info= leibieService.findById(id);
        mav.addObject("leibie", info);

        return mav;
    }

    //后台-类别详情页
    @GetMapping("/leibieDetail/{id}")
    @ResponseBody
    public ModelAndView leibieDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("leibieDetail");
        Leibie info= leibieService.findById(id);
        mav.addObject("leibie", info);
        return mav;
    }

    //获取所有类别数据接口
    @RequestMapping("/leibieAll")
    @ResponseBody
    public ApiResponse<Leibie> leibieAll(){
        List<Leibie> leibieList=leibieService.findAll();
        return ApiResponse.success(leibieList);
    }

    //根据条件（字符类型模糊匹配查询）获取类别数据接口
    @RequestMapping("/leibieSearch")
    @ResponseBody
    public ApiResponse<Leibie> leibieSearch(Leibie req){
        List<Leibie> leibieList=leibieService.find(req);
        return ApiResponse.success(leibieList);
    }

    //根据条件（字符类型完全匹配查询）获取类别数据接口
    @RequestMapping("/leibieSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Leibie> leibieSearchByEqualTo(Leibie req){
        List<Leibie> leibieList=leibieService.findByEqualTo(req);
        return ApiResponse.success(leibieList);
    }

    //类别添加或修改接口
    @PostMapping("/leibieAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> leibieAddOrUpdate(@RequestBody Leibie req, HttpSession session, Boolean isUPdateSession){



        int result = leibieService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //类别修改单独一个字段接口
    @PostMapping("/leibieSet")
    @ResponseBody
    public ApiResponse<Integer> leibieSet(Leibie req){
        int result = leibieService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //类别删除接口
    @RequestMapping("/leibieDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> leibieDel(@PathVariable Integer id){
        int result = leibieService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-类别修改页
    @RequestMapping("/leibieGet/{id}")
    @ResponseBody
    public ModelAndView leibieGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("leibieSet");
        Leibie info = leibieService.findById(id);
        mav.addObject("leibie", info);
        return mav;
    }








    //类别模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Leibie req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Leibie> pageWrap=new PageWrap<Leibie>();
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
        PageData<Leibie> pageInfo= leibieService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //类别完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Leibie req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Leibie> pageWrap=new PageWrap<Leibie>();
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
        PageData<Leibie> pageInfo= leibieService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
