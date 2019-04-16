package cn.afterturn.gen.core.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.afterturn.gen.core.model.GenFieldEntity;

/**
 * 表处理通用类
 *
 * @author JueYue on 2017/10/25.
 */
public class TableHandlerUtil {

    private TableHandlerUtil() {

    }

    /**
     * 处理一遍字段,根据字段类型做合适的处理
     */
    public static void handlerFields(List<GenFieldEntity> fields) {
        GenFieldEntity entity;
        for (int i = 0, le = fields.size(); i < le; i++) {
            entity = fields.get(i);
            entity.setChinaName(getFieldName(entity.getFieldName(), entity.getComment()));
            if (entity.getChinaName().equals(entity.getComment())) {
                entity.setComment(null);
            }
            entity.setName(NameUtil.getFieldHumpName(entity.getFieldName()));
            entity.setType(convertType(entity.getFieldType(), entity.getFieldPointLength()));
            entity.setJdbcType(convertJdbcType(entity.getFieldType()));
        }
    }

    /**
     * 处理字段名称
     */
    public static String getFieldName(String fieldName, String comment) {
        if (StringUtils.isNotEmpty(comment)) {
            String[] nameAndComment = comment.split(",");
            return nameAndComment[0];
        }
        return NameUtil.getEntityHumpName(fieldName);
    }

    /**
     * 转换类型
     */
    public static String convertType(String dataType, Integer pointLength) {
        dataType = dataType.toLowerCase();
        if (dataType.contains("char") || dataType.contains("text")) {
            dataType = "java.lang.String";
        } else if (dataType.contains("int")) {
            dataType = "java.lang.Integer";
        } else if (dataType.contains("float")) {
            dataType = "java.lang.Float";
        } else if (dataType.contains("double")) {
            dataType = "java.lang.Double";
        } else if (dataType.contains("number")) {
            if (pointLength != null && pointLength > 0) {
                dataType = "java.lang.Double";
            }/* else if (StringUtils.isNotEmpty(precision) && Integer.parseInt(precision) > 10) {
                dataType = "Long";
            }*/ else {
                dataType = "java.lang.Integer";
            }
        } else if (dataType.contains("decimal")) {
            dataType = "java.math.BigDecimal";
        } else if (dataType.contains("date")) {
            dataType = "java.util.Date";
        } else if (dataType.contains("time")) {
            dataType = "java.util.Date";
        } else if (dataType.contains("blob")) {
            dataType = "byte[]";
        } else if (dataType.contains("clob")) {
            //dataType = "java.sql.Clob";
            dataType = "java.lang.String";
        } else if (dataType.contains("numeric")) {
            dataType = "java.math.BigDecimal";
        } else {
            dataType = "java.lang.Object";
        }
        return dataType;
    }
    
    /**
     * 转换jdbc类型
     */
    public static String convertJdbcType(String dataType) {
        dataType = dataType.toLowerCase();
        if (dataType.equals("char")) {
            dataType = "CHAR";
        } else if (dataType.contains("char") || dataType.contains("text")) {
            dataType = "VARCHAR";
        } else if (dataType.contains("int")) {
            dataType = "INTEGER";
        } else if (dataType.contains("float")) {
            dataType = "FLOAT";
        } else if (dataType.contains("double")) {
            dataType = "DOUBLE";
        } else if (dataType.contains("number")) {
            dataType = "NUMERIC";
        } else if (dataType.contains("decimal")) {
            dataType = "NUMERIC";
        } else if (dataType.contains("date")) {
            dataType = "DATE";
        } else if (dataType.contains("time")) {
            dataType = "DATE";
        } else if (dataType.contains("blob")) {
            dataType = "BLOB";
        } else if (dataType.contains("clob")) {
            dataType = "VARCHAR";
        } else if (dataType.contains("numeric")) {
            dataType = "NUMERIC";
        } else {
            dataType = "VARCHAR";
        }
        return dataType;
    }
}
