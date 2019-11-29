package com.zhenjin.rmi.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.zhenjin.rmi.facade.CarFacade;
import com.zhenjin.rmi.facade.UserFacade;

/**
 * RMI客户端配置
 *
 * @author ZhenJin
 */
@Configuration
public class RmiClientConfig {

    @Bean
    public UserFacade userFacade() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1101/UserFacade");
        rmiProxyFactoryBean.setServiceInterface(UserFacade.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (UserFacade) rmiProxyFactoryBean.getObject();
    }
    
    @Bean
    public CarFacade carFacade() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1101/CarFacade");
        rmiProxyFactoryBean.setServiceInterface(CarFacade.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (CarFacade) rmiProxyFactoryBean.getObject();
    }

}
