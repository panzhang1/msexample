package com.sf.hop;

import com.sf.hop.config.DbPoolConfig;
import com.sf.hop.config.ServiceConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceConfigTest {
    private static final Logger logger = LoggerFactory.getLogger(ServiceConfigTest.class);
    @Autowired
    private ServiceConfig serviceConfig;

    //@Autowired
    private VaultTemplate vaultTemplate;

    @Autowired
    private DbPoolConfig dbPoolConfig;

    @Test
    @Disabled
    public void testVaultConfig() {
        StringBuilder sb = new StringBuilder("testVaultConfig\n");
        
        sb.append(serviceConfig.getKey1()).append("\n");
        sb.append(serviceConfig.getKey2()).append("\n");
        
        logger.info(sb.toString());
    }

    @Test
    @Disabled
    public void testVaultDBConfig() {
        StringBuilder sb = new StringBuilder("testDbVaultConfig\n");

        sb.append(dbPoolConfig.getDatasources().toString()).append("\n");
        sb.append(dbPoolConfig.getDbPool().toString()).append("\n");

        logger.info(sb.toString());
    }

    public void testSpringVault() {
        VaultResponse response = vaultTemplate.read("secret/data/userservice");
        String jsonString = response.getData().get("data").toString();
        StringBuilder sb = new StringBuilder("testSpringVault\n");
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            sb.append(jsonObject.get("vault_key1")).append("\n");
            sb.append(jsonObject.get("vault_key2")).append("\n");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        logger.info(sb.toString());
    }

    public void testServiceConfig() {
        StringBuilder sb = new StringBuilder();
        sb.append(serviceConfig.getAppFeature1()).append("\n");
        sb.append(serviceConfig.getAppEnvFeature1()).append("\n");
        sb.append(serviceConfig.getServiceFeature1()).append("\n");
        sb.append(serviceConfig.getServiceEnvFeature1()).append("\n");
        
        logger.info(sb.toString());
    }
}
