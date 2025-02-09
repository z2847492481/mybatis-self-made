package com.zhq.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author zhq123
 * @date 2025/2/9 13:23
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();
}
