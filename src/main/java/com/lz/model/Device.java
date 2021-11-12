package com.lz.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.lz.config.JsonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@TableName(value = "iot_device", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class Device extends Model<Device> {

    private static final long serialVersionUID = -1202631345275934025L;

    @TableId
    private String id;
    private String sn;
    private Integer status;
    private String stationId;
    private String station;
    private String name;
    private Date createTime;
    private Integer type;
    private String productId;
    private String productName;
    @TableField(typeHandler = JsonTypeHandler.class)
    private JSONObject location;
    private String icon;
    private String gateway;
    private String productCode;
    private String version;
    @TableField(typeHandler = JsonTypeHandler.class)
    private JSONObject devInfo;
    private String testStatus;
    private String devid;
    @TableField(typeHandler = JsonTypeHandler.class)
    private JSONObject reportInfo;
    private Boolean alarm;

}
