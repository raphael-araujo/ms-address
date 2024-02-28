package com.raphael.msaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsaddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaddressApplication.class, args);
    }

}
