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
 * @ClassName ZuoweiController
 * @Description 座位模块控制层
 */
@Controller
public class ZuoweiController extends BaseController{

    @Autowired
    private ZuoweiService zuoweiService;

    @Autowired
    private LeibieService leibieService;
    @Autowired
    private LoucengService loucengService;
    @Autowired
    private FangjianService fangjianService;



    //前台-座位列表页
    @RequestMapping("/zuoweiManaQian")
    public ModelAndView zuoweiManaQian(Zuowei req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiManaQian");
        mav.addObject("actionName","zuoweiManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-座位图片列表页
    @RequestMapping("/zuoweiManaQiantp")
    public ModelAndView zuoweiManaQiantp(Zuowei req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-座位管理列表页
    @RequestMapping("/zuoweiMana")
    public ModelAndView zuoweiMana(Zuowei req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-座位查看列表页
    @RequestMapping("/zuoweiChakan")
    public ModelAndView zuoweiChakan(Zuowei req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-座位按id列排序列表页
    @RequestMapping("/zuoweiManaQianSort")
    public ModelAndView zuoweiManaQianSort(Zuowei  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("zuoweiManaQian");
        mav.addObject("actionName","zuoweiManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-座位详情页
    @GetMapping("/zuoweiDetailQian/{id}")
    @ResponseBody
    public ModelAndView zuoweiDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("zuoweiDetailQian");
        Zuowei info= zuoweiService.findById(id);
        mav.addObject("zuowei", info);

        return mav;
    }

    //后台-座位详情页
    @GetMapping("/zuoweiDetail/{id}")
    @ResponseBody
    public ModelAndView zuoweiDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("zuoweiDetail");
        Zuowei info= zuoweiService.findById(id);
        mav.addObject("zuowei", info);
        return mav;
    }

    //获取所有座位数据接口
    @RequestMapping("/zuoweiAll")
    @ResponseBody
    public ApiResponse<Zuowei> zuoweiAll(){
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        return ApiResponse.success(zuoweiList);
    }

    //根据条件（字符类型模糊匹配查询）获取座位数据接口
    @RequestMapping("/zuoweiSearch")
    @ResponseBody
    public ApiResponse<Zuowei> zuoweiSearch(Zuowei req){
        List<Zuowei> zuoweiList=zuoweiService.find(req);
        return ApiResponse.success(zuoweiList);
    }

    //根据条件（字符类型完全匹配查询）获取座位数据接口
    @RequestMapping("/zuoweiSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Zuowei> zuoweiSearchByEqualTo(Zuowei req){
        List<Zuowei> zuoweiList=zuoweiService.findByEqualTo(req);
        return ApiResponse.success(zuoweiList);
    }

    //座位添加或修改接口
    @PostMapping("/zuoweiAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> zuoweiAddOrUpdate(@RequestBody Zuowei req, HttpSession session, Boolean isUPdateSession){



        int result = zuoweiService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //座位修改单独一个字段接口
    @PostMapping("/zuoweiSet")
    @ResponseBody
    public ApiResponse<Integer> zuoweiSet(Zuowei req){
        int result = zuoweiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //座位删除接口
    @RequestMapping("/zuoweiDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> zuoweiDel(@PathVariable Integer id){
        int result = zuoweiService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-座位修改页
    @RequestMapping("/zuoweiGet/{id}")
    @ResponseBody
    public ModelAndView zuoweiGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("zuoweiSet");
        Zuowei info = zuoweiService.findById(id);
        mav.addObject("zuowei", info);
        return mav;
    }





    //前台-类别添加座位页面
    @GetMapping("/leibiezuoweiAddQian/{leibieid}")
    @ResponseBody
    public ModelAndView leibiezuoweiAddQian(@PathVariable Integer leibieid){
        ModelAndView mav = getLeibieZuoweiAddModelAndView(leibieid,"leibiezuoweiAddQian");
        return mav;
    }

    //后台-类别添加座位页面
    @GetMapping("/leibiezuoweiAdd/{leibieid}")
    @ResponseBody
    public ModelAndView leibiezuoweiAdd(@PathVariable Integer leibieid){
        ModelAndView mav = getLeibieZuoweiAddModelAndView(leibieid,"leibiezuoweiAdd");
        return mav;
    }

    //后台-类别座位查看页面
    @RequestMapping("/leibiezuoweiGetByleibieid/{leibieid}")
    @ResponseBody
    public ModelAndView leibiezuoweiGetByleibieid(Zuowei req, @PathVariable Integer leibieid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leibiezuoweiChakan");
        req.setLeibieid(leibieid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类别座位查看页面
    @RequestMapping("/leibiezuoweiGetByleibieidQian/{leibieid}")
    @ResponseBody
    public ModelAndView leibiezuoweiGetByleibieidQian(Zuowei req, @PathVariable Integer leibieid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiManaQian");
            mav.addObject("actionName","zuoweiManaQian");
        req.setLeibieid(leibieid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //类别座位数据封装
    private ModelAndView getLeibieZuoweiAddModelAndView(Integer leibieid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Leibie leibie=leibieService.findById(leibieid);
        mav.addObject("leibie", leibie);
        List<Louceng> loucengList=loucengService.findAll();
        mav.addObject("loucengList", loucengList);
        List<Fangjian> fangjianList=fangjianService.findAll();
        mav.addObject("fangjianList", fangjianList);

        return mav;
    }
    //前台-楼层添加座位页面
    @GetMapping("/loucengzuoweiAddQian/{loucengid}")
    @ResponseBody
    public ModelAndView loucengzuoweiAddQian(@PathVariable Integer loucengid){
        ModelAndView mav = getLoucengZuoweiAddModelAndView(loucengid,"loucengzuoweiAddQian");
        return mav;
    }

    //后台-楼层添加座位页面
    @GetMapping("/loucengzuoweiAdd/{loucengid}")
    @ResponseBody
    public ModelAndView loucengzuoweiAdd(@PathVariable Integer loucengid){
        ModelAndView mav = getLoucengZuoweiAddModelAndView(loucengid,"loucengzuoweiAdd");
        return mav;
    }

    //后台-楼层座位查看页面
    @RequestMapping("/loucengzuoweiGetByloucengid/{loucengid}")
    @ResponseBody
    public ModelAndView loucengzuoweiGetByloucengid(Zuowei req, @PathVariable Integer loucengid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("loucengzuoweiChakan");
        req.setLoucengid(loucengid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-楼层座位查看页面
    @RequestMapping("/loucengzuoweiGetByloucengidQian/{loucengid}")
    @ResponseBody
    public ModelAndView loucengzuoweiGetByloucengidQian(Zuowei req, @PathVariable Integer loucengid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiManaQian");
            mav.addObject("actionName","zuoweiManaQian");
        req.setLoucengid(loucengid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //楼层座位数据封装
    private ModelAndView getLoucengZuoweiAddModelAndView(Integer loucengid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Louceng louceng=loucengService.findById(loucengid);
        mav.addObject("louceng", louceng);
        List<Leibie> leibieList=leibieService.findAll();
        mav.addObject("leibieList", leibieList);
        List<Fangjian> fangjianList=fangjianService.findAll();
        mav.addObject("fangjianList", fangjianList);

        return mav;
    }
    //前台-房间添加座位页面
    @GetMapping("/fangjianzuoweiAddQian/{fangjianid}")
    @ResponseBody
    public ModelAndView fangjianzuoweiAddQian(@PathVariable Integer fangjianid){
        ModelAndView mav = getFangjianZuoweiAddModelAndView(fangjianid,"fangjianzuoweiAddQian");
        return mav;
    }

    //后台-房间添加座位页面
    @GetMapping("/fangjianzuoweiAdd/{fangjianid}")
    @ResponseBody
    public ModelAndView fangjianzuoweiAdd(@PathVariable Integer fangjianid){
        ModelAndView mav = getFangjianZuoweiAddModelAndView(fangjianid,"fangjianzuoweiAdd");
        return mav;
    }

    //后台-房间座位查看页面
    @RequestMapping("/fangjianzuoweiGetByfangjianid/{fangjianid}")
    @ResponseBody
    public ModelAndView fangjianzuoweiGetByfangjianid(Zuowei req, @PathVariable Integer fangjianid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("fangjianzuoweiChakan");
        req.setFangjianid(fangjianid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-房间座位查看页面
    @RequestMapping("/fangjianzuoweiGetByfangjianidQian/{fangjianid}")
    @ResponseBody
    public ModelAndView fangjianzuoweiGetByfangjianidQian(Zuowei req, @PathVariable Integer fangjianid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiManaQian");
            mav.addObject("actionName","zuoweiManaQian");
        req.setFangjianid(fangjianid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //房间座位数据封装
    private ModelAndView getFangjianZuoweiAddModelAndView(Integer fangjianid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Fangjian fangjian=fangjianService.findById(fangjianid);
        mav.addObject("fangjian", fangjian);
        List<Leibie> leibieList=leibieService.findAll();
        mav.addObject("leibieList", leibieList);
        List<Louceng> loucengList=loucengService.findAll();
        mav.addObject("loucengList", loucengList);

        return mav;
    }



    //座位模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Zuowei req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Zuowei> pageWrap=new PageWrap<Zuowei>();
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
        PageData<Zuowei> pageInfo= zuoweiService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Leibie> leibieList=leibieService.findAll();
        mav.addObject("leibieList", leibieList);
        List<Louceng> loucengList=loucengService.findAll();
        mav.addObject("loucengList", loucengList);
        List<Fangjian> fangjianList=fangjianService.findAll();
        mav.addObject("fangjianList", fangjianList);

        return mav;
    }

    //座位完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Zuowei req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Zuowei> pageWrap=new PageWrap<Zuowei>();
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
        PageData<Zuowei> pageInfo= zuoweiService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Leibie> leibieList=leibieService.findAll();
        mav.addObject("leibieList", leibieList);
        List<Louceng> loucengList=loucengService.findAll();
        mav.addObject("loucengList", loucengList);
        List<Fangjian> fangjianList=fangjianService.findAll();
        mav.addObject("fangjianList", fangjianList);

        return mav;
        }
}
