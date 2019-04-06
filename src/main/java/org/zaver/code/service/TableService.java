package org.zaver.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zaver.code.dao.TableDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : TableService
 * @Description TODO
 * @Date : 2019/4/6 11:02
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@Service
public class TableService {
    @Autowired
    private TableDao tableDao;

    public List<Map<String,Object>> tabList(){
        List<Map<String, Object>> tableList = tableDao.tableList();
        return tableList;
    }

}
