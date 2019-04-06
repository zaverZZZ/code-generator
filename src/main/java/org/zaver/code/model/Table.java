package org.zaver.code.model;

import java.io.Serializable;

/**
 * @ClassName : Table
 * @Description TODO
 * @Date : 2019/4/6 12:42
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
public class Table implements Serializable {

    private String tableCatalog;
    private String tableComment;
    private String tableName;
    private String tableSchema;
    private String engine;
    private String tableType;
    private Integer tableRows;
    private Integer avgRowLength;
    private Integer dataLength;
    private Integer dataFree;
    private Integer indexLength;
    private String rowFormat;
    private Integer autoIncrement;
    private Integer version;
    private String createOptions;
    private String createTime;
    private Integer maxDataLength;
    private String tableCollation;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public Integer getTableRows() {
        return tableRows;
    }

    public void setTableRows(Integer tableRows) {
        this.tableRows = tableRows;
    }

    public Integer getAvgRowLength() {
        return avgRowLength;
    }

    public void setAvgRowLength(Integer avgRowLength) {
        this.avgRowLength = avgRowLength;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getDataFree() {
        return dataFree;
    }

    public void setDataFree(Integer dataFree) {
        this.dataFree = dataFree;
    }

    public Integer getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(Integer indexLength) {
        this.indexLength = indexLength;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    public Integer getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Integer autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateOptions() {
        return createOptions;
    }

    public void setCreateOptions(String createOptions) {
        this.createOptions = createOptions;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getMaxDataLength() {
        return maxDataLength;
    }

    public void setMaxDataLength(Integer maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    public String getTableCollation() {
        return tableCollation;
    }

    public void setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
    }
}
