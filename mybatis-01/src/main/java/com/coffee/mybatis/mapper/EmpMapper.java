package com.coffee.mybatis.mapper;

import com.coffee.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> getAllEmp();
    Emp getEmp(Integer eid);
}
