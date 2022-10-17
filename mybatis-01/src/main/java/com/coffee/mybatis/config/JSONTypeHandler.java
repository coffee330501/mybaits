package com.coffee.mybatis.config;

import com.coffee.mybatis.pojo.User;
import com.coffee.mybatis.pojo.UserRawData;
import com.google.gson.Gson;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author objcfeng
 * @description JSONTypeHandler
 * @date 2022/10/17 15:20
 */
@MappedTypes({UserRawData.class})
public class JSONTypeHandler extends BaseTypeHandler<UserRawData> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserRawData o, JdbcType jdbcType) throws SQLException {
        if (preparedStatement == null) return;
        PGobject jsonObject = new PGobject();
        jsonObject.setType("jsonb");
        jsonObject.setValue(new Gson().toJson(o));
        preparedStatement.setObject(i, jsonObject);
    }

    @Override
    public UserRawData getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String res = resultSet.getString(columnName);
        return  new Gson().fromJson(res,UserRawData.class);
    }

    @Override
    public UserRawData getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String res = resultSet.getString(i);
        return  new Gson().fromJson(res,UserRawData.class);
    }

    @Override
    public UserRawData getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String res = callableStatement.getString(i);
        return  new Gson().fromJson(res,UserRawData.class);
    }
}