package cn.jiayeli.controller;

import cn.jiayeli.service.impl.TestSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class TestService {

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestSerImpl testSer;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("service-provide");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancer.choose("service-provide").getUri().toString();
    }

    @GetMapping("getListByDiscover")
    public Object getListsByDiscover() {
        URI serviceId = loadBalancer.choose("service-provide").getUri();
        return restTemplate.getForEntity(serviceId+"/getList",  String.class);
    }

    /**
     * 服务远程调用consul中注册的provide服务中的方法实现，具体实现为testSer接口和实现类中
     * @return
     */
    @GetMapping("/getList")
    @ResponseBody
    public List<String> getList() {
        return testSer.getList();
    }
}
