package com.zhenjin.rmi.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RMISecurityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RMI服务端启动类
 *
 * @author ZhenJin
 */
@SpringBootApplication
public class RmiServiceApplication {

    public static void main(String[] args) {
    	System.setSecurityManager(new RMISecurityManager());
    	InetAddress inetAddress = null;

    	try {
			inetAddress = InetAddress.getLocalHost();
			//System.setProperty("java.security.policy", "security.policy");
			//System.setProperty("java.rmi.server.hostname", inetAddress.getHostAddress());
			System.out.println("IP Address:- " + inetAddress.getHostAddress());
			System.out.println("Host Name:- " + inetAddress.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        
        SpringApplication.run(RmiServiceApplication.class, args);

        System.out.println("================================");
        System.out.println("====== Server RMI Started ======");
        System.out.println("================================");
    }

}
