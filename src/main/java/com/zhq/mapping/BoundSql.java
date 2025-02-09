package com.zhq.mapping;

import java.util.Map;

/**
 * @author zhq123
 * @date 2025/2/9 13:01
 */
public class BoundSql {

    private String sql;

    private Map<Integer, String> parameterMappings;

    private String parameterType;

    private String resultType;

    public BoundSql(String sql, Map<Integer, String> parameterMappings, String parameterType, String resultType) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.parameterType = parameterType;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public Map<Integer, String> getParameterMappings() {
        return parameterMappings;
    }

    public String getParameterType() {
        return parameterType;
    }

    public String getResultType() {
        return resultType;
    }
}
