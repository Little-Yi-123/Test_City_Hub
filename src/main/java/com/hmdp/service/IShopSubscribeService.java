package com.hmdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopSubscribe;

public interface IShopSubscribeService extends IService<ShopSubscribe> {
    Result subscribe(Long shopId);
    Result unsubscribe(Long shopId);
    Result isSubscribed(Long shopId);
}
