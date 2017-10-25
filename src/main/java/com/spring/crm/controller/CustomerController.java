package com.spring.crm.controller;

import com.spring.crm.common.Page;
import com.spring.crm.pojo.BaseDict;
import com.spring.crm.pojo.Customer;
import com.spring.crm.service.BaseDictService;
import com.spring.crm.service.CustomerService;
import com.spring.crm.vo.QueryVo;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    BaseDictService baseDictService;
    @Autowired
    CustomerService customerService;


    @RequestMapping("/customer/list")
    public String queryCustomerList(QueryVo queryVo, Model model) {

        try {
            // 解决get请求乱码问题
            if (StringUtils.isNotBlank(queryVo.getCustName())) {
                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 客户来源
        List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode("002");
        // 所属行业
        List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode("001");
        // 客户级别
        List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode("006");

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        // 分页查询数据
        Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
        // 把分页查询的结果放到模型中
        model.addAttribute("page", page);

        // 数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        return "customer";
    }






    @RequestMapping("/customer")
    public String customer(Model model){
        // 客户来源
        List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode("002");
        // 所属行业
        List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode("001");
        // 客户级别
        List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode("006");

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        return "customer";
    }
}
