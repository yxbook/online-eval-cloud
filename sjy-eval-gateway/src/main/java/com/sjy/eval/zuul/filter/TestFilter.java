package com.sjy.eval.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;


@Component
public class TestFilter extends ZuulFilter{

    @Value("${server.port}")
    private String port;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){

        System.out.println("我的端口是：" + port);
        System.out.println("我的端口是：" + port);
        System.out.println("我的端口是：" + port);
        return null;
    }
}
