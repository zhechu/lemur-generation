package cn.afterturn.gen.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库表属性
 *
 * @author JueYue
 * @date 2014年12月21日
 */
public class GenBeanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 表名
     */
    private String tableName;
    /**
     * Java 表名
     */
    private String name;
    /**
     * 中文名称
     */
    private String chinaName;
    /**
     * 注释
     */
    private String comment;
    /**
     * 是否导入Excel
     */
    private Integer isImport;

    /**
     * 是否导出Excel
     */
    private Integer isExport;

    /**
     * 是否分页
     */
    private Integer isPagination;

    /**
     * 是否添加日志
     */
    private Integer isLog;

    /**
     * 是否添加协议
     */
    private Integer isProtocol;
    
    /**
     * 主键名称
     */
    private String idName;
    
    /**
     * 主键类型
     */
    private String idType;
    
    /**
     * 数据库主键名称
     */
    private String idFieldName;
    
    /**
     * 主键jdbc类型
     */
    private String idJdbcType;
    
    /**
     * 表字段
     */
    private List<GenFieldEntity> fields;

    public List<GenFieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<GenFieldEntity> fields) {
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }

    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    public Integer getIsPagination() {
        return isPagination;
    }

    public void setIsPagination(Integer isPagination) {
        this.isPagination = isPagination;
    }

    public Integer getIsLog() {
        return isLog;
    }

    public void setIsLog(Integer isLog) {
        this.isLog = isLog;
    }

    public Integer getIsProtocol() {
        return isProtocol;
    }

    public void setIsProtocol(Integer isProtocol) {
        this.isProtocol = isProtocol;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdFieldName() {
        return idFieldName;
    }

    public void setIdFieldName(String idFieldName) {
        this.idFieldName = idFieldName;
    }

    public String getIdJdbcType() {
        return idJdbcType;
    }

    public void setIdJdbcType(String idJdbcType) {
        this.idJdbcType = idJdbcType;
    }
    
}
