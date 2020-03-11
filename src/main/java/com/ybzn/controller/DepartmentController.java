package com.ybzn.controller;/*
 *   @author LMJ
 *   @time  2020/2/29
 */

import com.ybzn.pojo.Department;
import com.ybzn.service.DepartmentService;
import com.ybzn.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和部门有关的请求
 */
@Controller
public class DepartmentController {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
            List <Department> departmentList =departmentService.getDepts();
        return Msg.success().add("", departmentList);
    }
}
