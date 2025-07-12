package com.hoangtucode.SportNexus;

import com.hoangtucode.SportNexus.model.User.*;
import com.hoangtucode.SportNexus.service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportNexusApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers() {
        System.out.println("Testing getAllUsers method:");
        System.out.println(userService.findAll());
    }
}
