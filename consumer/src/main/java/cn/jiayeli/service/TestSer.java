package cn.jiayeli.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 声明为feign客户端
 * 创建一个具有该接口的REST客户端（例如，用于自动装配到另一个组件中）。
 * 如果可用，将使用SC LoadBalancer来负载均衡后端请求，并且可以使用与Feign客户端相同的名称（即值）配置负载均衡器。
 */
@FeignClient("service-provide")
public interface TestSer {

    /**
     * feign 内部集成了 rabbion 和resultTemplate并且实现了SpringMVC可使用SpringMVC的注解来实现负载均衡和远程过程调用
     * @return
     */
    @GetMapping("getList")
    public List<String> getList();
}
