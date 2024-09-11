package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PayController {
    @Resource
    PayService payService;

    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.add(pay);
        return i > 0 ? "success" : "fail";
    }

    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        log.info("delete id:" + id);
        return payService.delete(id);
    }
    @PutMapping("pay/update")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,pay);
        int update = payService.update(pay);
        return update > 0 ? "success" : "fail";
    }
    @GetMapping(value="pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.getById(id);
    }

    @GetMapping(value="pay/getAll")
    public Iterable<Pay> getAll(){
        return payService.getAll();
    }
}
