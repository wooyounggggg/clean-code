package com.example.cleancode.policy;

import lombok.AllArgsConstructor;

/**
 * @author wooyounggggg
 *
 * 가격이 특정 범위일 때 상한요율과 상한 금액을 가지는 클래스
 */
@AllArgsConstructor
public class BrokerageRule {

    private Double brokeragePercent;
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        if (limitAmount == null) {
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        Double amount = Math.floor(brokeragePercent / 100 * price);
        return amount.longValue();
    }
}
