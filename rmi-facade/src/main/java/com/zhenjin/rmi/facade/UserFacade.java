package com.zhenjin.rmi.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.zhenjin.rmi.entity.Car;
import com.zhenjin.rmi.entity.User;

/**
 * RMI服务接口
 *
 * @author ZhenJin
 */
public interface UserFacade extends Remote {

	/**
     * 通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     * @throws RemoteException 远程调用异常
     */
    User getByName(String userName) throws RemoteException;

    /**
     * 通过用户性别获取用户信息
     *
     * @param userSex 用户性别
     * @return 用户信息
     * @throws RemoteException 远程调用异常
     */
    List<User> getBySex(String userSex) throws RemoteException;

}
