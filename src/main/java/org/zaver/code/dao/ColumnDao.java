package org.zaver.code.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : ColumnDao
 * @Description TODO
 * @Date : 2019/4/6 11:20
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@Mapper
@Repository
public interface ColumnDao {
    @Select("select * from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
    List<Map<String,Object>> columnInfo(String tableName);
}
