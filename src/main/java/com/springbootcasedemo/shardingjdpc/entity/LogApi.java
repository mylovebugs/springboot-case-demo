package com.springbootcasedemo.shardingjdpc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@TableName("blade_log_api")
@Data
public class LogApi {

    /**
     * 日志类型
     */
    private String type;
    /**
     * 日志标题
     */
    private String title;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 服务ID
     */
    private String serviceId;
    /**
     * 服务器 ip
     */
    private String serverIp;
    /**
     * 服务器名
     */
    private String serverHost;
    /**
     * 环境
     */
    private String env;
    /**
     * 操作IP地址
     */
    private String remoteIp;
    /**
     * 用户代理
     */
    private String userAgent;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 方法类
     */
    private String methodClass;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 操作提交的数据
     */
    private String params;
    /**
     * 执行时间
     */
    private String time;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


}
