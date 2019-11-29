package com.zhenjin.rmi.facade;

import com.zhenjin.rmi.entity.Car;
import com.zhenjin.rmi.entity.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * RMI服务接口
 *
 * @author ZhenJin
 */
public interface CarFacade extends Remote {
    
    
    /**
     * 通过用户名获取用户信息
    *
    * @param userName 用户名
    * @return 用户信息
    * @throws RemoteException 远程调用异常
    */
   Car getByModel(String model) throws RemoteException;

   /**
    * 通过用户性别获取用户信息
    *
    * @param userSex 用户性别
    * @return 用户信息
    * @throws RemoteException 远程调用异常
    */
   List<Car> getByColor(String color) throws RemoteException;

}
