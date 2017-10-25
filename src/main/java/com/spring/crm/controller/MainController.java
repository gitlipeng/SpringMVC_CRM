package com.spring.crm.controller;

import com.spring.crm.dao.BaseDictDao;
import com.spring.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/test/customer")
    public String customer(Model model){
        // 客户来源
        List<BaseDict> fromType = this.baseDictDao.queryBaseDictByDictTypeCode("002");
        // 所属行业
        List<BaseDict> industryType = this.baseDictDao.queryBaseDictByDictTypeCode("001");
        // 客户级别
        List<BaseDict> levelType = this.baseDictDao.queryBaseDictByDictTypeCode("006");

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        return "customer";
    }
}
