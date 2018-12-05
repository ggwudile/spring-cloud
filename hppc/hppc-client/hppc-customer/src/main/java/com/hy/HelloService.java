package com.hy;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lizheng on 2017/7/21.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //注解指定发生错误时的回调方法
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService() {
        //Get请求调用服务，restTemplate被@LoadBalanced注解标记，Get方法会自动进行负载均衡
        return restTemplate.getForObject("http://SERVICE-AB/info", String.class);
    }

    /**
     * 服务发生错误当时候返回固定当相应
     * 参数和返回值必须和服务保持一致
     * @return
     */
    public String  helloFallBack() {
        return "Error occurred ！";
    }

}


