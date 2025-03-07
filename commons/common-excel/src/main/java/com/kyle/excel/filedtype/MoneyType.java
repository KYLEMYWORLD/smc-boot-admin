package com.kyle.excel.filedtype;

import cn.hutool.core.util.StrUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author kyle
 * @date 2024/4/9
 */
public class MoneyType implements FieldType {
    private NumberFormat nf = new DecimalFormat(",##0.00");

    @Override
    public Object getValue(String val) {
        return StrUtil.isEmpty(val) ? "" : StrUtil.replace(val, ",", "");
    }

    @Override
    public String setValue(Object val) {
        return StrUtil.isEmpty(val.toString()) ? "" : this.nf.format(val);
    }

    @Override
    public String getDataFormat() {
        return "0.00";
    }
}