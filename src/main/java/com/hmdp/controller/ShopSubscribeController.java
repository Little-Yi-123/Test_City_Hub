package com.hmdp.controller;


import com.hmdp.dto.Result;
import com.hmdp.service.IShopSubscribeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/subscribe")
public class ShopSubscribeController {

    @Resource
    private IShopSubscribeService shopSubscribeService;

    @PostMapping("/{shopId}")
    public Result subscribe(@PathVariable Long shopId) {
        return shopSubscribeService.subscribe(shopId);
    }

    @DeleteMapping("/{shopId}")
    public Result unSubscribe(@PathVariable Long shopId) {
        return shopSubscribeService.unsubscribe(shopId);
    }

    @GetMapping("/status/{shopId}")
    public Result getStatus(@PathVariable Long shopId) {
        return shopSubscribeService.isSubscribed(shopId);
    }
}
