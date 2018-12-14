package com.sjy.eval.eureka.listener;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: online-eval-cloud
 * @description: 服务注册监听
 *
 * EurekaInstanceCanceledEvent 服务下线事件
 * EurekaInstanceRegisteredEvent 服务注册事件
 * EurekaInstanceRenewedEvent 服务续约事件
 * EurekaRegistryAvailableEvent Eureka注册中心启动事件
 * EurekaServerStartedEvent Eureka Server启动事件
 *
 * @author: Created by youxun
 * @create: 2018-12-14 17:26
 **/
@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.err.println(instanceInfo.getAppName() + "进行注册");
    }
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.err.println("Eureka Server Starting........");
    }
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        System.err.println("注册中心启动完成");
    }
}