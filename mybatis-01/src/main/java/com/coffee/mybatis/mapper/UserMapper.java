package com.coffee.mybatis.mapper;

import com.coffee.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUser();
}
