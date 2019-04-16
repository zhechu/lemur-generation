package cn.afterturn.gen.core.db.read;

import static cn.afterturn.gen.core.GenCoreConstant.MYSQL;
import static cn.afterturn.gen.core.GenCoreConstant.ORACLE;

import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;
import cn.afterturn.gen.core.db.read.impl.ReadTableForMysqlImpl;
import cn.afterturn.gen.core.db.read.impl.ReadTableForOraclelImpl;

/**
 * 读取库的工厂
 *
 * @author JueYue
 * @date 2014年12月25日
 */
public class ReadTableFactory {

    public static IReadTable getReadTable(String dbType) {
        if (MYSQL.equalsIgnoreCase(dbType)) {
            return new ReadTableForMysqlImpl();
        }
        if (ORACLE.equalsIgnoreCase(dbType)) {
        	return new ReadTableForOraclelImpl();
        }
        throw new GenerationRunTimeException("数据库不支持");
    }

    public static String getDeiver(String dbType) {
        if (MYSQL.equalsIgnoreCase(dbType)) {
            return "com.mysql.jdbc.Driver";
        }
        if (ORACLE.equalsIgnoreCase(dbType)) {
        	return "oracle.jdbc.OracleDriver";
        }
        throw new GenerationRunTimeException("数据库不支持");
    }
}
