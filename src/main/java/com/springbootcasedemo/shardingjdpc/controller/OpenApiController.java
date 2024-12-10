package com.springbootcasedemo.shardingjdpc.controller;

import cn.hutool.core.date.DateUtil;
import com.springbootcasedemo.shardingjdpc.entity.LogApi;
import com.springbootcasedemo.shardingjdpc.service.LogService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;


/**
 * 控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/log")
public class OpenApiController {
    private LogService logService;


    /**
     * 开放接口-添加
     */
    @GetMapping("/add")
    public void add() {
        logService.add();
    }


}
