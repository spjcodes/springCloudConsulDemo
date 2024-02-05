package cn.jiayeli.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("service-provide")
public interface TestSer {

    @GetMapping("getList")
    public List<String> getList();
}
