package com.springbootcasedemo.shardingjdpc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootcasedemo.shardingjdpc.entity.LogApi;

public interface LogService extends IService<LogApi> {
    void add();
}
