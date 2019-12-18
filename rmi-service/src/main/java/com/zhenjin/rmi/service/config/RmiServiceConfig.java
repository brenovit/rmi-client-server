package com.zhenjin.rmi.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.zhenjin.rmi.facade.CarFacade;
import com.zhenjin.rmi.facade.UserFacade;

/**
 * RMI服务端配置
 *
 * @author ZhenJin
 */
@Configuration
public class RmiServiceConfig {

    @Bean
    public RmiServiceExporter userService(UserFacade facade) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("UserFacade");
        rmiServiceExporter.setService(facade);
        rmiServiceExporter.setServiceInterface(UserFacade.class);
        rmiServiceExporter.setRegistryPort(3700);
        return rmiServiceExporter;
    }
    
    @Bean
    public RmiServiceExporter carService(CarFacade facade) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("CarFacade");
        rmiServiceExporter.setService(facade);
        rmiServiceExporter.setServiceInterface(CarFacade.class);
        rmiServiceExporter.setRegistryPort(3700);
        return rmiServiceExporter;
    }

}
