package org.zaver.code.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zaver.code.model.Table;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TableDao extends BaseMapper<Table> {

    @Select("select * from information_schema.TABLES where TABLE_SCHEMA=(select database())")
    List<Table> tableList();

}
