package com.zhenjin.rmi.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.zhenjin.rmi.facade.CarFacade;
import com.zhenjin.rmi.facade.UserFacade;

import lombok.extern.log4j.Log4j2;

/**
 * RMI客户端配置
 *
 * @author ZhenJin
 */
@Log4j2
@Configuration
public class RmiClientConfig {
	
	@Value("${host}")
	public String host;
	
    @Bean
    public UserFacade userFacade() {
    	log.info("Starting UserFacade");
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://"+host+"/UserFacade");
        rmiProxyFactoryBean.setServiceInterface(UserFacade.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (UserFacade) rmiProxyFactoryBean.getObject();
    }
    
    @Bean
    public CarFacade carFacade() {
    	log.info("Starting CarFacade");
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://"+host+"/CarFacade");
        rmiProxyFactoryBean.setServiceInterface(CarFacade.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (CarFacade) rmiProxyFactoryBean.getObject();
    }

}
