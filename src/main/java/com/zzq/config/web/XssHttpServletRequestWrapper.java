package com.zzq.config.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            int length = values.length;
            String[] escapseValues = new String[length];
            for (int i = 0; i < length; i++) {
                escapseValues[i] = clearXss(values[i]);
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }

    /**
     * 处理字符转义
     * @param value * @return
     */
    private String clearXss(String value) {

        if (value == null || "".equals(value)) {
            return value;
        }
        //建议下面片段使用StringBuffer对象处理。
        value = value. replaceAll ("<", "&lt;"). replaceAll (">", "&gt;");

        value = value.replaceAll("\\(", "(").replace("\\)", ")");

        value = value. replaceAll ("'", "'");

        value = value.replaceAll("eval\\((.*)\\)", "");

        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

        return value;
    }


}
