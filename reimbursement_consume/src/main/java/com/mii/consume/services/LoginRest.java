/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.consume.services;

import com.mii.consume.entities.EmployeeLogin;
import com.mii.consume.entities.LoginData;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Insane
 */
@Service
public class LoginRest {
    
    @Value("${data.api.url}")
    private String url;

    @Value("${data.api.key}")
    private String key;
//    private String url = "http://116.254.101.228:8080/usermanagement";
//    private String key = "Bootcamp eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJEYXZlIiwiaWF0IjoxNTY5ODA5MDA2fQ.st-qmOLQBEEFbuxRGJ0VjJtXVxb3mr1jUOgFmhXtvi1oVqaakInrzWBDCA4DemgBB1xsTmLgsllFqM5fpAWTHg";
    
    private static final RestTemplate restTemplate = new RestTemplate();
    
    private HttpHeaders getHeaders() {
        return new HttpHeaders() {
            {
                set("Authorization", key);
                setContentType(MediaType.APPLICATION_JSON);
            }
        };
    }
    
    public EmployeeLogin login(LoginData loginData){
        HttpEntity<LoginData> request = new HttpEntity<LoginData>(loginData, getHeaders());
        System.out.println(request.getBody().getEmail()+" - "+request.getBody().getEmail());
        
        ResponseEntity<EmployeeLogin> responseEntity = restTemplate.exchange(
                url+"/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<EmployeeLogin>() {
        });
        
        EmployeeLogin result = responseEntity.getBody();
        
        return result;
    }
}
