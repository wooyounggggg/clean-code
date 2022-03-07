package com.example.cleancode.controller;

import com.example.cleancode.constants.ActionType;
import com.example.cleancode.policy.BrokeragePolicy;
import com.example.cleancode.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wooyounggggg
 *
 * 중개 수수료가 얼마인지 조회하는 컨트롤
 */
@RestController
public class BrokerageQueryController {

    @GetMapping("/api /calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType, @RequestParam Long price) {
        /* TODO: 중개 수수료 계산 로직*/
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
