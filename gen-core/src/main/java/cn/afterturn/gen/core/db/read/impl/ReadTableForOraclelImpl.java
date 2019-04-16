package cn.afterturn.gen.core.db.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;
import cn.afterturn.gen.core.db.read.BaseReadTable;
import cn.afterturn.gen.core.db.read.IReadTable;
import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.core.util.NameUtil;
import cn.afterturn.gen.core.util.TableHandlerUtil;

/**
 * Oracle数据库的实现类
 * @author lingyuwang
 *
 */
public class ReadTableForOraclelImpl extends BaseReadTable implements IReadTable {

    private static String TABLE_SQL = "SELECT TABLE_NAME,COMMENTS as TABLE_COMMENT FROM ALL_TAB_COMMENTS WHERE TABLE_NAME = '%s' AND OWNER = '%s'";

    private static String ALL_TABLE_SQL = "SELECT TAbLE_NAME,COMMENTS as TABLE_COMMENT FROM ALL_TAB_COMMENTS WHERE OWNER = '%s'";

    private static String FIELDS_SQL = "SELECT a.column_name as fieldName,a.data_type as fieldType,(SELECT b.comments FROM ALL_COL_COMMENTS b where b.column_name = a.column_name and b.table_name = a.table_name and b.owner = a.owner) as column_comment,a.DATA_PRECISION as numeric_precision,a.DATA_SCALE as scale,a.CHAR_COL_DECL_LENGTH as charmaxLength,a.NULLABLE as nullable FROM ALL_TAB_COLUMNS a where table_name = '%s' and owner = '%s'";

    private static String SCHEMA_SQL = "SELECT USERNAME FROM DBA_USERS";

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadTableForOraclelImpl.class);

    @Override
    public GenBeanEntity read(String dbName, String tableName) {
        try {
            GenBeanEntity entity = getTableEntiy(dbName, tableName, TABLE_SQL);
            entity.setName(NameUtil.getEntityHumpName(entity.getTableName()));
            entity.setFields(getTableFields(dbName, tableName, FIELDS_SQL));
            TableHandlerUtil.handlerFields(entity.getFields());
            return entity;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("获取表格数据发生异常");
        }
    }

    @Override
    public List<String> getAllDB() {
        try {
            return getAllDB(SCHEMA_SQL);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("获取表格数据发生异常");
        }
    }

    @Override
    public List<GenBeanEntity> getAllTable(String dbName) {
        try {
            return getAllTableEntiy(dbName, ALL_TABLE_SQL);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("获取表格数据发生异常");
        }
    }

    @Override
    protected String handlerTableComment(String comment) {
        if (comment.contains(";")) {
            return comment.split(";")[0];
        }
        if (comment.startsWith("InnoDB free")) {
            return null;
        }
        return comment;
    }

}
