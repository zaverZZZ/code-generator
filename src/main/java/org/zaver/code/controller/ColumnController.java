package org.zaver.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zaver.code.service.ColumnService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : ColumnController
 * @Description TODO
 * @Date : 2019/4/6 11:26
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@RestController
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @GetMapping("/info/{tableName}")
    public List<Map<String,Object>> columnInfo(@PathVariable("tableName") String tableName){
        List<Map<String, Object>> columnInfo = columnService.columnInfo(tableName);
        return columnInfo;
    }
}
