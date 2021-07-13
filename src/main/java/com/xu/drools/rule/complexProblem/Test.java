package com.xu.drools.rule.complexProblem;

import com.xu.drools.bean.test.CommonLimit;
import com.xu.drools.bean.test.UserContext;
import com.xu.drools.bean.test.UserCreateOrderTemplate;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Messi
 * @Date: 2021/07/13/3:28 下午
 * @Description:
 */
public class Test {

    public static void main(final String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute(kc);
    }

    private static void execute(KieContainer kc) {
        KieSession ksession = kc.newKieSession("testKS");
        UserContext userContext = new UserContext();
        /**
         * 准备用户的基础信息
         */
        userContext.setMoney(200);
        userContext.setDiamond(200);
        userContext.setValidOrder(1);
        userContext.setInvateCount(20);
        userContext.setRefundCount(1);
        /**
         * 邀请人加金币钻石模版,下完一单 加100块钱，20钻石
         */
        UserCreateOrderTemplate userCreateOrderTemplate = new UserCreateOrderTemplate();
        userCreateOrderTemplate.setCreateOrderCount(1);
        userCreateOrderTemplate.setAddMoney(100);
        userCreateOrderTemplate.setAddDiamond(20);

        /**
         * 加现金钻石通用限制
         */
        CommonLimit commonLimit = new CommonLimit();
        commonLimit.setDiamonUpperLimit(4200);
        commonLimit.setMoneyUpperLimit(1000);
        commonLimit.setRefundCountUpperLimit(10);
        commonLimit.setInviteCountUpperLimit(30);

        ksession.insert(userContext);
        ksession.insert(userCreateOrderTemplate);
        ksession.insert(commonLimit);
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println(userContext.getMoney() + "----" +userContext.getDiamond());
    }

}
