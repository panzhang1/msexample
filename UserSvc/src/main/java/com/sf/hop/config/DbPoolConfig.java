package com.sf.hop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix="platform.database")
public class DbPoolConfig {
    private Map<String, DbConfig> dbPool = new HashMap<>();

    public Map<String, DbConfig> getDbPool() {
        return dbPool;
    }

    public void setDbPool(Map<String, DbConfig> dbPool) {
        this.dbPool = dbPool;
    }

    public List<DbConfig> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<DbConfig> datasources) {
        this.datasources = datasources;
    }

    private List<DbConfig> datasources = new ArrayList<>();

    public static class DbConfig {
        private String username;
        private String password;

        @Override
        public String toString() {
            return "DbConfig{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
