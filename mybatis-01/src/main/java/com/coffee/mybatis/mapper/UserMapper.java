package com.coffee.mybatis.mapper;

import com.coffee.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int insertUser();
    void updateUser();
    User getUserById(int id);
    List<User> getAllUser();
    User getUserByUsername(String username);
    boolean checkLogin(@Param("username") String username,@Param("password") String password);
    boolean checkLoginByMap(Map<String,Object> map);
    Integer countUser();
    @MapKey("id")
    Map<String,User> getAllUserToMap();
    List<User> getUserByUserNameLike(@Param("userName")String userName);
    Integer updateAgeById(@Param("ids") List<Integer> ids);
    void addUser(User user);
}
