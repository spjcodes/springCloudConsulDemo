package cn.jiayeli.service.impl;

import cn.jiayeli.service.TestSer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TestSerImpl implements TestSer {
    @Override
    public List<String> getList() {
        return List.of("A","B","C");
    }
}
