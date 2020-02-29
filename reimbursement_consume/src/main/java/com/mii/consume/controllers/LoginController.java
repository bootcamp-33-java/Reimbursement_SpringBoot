/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.consume.controllers;


import com.mii.consume.entities.EmployeeLogin;
import com.mii.consume.entities.LoginData;
import com.mii.consume.services.LoginRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Insane
 */
@Controller
public class LoginController {

    @Autowired
    private LoginRest rest;

    private static Collection<? extends GrantedAuthority> getAuthorities(EmployeeLogin employeeLogin) {
        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : employeeLogin.getEmployee().getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @GetMapping("/login")
    public String handlingLog() {
        String result;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equalsIgnoreCase("anonymousUser")) {
            result = "redirect:/";
        } else {
            result = "login";
        }
        return result;
    }

    @PostMapping("/verification")
    public String verification(@Valid LoginData loginData) {
        String result;
        EmployeeLogin employeeLogin = rest.login(loginData);
        System.out.println(employeeLogin.getStatus());
        if (employeeLogin.getStatus().equalsIgnoreCase("Login Success")) {
            //ambil semua role
            User user = new User(employeeLogin.getEmployee().getId(), "", getAuthorities(employeeLogin));
            //diberi akses
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, "", user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            result = "redirect:/";
        } else {
            result = "redirect:/login";
        }
        return result;
    }


}
