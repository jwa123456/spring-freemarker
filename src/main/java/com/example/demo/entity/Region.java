package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
@Data
public class Region implements Serializable {
    private static final long serialVersionUID = -6744694909160910598L;

    private int id;

    private int parentRegionId;

    private String regionName;

    private Date createTime;

    private Date updateTime;


}
