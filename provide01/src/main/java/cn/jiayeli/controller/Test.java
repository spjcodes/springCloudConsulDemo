package cn.jiayeli.controller;

import cn.jiayeli.service.TestSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Test {

    @Autowired
    private TestSer testSer;

/*
    @GetMapping("list")
    @ResponseBody
    public List<String> getList() {
        return List.of("A", "b", "C");
    }
*/

    @GetMapping("getList")
    @ResponseBody
    public List<String> getList() {
        System.out.println("provide_01");
        return testSer.getList();
    }
}
