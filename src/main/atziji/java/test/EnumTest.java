package main.atziji.java.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 测试指标和计算方式的枚举
 *
 * @author ZhuQiuPing
 *         on 2019/1/11
 */
public class EnumTest {

    @Test
    public void testEnumInfo() {
        List<Metric> metricList = Lists.newArrayList();
        metricList.add(new Metric("count", new String[]{"count", "count_minute", "count_second"}));
        metricList.add(new Metric("trans_ref.amount", new String[]{"sum", "sum_minute", "sum_second", "max", "min"}));
        metricList.add(new Metric("latency_msec", new String[]{"avg", "max", "min"}));

        for (Metric metric : metricList) {
            String metricName = metric.getMetricName();
            String[] calculations = metric.getCalculations();
            for(String calculation : calculations) {
                String value = metricName + "|" + calculation;
               MetricAndCalculation metricAndCalculation = MetricAndCalculation.fromName(value);
               if(metricAndCalculation != null) {
                   System.out.println(metricAndCalculation.getName());
               }
            }
        }
    }
}


class Metric {
    private String metricName;
    private String[] calculations;

    public Metric(String metricName, String[] calculations) {
        this.metricName = metricName;
        this.calculations = calculations;
    }

    public String getMetricName() {
        return metricName;
    }

    public String[] getCalculations() {
        return calculations;
    }
}

enum MetricAndCalculation {
    //交易量
    COUNT2COUNT("count|count", "交易量"),
    //吞吐量
    COUNT2COUNT_SECOND("count|count_second", "吞吐量(TPS)"),
    //金额
    TRANS_AMOUNT2SUM("trans_ref.amount|sum", "金额");

    private String metricName;
    private String name;

    MetricAndCalculation(String metricName, String name) {
        this.metricName = metricName;
        this.name = name;
    }

    public static MetricAndCalculation fromName(String metricName) {
        for (MetricAndCalculation metricAndCalculation : MetricAndCalculation.values()) {
            if (metricAndCalculation.getMetricName().equals(metricName)) {
                return metricAndCalculation;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getMetricName() {
        return metricName;
    }

    @Override
    public String toString() {
        return this.metricName + "|" + this.getName();
    }
}