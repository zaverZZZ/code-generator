package org.zaver.code.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zaver.code.dao.ColumnDao;
import org.zaver.code.dao.TableDao;
import org.zaver.code.enums.Enums;
import org.zaver.code.model.Column;
import org.zaver.code.model.Table;
import org.zaver.code.utils.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName : GeneratorService
 * @Description TODO
 * @Date : 2019/4/6 15:50
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@Service
public class GeneratorService {

    @Autowired
    private TableDao tableDao;
    @Autowired
    private ColumnDao columnDao;

    /**
     *生成单个表的model
     * @param tableName 数据库表名称
     * @return 成功失败
     */
    public boolean generateModel(String tableName){
        List<Column> columns = columnDao.columnInfo(tableName);
        if(columns==null||columns.size()==0)return false;
        if(Enums.TABLE_PREFIX.getValue().trim().length()!=0){
            tableName = tableName.substring(Enums.TABLE_PREFIX.getValue().length());
        }
        for (Column column:columns) {
            column.setColumnName(Utils.makeColumnName(column.getColumnName()));
            column.setColumnType(Utils.typeConversion(column.getDataType().toUpperCase()));
        }
        // 生成model文件内容的字符串
        StringBuffer fileString = Utils.getModelFileString(tableName,columns);
        // 生成model文件
        String packageName = Enums.PACKAGE_NAME.getValue()+"."+Enums.MODELPACK_NAME.getValue();
        boolean flag = Utils.toFile(Enums.JAVA_FILE.getValue(),packageName,fileString, tableName,"");
        return flag;
    }

    /**
     * 生成所有表的model
     * @return 成功与否
     */
    public boolean generateAllModel(){
        List<Table> tables = tableDao.tableList();
        for (Table table : tables) {
            boolean flag = this.generateModel(table.getTableName());
            if (!flag) return flag;
        }
        return true;
    }

    /**
     * 生成单表的DAO
     * @param tableName 表名
     * @return 成功标志
     */
    public boolean generateDao(String tableName){
        if(Enums.TABLE_PREFIX.getValue().trim().length()!=0){
            tableName = tableName.substring(Enums.TABLE_PREFIX.getValue().length());
        }
        StringBuffer fileString = Utils.getDaoFileString(tableName);
        String packageName = Enums.PACKAGE_NAME.getValue()+"."+Enums.DAOPACK_NAME.getValue();
        boolean flag = Utils.toFile(Enums.JAVA_FILE.getValue(),packageName, fileString, tableName,
                Utils.toUpperFristChar(Enums.DAOPACK_NAME.getValue()));
        return flag;
    }

    /**
     * 生成所有表的DAO
     * @return 成功标志
     */
    public boolean generateAllDao(){
        List<Table> tables = tableDao.tableList();
        for (Table table : tables) {
            boolean flag = this.generateDao(table.getTableName());
            if (!flag) return flag;
        }
        return true;
    }

    public boolean generateService(String tableName){
        if(Enums.TABLE_PREFIX.getValue().trim().length()!=0){
            tableName = tableName.substring(Enums.TABLE_PREFIX.getValue().length());
        }
        StringBuffer fileString = Utils.getServiceFileString(tableName);
        String packageName = Enums.PACKAGE_NAME.getValue()+"."+Enums.SERVICEPACK_NAME.getValue();
        boolean flag = Utils.toFile(Enums.JAVA_FILE.getValue(),packageName, fileString, tableName,
                Utils.toUpperFristChar(Enums.SERVICEPACK_NAME.getValue()));
        return flag;
    }

    public boolean generateAllService(){
        List<Table> tables = tableDao.tableList();
        for (Table table : tables) {
            boolean flag = this.generateService(table.getTableName());
            if (!flag) return flag;
        }
        return true;
    }

    public boolean generateServiceImpl(String tableName){
        if(Enums.TABLE_PREFIX.getValue().trim().length()!=0){
            tableName = tableName.substring(Enums.TABLE_PREFIX.getValue().length());
        }
        StringBuffer fileString = Utils.getServiceImplFileString(tableName);
        String packageName = Enums.PACKAGE_NAME.getValue()
                + "." + Enums.SERVICEPACK_NAME.getValue()
                + "." + Enums.IMPLPACK_NAME.getValue();
        boolean flag = Utils.toFile(Enums.JAVA_FILE.getValue(),packageName, fileString, tableName,
                Utils.toUpperFristChar(Enums.SERVICEPACK_NAME.getValue()+Enums.IMPLPACK_NAME.getValue()));
        return flag;
    }

    public boolean generateAllServiceImpl(){
        List<Table> tables = tableDao.tableList();
        for (Table table : tables) {
            boolean flag = this.generateServiceImpl(table.getTableName());
            if (!flag) return flag;
        }
        return true;
    }
    public boolean generateMapper(String tableName){
        if(Enums.TABLE_PREFIX.getValue().trim().length()!=0){
            tableName = tableName.substring(Enums.TABLE_PREFIX.getValue().length());
        }
        StringBuffer fileString = Utils.getMapperFileString(tableName);
        String packageName = Enums.MAPPERPACK_NAME.getValue();
        boolean flag = Utils.toFile(Enums.XML_FILE.getValue(),packageName, fileString, tableName,
                Utils.toUpperFristChar(Enums.MAPPERPACK_NAME.getValue()));
        return flag;
    }
    public boolean generateAllMapper(){
        List<Table> tables = tableDao.tableList();
        for (Table table : tables) {
            boolean flag = this.generateMapper(table.getTableName());
            if (!flag) return flag;
        }
        return true;
    }


}
