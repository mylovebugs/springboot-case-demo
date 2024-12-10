package com.springbootcasedemo.shardingjdpc.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootcasedemo.shardingjdpc.entity.LogApi;
import com.springbootcasedemo.shardingjdpc.mapper.LogApiMapper;
import com.springbootcasedemo.shardingjdpc.service.LogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * Created by Blade.
 *
 * @author zhuangqian
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogApiMapper, LogApi> implements LogService {


    @Override
    public void add() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String rDay = LocalDateTime.now().format(formatter);
        //DayTableNameHandler.setData(rDay);

        LogApi logApi = new LogApi();
        logApi.setType("1");
        logApi.setTitle("标题");
        logApi.setServiceId("服务id");
        logApi.setServerIp("ip");
        logApi.setServerHost("服务器名");
        logApi.setEnv("环境");
        logApi.setRemoteIp("操作ip");
        logApi.setUserAgent("用户代理");
        logApi.setRequestUri("请求uri");
        logApi.setMethod("操作方式");
        logApi.setMethodClass("方法类");
        logApi.setMethodName("方法名");
        logApi.setParams("参数");
        logApi.setTime("执行时间");
        logApi.setCreateBy("创建人");

       // logApi.setCreateTime(DateUtil.toLocalDateTime(new Date()));
        logApi.setCreateTime(DateUtil.parseLocalDateTime("2024-11-10 13:33:33"));
        //LocalDateTime dateTime = DateUtil.toLocalDateTime(new Date());
        baseMapper.insert(logApi);
    }
}
