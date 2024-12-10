//package com.springbootcasedemo.shardingjdpc.config;
//
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MybatisPlusConfig {
//
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        //动态表名
//        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
//        //可以传多个表名参数，指定哪些表使用DayTableNameHandler处理表名称
//        dynamicTableNameInnerInterceptor.setTableNameHandler(new DayTableNameHandler("blade_log_api"));
//        //以拦截器的方式处理表名称
//        //可以传递多个拦截器，即：可以传递多个表名处理器TableNameHandler
//        mybatisPlusInterceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
//        return mybatisPlusInterceptor;
//    }
//}
