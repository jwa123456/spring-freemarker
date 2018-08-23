package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
@Data
@Entity(name = "t_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {


    private static final long serialVersionUID = 6741222020820834733L;

    @Id
    @GeneratedValue(generator = "auto",strategy = GenerationType.AUTO)
    @GenericGenerator(strategy = "uuid", name = "auto")
    private String id;


    private String userName;


    private String email;


    private int age;


    private String comment;


    private int regionId;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
