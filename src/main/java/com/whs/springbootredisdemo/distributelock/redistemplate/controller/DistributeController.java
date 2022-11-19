package com.whs.springbootredisdemo.distributelock.redistemplate.controller;

import com.whs.springbootredisdemo.distributelock.redistemplate.service.DistributeLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisTemplate分布式锁实现
 * 参考：https://blog.csdn.net/wh2574021892/article/details/124754022
 */
@RestController
public class DistributeController {

    @Autowired
    private DistributeLockService distributeLockService;

    @RequestMapping(value = "/stock")
    public void order() {
        Thread thread = new Thread(()->{
            distributeLockService.reduceStock();
        });
        thread.start();
    }



}

