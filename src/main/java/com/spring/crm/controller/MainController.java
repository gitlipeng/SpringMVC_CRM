package com.spring.crm.controller;

import com.spring.crm.dao.BaseDictDao;
import com.spring.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    BaseDictDao baseDictDao;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("/queryById/{dictTypeCode}")
    @ResponseBody
    List<BaseDict> queryBaseDictByDictTypeCode(@PathVariable String dictTypeCode){
        List<BaseDict> list = baseDictDao.queryBaseDictByDictTypeCode(dictTypeCode);
        System.out.println(list);
        return list;
    }

    @RequestMapping("/customer")
    public ModelAndView customer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer");
        return modelAndView;
    }
}
