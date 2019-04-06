package org.zaver.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zaver.code.service.GeneratorService;

/**
 * @ClassName : GeneratorController
 * @Description TODO
 * @Date : 2019/4/6 15:48
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
@RestController
@RequestMapping("/gen")
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;
    @RequestMapping("/model/{tableName}")
    public Boolean generatorModel(@PathVariable("tableName") String tableName){
        boolean b = generatorService.generateModel(tableName);
        return b;
    }
    @RequestMapping("/allModel")
    public Boolean generatorAllModel(){
        boolean flag = generatorService.generateAllModel();
        return flag;
    }
    @RequestMapping("/dao/{tableName}")
    public Boolean generatorDao(@PathVariable("tableName") String tableName){
        boolean flag = generatorService.generateDao(tableName);
        return flag;
    }
    @RequestMapping("/allDao")
    public Boolean generatorAllDao(){
        boolean flag = generatorService.generateAllDao();
        return flag;
    }
    @RequestMapping("/service/{tableName}")
    public Boolean generatorService(@PathVariable("tableName") String tableName){
        boolean flag = generatorService.generateService(tableName);
        return flag;
    }
    @RequestMapping("/allService")
    public Boolean generatorAllService(){
        boolean flag = generatorService.generateAllService();
        return flag;
    }
    @RequestMapping("/impl/{tableName}")
    public Boolean generatorImpl(@PathVariable("tableName") String tableName){
        boolean flag = generatorService.generateServiceImpl(tableName);
        return flag;
    }
    @RequestMapping("/allImpl")
    public Boolean generatorAllImpl(){
        boolean flag = generatorService.generateAllServiceImpl();
        return flag;
    }
    @RequestMapping("/mapper/{tableName}")
    public Boolean generatorMapper(@PathVariable("tableName") String tableName){
        boolean flag = generatorService.generateMapper(tableName);
        return flag;
    }
    @RequestMapping("/allMapper")
    public Boolean generatorAllMapper(){
        boolean flag = generatorService.generateAllMapper();
        return flag;
    }
}
