package cn.song.myrule;


import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * 注意一定不能被主类所在包和子包范围内
 */
@Configuration
public class MyselfRule  {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }


}
