package com.spring.crm.service;

import com.spring.crm.dao.BaseDictDao;
import com.spring.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService{
//    // 客户来源
//    @Value("${CUSTOMER_FROM_TYPE}")
//    private String CUSTOMER_FROM_TYPE;
//    // 客户行业
//    @Value("${CUSTOMER_INDUSTRY_TYPE}")
//    private String CUSTOMER_INDUSTRY_TYPE;
//    // 客户级别
//    @Value("${CUSTOMER_LEVEL_TYPE}")
//    private String CUSTOMER_LEVEL_TYPE;
    @Autowired
    BaseDictDao baseDictDao;

    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return baseDictDao.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}
