package com.josheytee.niheapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NiheAppApplication {
//@todo implement DefaultHandlerExceptionResolver error handling
    public static void main(String[] args) {
        SpringApplication.run(NiheAppApplication.class, args);
    }


}