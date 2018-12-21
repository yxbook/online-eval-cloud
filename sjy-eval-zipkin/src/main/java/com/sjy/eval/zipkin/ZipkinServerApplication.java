package com.sjy.eval.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-20 18:08
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZipkinServerApplication.class, args);

    }
}
