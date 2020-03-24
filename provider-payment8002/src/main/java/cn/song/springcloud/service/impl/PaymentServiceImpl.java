package cn.song.springcloud.service.impl;

import cn.song.springcloud.dao.PaymentDao;
import cn.song.springcloud.entities.Payment;
import cn.song.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment get(Long id) {
        return paymentDao.getByid(id);
    }
}
