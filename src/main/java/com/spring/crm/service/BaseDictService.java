package com.spring.crm.service;

import com.spring.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) ;
}
