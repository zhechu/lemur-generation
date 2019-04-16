package cn.afterturn.gen.core.db.convert.sql;

import static cn.afterturn.gen.core.GenCoreConstant.DB2;
import static cn.afterturn.gen.core.GenCoreConstant.MYSQL;
import static cn.afterturn.gen.core.GenCoreConstant.ORACLE;

import cn.afterturn.gen.core.db.convert.sql.impl.SqlConvertOfDB2;
import cn.afterturn.gen.core.db.convert.sql.impl.SqlConvertOfMysql;
import cn.afterturn.gen.core.db.convert.sql.impl.SqlConvertOfOracle;
import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;

/**
 * @author JueYue on 2017/10/25.
 */
public class SqlConvertFactory {

    public static ISqlConvert getReadTable(String dbType) {
        if (MYSQL.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfMysql();
        }
        if (DB2.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfDB2();
        }
        if (ORACLE.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfOracle();
        }
        throw new GenerationRunTimeException("数据库不支持");
    }
}
