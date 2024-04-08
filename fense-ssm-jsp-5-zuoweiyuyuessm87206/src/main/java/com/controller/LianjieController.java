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
 * @ClassName LianjieController
 * @Description 友情链接模块控制层
 */
@Controller
public class LianjieController extends BaseController{

    @Autowired
    private LianjieService lianjieService;




    //前台-友情链接列表页
    @RequestMapping("/lianjieManaQian")
    public ModelAndView lianjieManaQian(Lianjie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lianjieManaQian");
        mav.addObject("actionName","lianjieManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-友情链接图片列表页
    @RequestMapping("/lianjieManaQiantp")
    public ModelAndView lianjieManaQiantp(Lianjie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lianjieManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-友情链接管理列表页
    @RequestMapping("/lianjieMana")
    public ModelAndView lianjieMana(Lianjie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lianjieMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-友情链接查看列表页
    @RequestMapping("/lianjieChakan")
    public ModelAndView lianjieChakan(Lianjie req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lianjieChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-友情链接按id列排序列表页
    @RequestMapping("/lianjieManaQianSort")
    public ModelAndView lianjieManaQianSort(Lianjie  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("lianjieManaQian");
        mav.addObject("actionName","lianjieManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-友情链接详情页
    @GetMapping("/lianjieDetailQian/{id}")
    @ResponseBody
    public ModelAndView lianjieDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lianjieDetailQian");
        Lianjie info= lianjieService.findById(id);
        mav.addObject("lianjie", info);

        return mav;
    }

    //后台-友情链接详情页
    @GetMapping("/lianjieDetail/{id}")
    @ResponseBody
    public ModelAndView lianjieDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lianjieDetail");
        Lianjie info= lianjieService.findById(id);
        mav.addObject("lianjie", info);
        return mav;
    }

    //获取所有友情链接数据接口
    @RequestMapping("/lianjieAll")
    @ResponseBody
    public ApiResponse<Lianjie> lianjieAll(){
        List<Lianjie> lianjieList=lianjieService.findAll();
        return ApiResponse.success(lianjieList);
    }

    //根据条件（字符类型模糊匹配查询）获取友情链接数据接口
    @RequestMapping("/lianjieSearch")
    @ResponseBody
    public ApiResponse<Lianjie> lianjieSearch(Lianjie req){
        List<Lianjie> lianjieList=lianjieService.find(req);
        return ApiResponse.success(lianjieList);
    }

    //根据条件（字符类型完全匹配查询）获取友情链接数据接口
    @RequestMapping("/lianjieSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Lianjie> lianjieSearchByEqualTo(Lianjie req){
        List<Lianjie> lianjieList=lianjieService.findByEqualTo(req);
        return ApiResponse.success(lianjieList);
    }

    //友情链接添加或修改接口
    @PostMapping("/lianjieAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> lianjieAddOrUpdate(@RequestBody Lianjie req, HttpSession session, Boolean isUPdateSession){



        int result = lianjieService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //友情链接修改单独一个字段接口
    @PostMapping("/lianjieSet")
    @ResponseBody
    public ApiResponse<Integer> lianjieSet(Lianjie req){
        int result = lianjieService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //友情链接删除接口
    @RequestMapping("/lianjieDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> lianjieDel(@PathVariable Integer id){
        int result = lianjieService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-友情链接修改页
    @RequestMapping("/lianjieGet/{id}")
    @ResponseBody
    public ModelAndView lianjieGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lianjieSet");
        Lianjie info = lianjieService.findById(id);
        mav.addObject("lianjie", info);
        return mav;
    }








    //友情链接模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Lianjie req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lianjie> pageWrap=new PageWrap<Lianjie>();
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
        PageData<Lianjie> pageInfo= lianjieService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //友情链接完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Lianjie req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lianjie> pageWrap=new PageWrap<Lianjie>();
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
        PageData<Lianjie> pageInfo= lianjieService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
