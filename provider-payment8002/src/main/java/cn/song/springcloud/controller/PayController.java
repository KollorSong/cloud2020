package cn.song.springcloud.controller;

import cn.song.springcloud.entities.CommonResult;
import cn.song.springcloud.entities.Payment;
import cn.song.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PayController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        CommonResult commonResult = new CommonResult();


        if (result > 0){
            commonResult.setCode(200);
            commonResult.setMessage("创建成功");
        }else {
            commonResult.setCode(400);
            commonResult.setMessage("创建shibai");
        }

        return commonResult;

    }

    @RequestMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){

        System.out.println(port);

        Payment result = paymentService.get(id);
        CommonResult commonResult = new CommonResult();

        if (result != null){
            commonResult.setCode(200);
            commonResult.setMessage("获取成功:"+port);
        }else {
            commonResult.setCode(400);
            commonResult.setMessage("获取失败");
        }

        commonResult.setData(result);

        return commonResult;

    }


}