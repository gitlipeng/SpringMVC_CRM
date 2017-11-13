package com.spring.crm.service;

import com.spring.crm.common.Page;
import com.spring.crm.pojo.Customer;
import com.spring.crm.vo.QueryVo;

public interface CustomerService {
    /**
     * 根据条件分页查询客户
     *
     * @param queryVo
     * @return
     */
    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Long id);
}