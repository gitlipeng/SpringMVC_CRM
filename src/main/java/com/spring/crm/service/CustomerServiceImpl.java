package com.spring.crm.service;

import com.spring.crm.common.Page;
import com.spring.crm.dao.CustomerDao;
import com.spring.crm.pojo.Customer;
import com.spring.crm.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Customer> list = this.customerDao.queryCustomerByQueryVo(queryVo);
        // 查询到的数据总条数
        int total = this.customerDao.queryCountByQueryVo(queryVo);

        // 封装返回的page对象
        Page<Customer> page = new Page<Customer>(total, queryVo.getPage(), queryVo.getRows(), list);

        return page;
    }

    public Customer queryCustomerById(Long id){
        return this.customerDao.queryCustomerById(id);
    }

    public void updateCustomer(Customer customer){
        this.customerDao.updateCustomer(customer);
    }

    public void deleteCustomerById(Long id){
        this.customerDao.deleteCustomerById(id);
    }
}