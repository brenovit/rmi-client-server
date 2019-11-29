package com.zhenjin.rmi.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenjin.rmi.entity.Car;
import com.zhenjin.rmi.entity.User;
import com.zhenjin.rmi.facade.CarFacade;
import com.zhenjin.rmi.facade.UserFacade;

@RestController
@RequestMapping("/rmi")
public class RmiController {
		
	@Autowired
    private UserFacade userFacade;
    
    @Autowired
    private CarFacade carFacade;
    
	@GetMapping(value = "/")
	public String test() {
		userByNameTest();
		userBySexTest();
		carByModelTest();
		carByColorTest();
		return "OK";
	}
	
    public void userByNameTest() {
        try {
            User zhenJin = userFacade.getByName("ZhenJin");
            System.out.println("=======> " + zhenJin + " <=======");
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
            System.out.println("=======> " + uno + " <=======");
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
