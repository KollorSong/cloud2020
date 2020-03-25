package cn.song.springcloud.service;


import cn.song.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {

    @RequestMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);

}
