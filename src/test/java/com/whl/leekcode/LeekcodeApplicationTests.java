package com.whl.leekcode;

import com.whl.leekcode.common.entity.Employee;
import com.whl.leekcode.common.mapper.EmployeeMapper;
import com.whl.leekcode.common.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LeekcodeApplicationTests {

    @Autowired
     public EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService employeeService;

    /**
     * 测试是否联通mybatis
     */
    @Test
    void testMybatisPlus() {
        List<Employee> employees = employeeMapper.selectList(null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("查询成功！");
        Employee addEmployee = new Employee(18, "姓名", 123, LocalDateTime.now());

        int i = employeeMapper.insert(addEmployee);
        if (i > 0) {
            System.out.println("成功加入记录！");
        } else {
            System.out.println("失败加入记录！");
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void MoreThreadTest2() throws InterruptedException {
        int size = 10;
        List<Employee> employeeDOList = new ArrayList<>(size);
        for (int i = 0; i<size;i++){
            Employee employeeDO = new Employee();
            employeeDO.setEmployeeName("lol"+i);
            employeeDO.setAge(18);
            employeeDO.setIdNumber(i+ 1);
            employeeDOList.add(employeeDO);
        }
        try {
            //事务不成功操作
            employeeService.saveThread(employeeDOList);
            //成功操作
            //employeeService.saveThread2(employeeDOList);
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
