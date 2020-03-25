package cn.song.springcloud.controller;

import cn.song.springcloud.entities.CommonResult;
import cn.song.springcloud.entities.Payment;
import cn.song.springcloud.lb.LoadBalancer;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class HelloController {

//    private String HTTP_URL = "http://localhost:8001";
    private String HTTP_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> testGet(@PathVariable("id") Long id){
        System.out.println(id);
        return template.getForObject(HTTP_URL+"/payment/get/"+id,CommonResult.class);
    }


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> testPost(Payment payment){
        System.out.println(payment);
        return template.postForObject(HTTP_URL+"/payment/create",payment,CommonResult.class);
    }



    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getEntity(@PathVariable("id") Long id){
        System.out.println(id);
        ResponseEntity<CommonResult> resultResponseEntity = template.getForEntity(HTTP_URL+"/payment/get/"+id,CommonResult.class);
        if (resultResponseEntity.getStatusCode().is2xxSuccessful()){
            return resultResponseEntity.getBody();
        }else {
            return new CommonResult<>(444,"获取失败");
        }
    }


    @GetMapping("/consumer/payment/lb")
    public CommonResult<Payment> testLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        String path = uri + "/payment/lb";
        System.out.println(path);
        return template.getForObject(path,CommonResult.class);
    }




}
