package cn.song.springcloud.dao;


import cn.song.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment  getByid(@Param("id") Long id);

}
