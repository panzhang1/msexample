package com.sf.bizx.rule.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.rule.model.Rule;
import com.sf.bizx.rule.service.RuleService;
import com.sf.bizx.user.service.UserServiceProxy;

@RestController
public class MockRuleController {
    
    private static final Logger LOG = LoggerFactory.getLogger(MockRuleController.class);
    
    @Autowired
    UserServiceProxy userServiceProxy;
    
    
    @GetMapping(value = "/mock_rule")
    public Rule getRule(@RequestParam(value="code") String code) {
        Rule rule = new Rule();
        rule.setCode("Mock_Rule1");
        rule.setName("Mock_RuleName");
        rule.setLastModifiedBy("Mock_User1");
        
        LOG.info(String.format("-----------getRule:%s", rule.toString()));
        String displayName = userServiceProxy.getUserDisplayName(rule.getLastModifiedBy());
        rule.setLastModifiedBy(displayName);
        
        return rule;
    }
}