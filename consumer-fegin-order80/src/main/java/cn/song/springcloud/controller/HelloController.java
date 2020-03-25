package cn.song.springcloud.controller;


import cn.song.springcloud.entities.CommonResult;
import cn.song.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/feign/{id}")
    public CommonResult getById(@PathVariable("id")Long id){
        return paymentFeignService.get(id);
    }




}
