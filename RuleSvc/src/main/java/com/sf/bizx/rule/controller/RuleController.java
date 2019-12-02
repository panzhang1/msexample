package com.sf.bizx.rule.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.rule.model.Rule;
import com.sf.bizx.rule.service.RuleService;
import com.sf.bizx.user.service.UserServiceProxy;

@RestController
public class RuleController {
    
    private static final Logger LOG = LoggerFactory.getLogger(RuleController.class);
    
    @Autowired
    RuleService ruleService;
    
    @Autowired
    UserServiceProxy userServiceProxy;
    
    @Autowired
    private DiscoveryClient discoveryClient;

    public void serviceDiscovery() {
        StringBuilder sb = new StringBuilder();
        List<ServiceInstance> list = discoveryClient.getInstances("userservice");
        for (ServiceInstance instance : list) {
            sb.append(instance.getInstanceId()+"\n");
            sb.append(instance.getMetadata().toString());
        }
        LOG.info(String.format("-----------userservice meta:%s", sb.toString()));
    }
    
    @RequestMapping(value = "/rule",method= RequestMethod.GET)
    public Rule getRule(@RequestParam(value="code") String code) {
        Rule rule = null;
        List<Rule> rules = ruleService.getRules(code);
        if (rules.isEmpty()) {
            rule =  new Rule();
            rule.setCode(code);
        } else {
            rule = rules.get(0);
        }
        
        LOG.info(String.format("-----------getRule:%s", rule.toString()));
        String displayName = userServiceProxy.getUserDisplayName(rule.getLastModifiedBy());
        rule.setLastModifiedBy(displayName);
        
        return rule;
    }
}