package cn.jiayeli.controller;

import cn.jiayeli.service.TestSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestSer testSer;

    @RequestMapping("/getInstance")
    @ResponseBody
        public String getList(@RequestParam String serviceName) {
        List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    @GetMapping("getList")
    @ResponseBody
    public List<String> getList() {
        System.out.println("provide");
        return testSer.getList();
    }
}
