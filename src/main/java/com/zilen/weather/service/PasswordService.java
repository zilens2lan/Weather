package com.zilen.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Value("${spring.datasource.password}")
    private String password;

    public String getPassword() {
        return password;
    }
}
