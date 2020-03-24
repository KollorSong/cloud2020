package cn.song.springcloud.controller;

import cn.song.springcloud.entities.CommonResult;
import cn.song.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HelloController {

//    private String HTTP_URL = "http://localhost:8001";
    private String HTTP_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;

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




}
