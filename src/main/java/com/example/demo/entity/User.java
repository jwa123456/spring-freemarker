package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
@Data
public class User implements Serializable {


    private static final long serialVersionUID = 6741222020820834733L;

    private String id;

    private String userName;

    private String email;

    private int age;

    private String password;

    private String comment;

    private Date createTime;

    private Date updateTime;
}
