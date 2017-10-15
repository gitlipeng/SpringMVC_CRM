package com.spring.crm.dao;

import com.spring.crm.pojo.BaseDict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDictDao {
    /**
     * 根据类别代码查询数据
     *
     * @param dictTypeCode
     * @return
     */

    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

    BaseDict queryBaseDictById(int id);
}