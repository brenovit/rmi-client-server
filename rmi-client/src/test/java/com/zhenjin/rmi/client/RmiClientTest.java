package com.zhenjin.rmi.client;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenjin.rmi.entity.Car;
import com.zhenjin.rmi.entity.User;
import com.zhenjin.rmi.facade.CarFacade;
import com.zhenjin.rmi.facade.UserFacade;

/**
 * 测试类
 *
 * @author ZhenJin
 */
@RunWith(SpringRunner.class)
// 在SpringBootTest注解中不能加参数
// webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
// 否则会报 UnsatisfiedDependencyException: Error creating bean with name
@SpringBootTest(classes = RmiClientApplication.class)
public class RmiClientTest {

    @Autowired
    private UserFacade userFacade;
    
    @Autowired
    private CarFacade carFacade;

    @Test
    public void userByNameTest() {
        try {
            User zhenJin = userFacade.getByName("ZhenJin");
            System.out.println("=======> " + zhenJin + " <=======");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userBySexTest() {
        try {
            List<User> userList = userFacade.getBySex("男");
            userList.forEach(System.out::println);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void carByModelTest() {
        try {
            Car uno = carFacade.getByModel("uno");
            System.out.println("=======> " + uno + " <=======");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void carByColorTest() {
        try {
            List<Car> carList = carFacade.getByColor("black");
            carList.forEach(System.out::println);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
