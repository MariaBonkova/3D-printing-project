package com.example.demo.init;

import com.example.demo.service.RoleService;
import com.example.demo.service.impl.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final RoleService roleService;
   private final InitService initService;


    public DataBaseInit(RoleService roleService, InitService initService) {
        this.roleService = roleService;
        this.initService = initService;
    }


    @Override
    public void run(String... args) throws Exception {
        initService.init();
    }
}
