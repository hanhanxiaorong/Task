package com.ow.tracer.core.gencode.database.impl;





import com.ow.tracer.core.gencode.bean.ColumnInfo;
import com.ow.tracer.core.gencode.bean.JavaType;
import com.ow.tracer.core.gencode.bean.TableInfo;
import com.ow.tracer.core.gencode.config.DatabaseConfig;
import com.ow.tracer.core.gencode.database.DatabaseInfoReader;

import java.util.List;

/**
 * SqlServer数据库信息读取类，暂未实现
 * @author Easy
 * @version 1.0
 * @Email xiyousuiyuan@163.com
 * @Date 2018/10/10
 */
public class SqlServerDatabaseInfoReader implements DatabaseInfoReader {
    @Override
    public List<ColumnInfo> getColumnsInfo(DatabaseConfig dbConfig) {
        return null;
    }

    @Override
    public List<TableInfo> getTablesInfo(DatabaseConfig dbConfig) {
        return null;
    }

    @Override
    public List<TableInfo> getTableInfo(DatabaseConfig dbConfig) {
        return null;
    }

    @Override
    public JavaType dbTypeCoverToJavaType(String dbType) {
        return null;
    }
}
