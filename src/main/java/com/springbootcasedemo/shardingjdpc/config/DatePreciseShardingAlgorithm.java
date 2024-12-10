//package com.springbootcasedemo.shardingjdpc.config;
//
//import cn.hutool.core.date.LocalDateTimeUtil;
//import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
//import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
//import com.google.common.collect.Range;
//import lombok.Data;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
//import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//@Component
//@Data
//public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<LocalDateTime> , RangeShardingAlgorithm<LocalDateTime> {
//
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<LocalDateTime> preciseShardingValue) {
//        LocalDateTime date = preciseShardingValue.getValue();
//        //格式化列值
//        String suffix = LocalDateTimeUtil.format(date, "yyyyMMdd");
//        for (String tableName : availableTargetNames) {
//            if (tableName.endsWith(suffix)) {
//                return tableName;
//            }
//        }
//        throw new IllegalArgumentException("未找到匹配的数据表");
//    }
//
//    /**
//     * 范围算法
//     * SQL中有 BETWEEN AND、>、<、>=、<= 等条件的分片
//     * 返回多个表节点
//     */
//    @Override
//    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<LocalDateTime> rangeShardingValue) {
//        //获取sql的分片列的值 valueRange共有两个值
//        // lowerEndpoint：起始 当<、<= 为无限会报错，取当前节点的初始值，我这里是写死的，可以写成动态的
//        // upperEndpoint：结束 当>、>= 为无限会报错，取当前节点的最后的值，同上
//        // BETWEEN 两个都有值
//        Range<LocalDateTime> valueRange = rangeShardingValue.getValueRange();
//        LocalDateTime start = null;
//        try {
//            start = valueRange.lowerEndpoint();
//        } catch (Exception e) {
//            //<、<=
//            start = LocalDateTimeUtil.parse("2022-05-23 00:00:00","yyyy-MM-dd HH:mm:ss");
//        }
//        LocalDateTime end = null;
//        try {
//            end = valueRange.upperEndpoint();
//        } catch (Exception e) {
//            //>、>=
//            end = LocalDateTimeUtil.parse("2022-05-24 00:00:00","yyyy-MM-dd HH:mm:ss");
//        }
//        Set<String> suffixList = new HashSet<>();
//        // 获取当前节点的真实表名
//        Iterator<String> iterator = availableTargetNames.iterator();
//        String tableName = iterator.next();
//        String name = tableName.substring(0, tableName.lastIndexOf("_"));
//        // 拼接表名
//        if (ObjectUtils.isNotNull(start) && ObjectUtils.isNotNull(end)) {
//            String startName = LocalDateTimeUtil.format(start, "yyyyMMdd");
//            String endName = LocalDateTimeUtil.format(end, "yyyyMMdd");
//            // 循环开始、结束时间拼接，当表名在当前所有配置节点里存在时，添加到list里
//            while (!startName.equals(endName)) {
//                if (availableTargetNames.contains(name + "_" + startName)) {
//                    suffixList.add(name + "_" + startName);
//                }
//                start = start.plusDays(1L);
//                startName =LocalDateTimeUtil.format(start, "yyyyMMdd");
//            }
//            if (availableTargetNames.contains(name + "_" + endName)) {
//                suffixList.add(name + "_" + endName);
//            }
//        }
//        if (CollectionUtils.isNotEmpty(suffixList)) {
//            return suffixList;
//        }
//        return availableTargetNames;
//    }
//}
