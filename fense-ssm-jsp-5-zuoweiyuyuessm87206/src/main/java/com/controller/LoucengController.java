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
 * @ClassName LoucengController
 * @Description 楼层模块控制层
 */
@Controller
public class LoucengController extends BaseController{

    @Autowired
    private LoucengService loucengService;




    //前台-楼层列表页
    @RequestMapping("/loucengManaQian")
    public ModelAndView loucengManaQian(Louceng req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("loucengManaQian");
        mav.addObject("actionName","loucengManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-楼层图片列表页
    @RequestMapping("/loucengManaQiantp")
    public ModelAndView loucengManaQiantp(Louceng req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("loucengManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-楼层管理列表页
    @RequestMapping("/loucengMana")
    public ModelAndView loucengMana(Louceng req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("loucengMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-楼层查看列表页
    @RequestMapping("/loucengChakan")
    public ModelAndView loucengChakan(Louceng req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("loucengChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-楼层按id列排序列表页
    @RequestMapping("/loucengManaQianSort")
    public ModelAndView loucengManaQianSort(Louceng  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("loucengManaQian");
        mav.addObject("actionName","loucengManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-楼层详情页
    @GetMapping("/loucengDetailQian/{id}")
    @ResponseBody
    public ModelAndView loucengDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("loucengDetailQian");
        Louceng info= loucengService.findById(id);
        mav.addObject("louceng", info);

        return mav;
    }

    //后台-楼层详情页
    @GetMapping("/loucengDetail/{id}")
    @ResponseBody
    public ModelAndView loucengDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("loucengDetail");
        Louceng info= loucengService.findById(id);
        mav.addObject("louceng", info);
        return mav;
    }

    //获取所有楼层数据接口
    @RequestMapping("/loucengAll")
    @ResponseBody
    public ApiResponse<Louceng> loucengAll(){
        List<Louceng> loucengList=loucengService.findAll();
        return ApiResponse.success(loucengList);
    }

    //根据条件（字符类型模糊匹配查询）获取楼层数据接口
    @RequestMapping("/loucengSearch")
    @ResponseBody
    public ApiResponse<Louceng> loucengSearch(Louceng req){
        List<Louceng> loucengList=loucengService.find(req);
        return ApiResponse.success(loucengList);
    }

    //根据条件（字符类型完全匹配查询）获取楼层数据接口
    @RequestMapping("/loucengSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Louceng> loucengSearchByEqualTo(Louceng req){
        List<Louceng> loucengList=loucengService.findByEqualTo(req);
        return ApiResponse.success(loucengList);
    }

    //楼层添加或修改接口
    @PostMapping("/loucengAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> loucengAddOrUpdate(@RequestBody Louceng req, HttpSession session, Boolean isUPdateSession){



        int result = loucengService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //楼层修改单独一个字段接口
    @PostMapping("/loucengSet")
    @ResponseBody
    public ApiResponse<Integer> loucengSet(Louceng req){
        int result = loucengService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //楼层删除接口
    @RequestMapping("/loucengDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> loucengDel(@PathVariable Integer id){
        int result = loucengService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-楼层修改页
    @RequestMapping("/loucengGet/{id}")
    @ResponseBody
    public ModelAndView loucengGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("loucengSet");
        Louceng info = loucengService.findById(id);
        mav.addObject("louceng", info);
        return mav;
    }








    //楼层模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Louceng req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Louceng> pageWrap=new PageWrap<Louceng>();
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
        PageData<Louceng> pageInfo= loucengService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //楼层完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Louceng req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Louceng> pageWrap=new PageWrap<Louceng>();
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
        PageData<Louceng> pageInfo= loucengService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
