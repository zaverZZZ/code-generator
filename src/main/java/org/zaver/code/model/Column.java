package org.zaver.code.model;

import org.zaver.code.utils.Utils;

/**
 * @ClassName : Column
 * @Description TODO
 * @Date : 2019/4/6 13:28
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
public class Column {
   private String tableCatalog;
   private String isNullable;
   private String tableName;
   private String tableSchema;
   private String extra;
   private String columnName;
   private String columnKey;
   private Integer numericPrecision;
   private String privileges;
   private String columnComment;
   private Integer numericScale;
   private String columnType;
   private Integer ordinalPosition;
   private String dataType;

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public Integer getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Integer numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public Integer getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Integer numericScale) {
        this.numericScale = numericScale;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        String s = "	private " + this.columnType + " " + this.columnName + ";\n";
        return s;
    }
    public String toGetString() {
        String s = "	public " + this.columnType + " get"+Utils.toUpperFristChar(this.columnName)+"(){\n"+
                "		return "+this.columnName+";\n	}\n";
        return s;
    }
    public String toSetString() {
        String s = "	public void set"+Utils.toUpperFristChar(this.columnName)+"("+this.columnType+" "+this.columnName+"){\n" +
                "		this."+this.columnName +" = "+this.columnName+ ";\n	}\n";
        return s;
    }
    public String getTableNameStr(){
        String s = "public class " + Utils.makeTableName(tableName) + " implements Serializable" + "{\n\n";
        return s;
    }
}
