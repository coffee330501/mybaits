package com.coffee.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer eid;
    private String name;
    private Integer age;
    private String email;
    private String did;
    private Dept dept;
}
