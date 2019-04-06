package org.zaver.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zaver.code.model.Table;
import org.zaver.code.service.TableService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : TabController
 * @Description TODO
 * @Date : 2019/4/6 11:05
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;
    @GetMapping("/list")
    public List<Table> tabList(){
        List<Table> tabList = tableService.tabList();
        return tabList;
    }
}
