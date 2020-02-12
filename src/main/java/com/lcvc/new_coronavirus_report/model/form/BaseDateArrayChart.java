package com.lcvc.new_coronavirus_report.model.form;

import java.util.List;

/**
 * 返回柱状图的封装类
 */
public class BaseDateArrayChart {
    private String[] labels;
    private Integer[] values;

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Integer[] getValues() {
        return values;
    }

    public void setValues(Integer[] values) {
        this.values = values;
    }
}
