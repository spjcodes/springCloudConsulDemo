package cn.jiayeli.service.impl;

import cn.jiayeli.service.TestSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Service
public class TestSerImpl implements TestSer {
    @Autowired
    private TestSer testSer;

    @Override
    public List<String> getList() {
        return testSer.getList().stream().map(e -> String.valueOf(Arrays.hashCode(e.getBytes()))).toList();
    }
}
