package com.coffee.mybatis;


import com.coffee.mybatis.mapper.UserMapper;
import com.coffee.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    @Test
    public void testMybatis() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(stream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int i = userMapper.insertUser();
            System.out.println(i);
            session.commit();
        }
    }

    @Test
    public void testMybatis2() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(stream);
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            userMapper.updateUser();
           User user=  userMapper.getUserById(1);
            System.out.println(user);
//            List<User> users = userMapper.getAllUser();
//            users.forEach(System.out::println);
//            User user = userMapper.getUserByUsername("张三");
//            System.out.println(user);
//            boolean checkLogin = userMapper.checkLogin("张三", "123456");
//            System.out.println(checkLogin);
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("username","admin");
//            map.put("password","123456");
//            boolean checkLogin = userMapper.checkLoginByMap(map);
//            System.out.println(checkLogin);
        }
    }
}
