package com.example.cleancode.policy;

/**
 * @author wooyounggggg
 */
public interface BrokeragePolicy {

    default Long calculate(Long price) {
        // TODO: 가격을 받아서 중개 수수료를 계산한다.
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }

    BrokerageRule createBrokerageRule(Long price);
}
