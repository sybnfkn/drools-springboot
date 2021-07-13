package com.xu.drools.bean.test;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Messi
 * @Date: 2021/07/13/4:38 下午
 * @Description:
 */
@Data
public class CommonLimit {

    // 钻石上限
    private Integer diamonUpperLimit;

    // 现金上限
    private Integer moneyUpperLimit;

    // 邀请人数
    private Integer inviteCountUpperLimit;

    // 退款上限
    private Integer refundCountUpperLimit;

    // 扣款金额下限
    private Integer moneyLowerLimit;

}
