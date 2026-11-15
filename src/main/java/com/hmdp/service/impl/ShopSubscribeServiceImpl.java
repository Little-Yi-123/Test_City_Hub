package com.hmdp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopSubscribe;
import com.hmdp.mapper.ShopSubscribeMapper;
import com.hmdp.service.IShopSubscribeService;
import com.hmdp.utils.UserHolder;
import org.springframework.stereotype.Service;

@Service
public class ShopSubscribeServiceImpl extends ServiceImpl<ShopSubscribeMapper, ShopSubscribe> implements IShopSubscribeService {

    @Override
    public Result subscribe(Long shopId) {
        Long userId = UserHolder.getUser().getId();
        int count = query().eq("user_id", userId).eq("shop_id", shopId).count();
        if (count > 0) {
            return Result.ok(); // 已经订阅了，直接返回成功
        }
        ShopSubscribe s = new ShopSubscribe();
        s.setUserId(userId);
        s.setShopId(shopId);
        save(s); // 插入数据库
        return Result.ok();
    }

    @Override
    public Result unsubscribe(Long shopId) {
        Long userId = UserHolder.getUser().getId();
        remove(new QueryWrapper<ShopSubscribe>()
                .eq("user_id", userId)
                .eq("shop_id", shopId));
        return Result.ok();
    }

    @Override
    public Result isSubscribed(Long shopId) {
        Long userId = UserHolder.getUser().getId();
        int count = query().eq("user_id", userId).eq("shop_id", shopId).count();
        // 无论订没订，查询操作都算成功，把 true/false 返回给前端
        return Result.ok(count > 0);
    }
}