package com.xu.drools.bean.test;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Messi
 * @Date: 2021/07/13/3:31 下午
 * @Description:
 */
@Data
public class UserContext {

    // 有效下单
    private Integer validOrder;

    // 当前金额
    private Integer money;

    // 当前钻石
    private Integer diamond;

    // 邀请人数量
    private Integer invateCount;

    // 退款数量
    private Integer refundCount;





}


