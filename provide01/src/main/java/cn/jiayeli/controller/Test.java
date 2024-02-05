package cn.jiayeli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test")
public class Test {

    @GetMapping("list")
    @ResponseBody
    public List<String> getList() {
        return List.of("A", "b", "C");
    }
}
