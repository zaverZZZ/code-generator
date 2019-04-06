package org.zaver.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zaver.code.dao.ColumnDao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : ColumnService
 * @Description TODO
 * @Date : 2019/4/6 11:23
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@Service
public class ColumnService {

    @Autowired
    private ColumnDao columnDao;

    public List<Map<String,Object>> columnInfo(String tableName){
        List<Map<String, Object>> columnInfo = columnDao.columnInfo(tableName);
        return columnInfo;
    }
}
