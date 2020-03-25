package cn.song.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndEncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = (current >= Integer.MAX_VALUE) ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));//当对比不等于的时候，返回ture，停止循环
        System.out.println(next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndEncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
