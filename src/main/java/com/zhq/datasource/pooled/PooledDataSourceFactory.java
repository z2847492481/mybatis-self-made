package com.zhq.datasource.pooled;



import com.zhq.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;


public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }
}
