package com.sf.bizx.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.bizx.rule.dao.RuleDAO;
import com.sf.bizx.rule.model.Rule;

@Service
public class RuleService {
    @Autowired
    RuleDAO ruleDao;
    
    public List<Rule> getRules(String code) {
        return ruleDao.getRules(code);
    }
}
