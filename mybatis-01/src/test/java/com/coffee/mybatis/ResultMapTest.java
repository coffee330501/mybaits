package com.coffee.mybatis;

import com.coffee.mybatis.mapper.DeptMapper;
import com.coffee.mybatis.mapper.EmpMapper;
import com.coffee.mybatis.mapper.UserMapper;
import com.coffee.mybatis.pojo.Dept;
import com.coffee.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ResultMapTest {
    @Test
   public void test01() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(stream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            DeptMapper deptMapper = session.getMapper(DeptMapper.class);
//            List<Emp> empList = empMapper.getAllEmp();
//            System.out.println(empList);
//            Emp emp = empMapper.getEmp(1);
//            System.out.println(emp);
            Dept dept = deptMapper.getDept(1);
            System.out.println(dept);
        }
    }
}
