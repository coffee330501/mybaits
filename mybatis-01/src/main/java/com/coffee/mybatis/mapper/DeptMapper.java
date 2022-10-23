package com.coffee.mybatis.mapper;


import com.coffee.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {
    Dept getDept(Integer did);
}
