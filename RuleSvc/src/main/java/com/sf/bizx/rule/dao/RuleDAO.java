package com.sf.bizx.rule.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sf.bizx.BIZXConstants;
import com.sf.bizx.rule.model.Rule;

@Repository
public class RuleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Rule> getRules(String code) {
        String querySql = String.format("SELECT ROW_ID,INTERNAL_ID,EXTERNAL_CODE,EXTERNAL_NAME,LAST_MODIFIED_BY FROM %s.generic_object_t WHERE OBJECT_TYPE = 'Rule' AND  EXTERNAL_CODE = ?", BIZXConstants.DB_SCHEMA);
        return jdbcTemplate.query( querySql, new Object[] { code },new RuleMapper());
    }
    
    class RuleMapper implements RowMapper<Rule> {

        @Override
        public Rule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Rule rule = new Rule();
            rule.setCode(rs.getString("EXTERNAL_CODE"));
            rule.setInternalCode(rs.getLong("INTERNAL_ID"));
            rule.setName(rs.getString("EXTERNAL_NAME"));
            rule.setRowId(rs.getLong("ROW_ID"));
            rule.setLastModifiedBy(rs.getString("LAST_MODIFIED_BY"));
            return rule;
        }
        
    }
}
