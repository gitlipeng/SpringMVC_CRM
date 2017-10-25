package com.spring.crm.dao;

import com.spring.crm.pojo.Customer;
import com.spring.crm.vo.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {

    /**
     * 根据queryVo分页查询数据
     *
     * @param queryVo
     * @return
     */
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * 根据queryVo查询数据条数
     *
     * @param queryVo
     * @return
     */
    int queryCountByQueryVo(QueryVo queryVo);

}
