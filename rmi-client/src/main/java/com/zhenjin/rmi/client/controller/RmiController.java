package com.zhenjin.rmi.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenjin.rmi.entity.Car;
import com.zhenjin.rmi.entity.User;
import com.zhenjin.rmi.facade.CarFacade;
import com.zhenjin.rmi.facade.UserFacade;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/rmi")
public class RmiController {
		
	@Autowired
    private UserFacade userFacade;
    
    @Autowired
    private CarFacade carFacade;
    
	@GetMapping(value = "/")
	public String test(HttpServletRequest request) {
		show(request.getRemoteAddr());
		userByNameTest();
		userBySexTest();
		carByModelTest();
		carByColorTest();
		return "OK";
	}
	
	public void show(String ip) {
		log.info("Received message from {}", ip);
		try {
			carFacade.showIp(ip);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
    public void userByNameTest() {
        try {
            User zhenJin = userFacade.getByName("ZhenJin");
            log.info("=======> " + zhenJin + " <=======");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void userBySexTest() {
        try {
            List<User> userList = userFacade.getBySex("男");
            userList.forEach(System.out::println);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    public void carByModelTest() {
        try {
            Car uno = carFacade.getByModel("uno");
            log.info("=======> " + uno + " <=======");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    public void carByColorTest() {
        try {
            List<Car> carList = carFacade.getByColor("black");
            carList.forEach(System.out::println);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
