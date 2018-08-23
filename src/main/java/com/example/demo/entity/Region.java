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
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Region implements Serializable {
    private static final long serialVersionUID = -6744694909160910598L;

    @Id
    @GeneratedValue(generator = "auto",strategy = GenerationType.AUTO)
    @GenericGenerator(strategy = "uuid", name = "auto")
    private int id;

    private int parentRegionId;

    private String regionName;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;


}
