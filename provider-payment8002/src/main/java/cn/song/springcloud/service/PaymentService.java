package cn.song.springcloud.service;

import cn.song.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment get(Long id);
}
