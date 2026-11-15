package com.hmdp.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("tb_shop_subscribe")
public class ShopSubscribe implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long shopId;
    private Long userId;
    private LocalDateTime createTime;
}
