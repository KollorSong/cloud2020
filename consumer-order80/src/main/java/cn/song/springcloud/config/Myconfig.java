package cn.song.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Myconfig {

    @Bean
    @LoadBalanced  //负载均衡，默认为轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
