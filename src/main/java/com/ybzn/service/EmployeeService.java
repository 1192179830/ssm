package com.ybzn.service;/*
 *   @author LMJ
 *   @time  2020/2/27
 */

import com.ybzn.dao.EmployeeMapper;
import com.ybzn.pojo.Employee;
import com.ybzn.pojo.EmployeeExample;
import com.ybzn.utils.Msg;
import com.ybzn.pojo.EmployeeExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * 查询所有员工（分页查询）
     * @return
     */
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }
    /**
     * 保存员工
     * @param employee
     */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }
    /**
     * 校验用户名是否被占用
     * @param empName
     * @return
     */
    public boolean checkuser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.countByExample(example) == 0;
    }
    /**
     * 修改员工信息的时候用于数据回显
     * @param id
     * @return
     */
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }
    /**
     * 修改员工信息的提交
     * @param
     */
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }
    /**
     * 删除员工信息
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
    /**
     * 批量删除员工
     * @param
     */
    public void deleteBatchEmp(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(ids);
        //delete from xxx where emp_id in (1,2,3);
        employeeMapper.deleteByExample(example);
    }
    /**
     * 高级搜索功能
     * @param employee
     * @return
     */
    public List<Employee> queryEmp(Employee employee) {
        // TODO Auto-generated method stub
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        System.out.println("".equals(employee.getEmpName()));
        if (!("".equals(employee.getEmpName()))) {
            criteria.andEmpNameEqualTo(employee.getEmpName());
        }
        if(!("".equals(employee.getEmail()))) {
            criteria.andEmailEqualTo(employee.getEmail());
        }
        criteria.andGenderEqualTo(employee.getGender());
        criteria.andDIdEqualTo(employee.getdId());

        return employeeMapper.selectByExampleWithDept(example);
    }
}