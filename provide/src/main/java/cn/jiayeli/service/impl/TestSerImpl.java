package cn.jiayeli.service.impl;

import cn.jiayeli.service.TestSer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSerImpl implements TestSer {
    @Override
    public List<String> getList() {
        return List.of("AA","BB","CC");
    }
}
