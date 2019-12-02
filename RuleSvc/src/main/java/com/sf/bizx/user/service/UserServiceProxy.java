package com.sf.bizx.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sf.bizx.user.model.User;

@Component
public class UserServiceProxy {
    private static final String END_POINT = "http://usersvc/user/";
    private static final String MOCK_END_POINT = "http://usersvc/mock_user/";
    
    @Autowired
    RestTemplate restTemplate;

    public String getUserDisplayName(String userId) {
        return getUserDisplayNameFromService(END_POINT, userId);
    }
    
    public String getMockUserDisplayName(String userId) {
        return getUserDisplayNameFromService(MOCK_END_POINT, userId);
    }
    
    private String formatUser(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
    
    private String getUserDisplayNameFromService(String serverEndpoint,String userId) {
        User user = restTemplate.getForObject(serverEndpoint + userId, User.class);
        return formatUser(user);
    }
}
