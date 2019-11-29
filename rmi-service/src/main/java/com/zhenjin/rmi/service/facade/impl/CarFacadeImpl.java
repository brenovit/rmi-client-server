package com.zhenjin.rmi.service.facade.impl;


import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zhenjin.rmi.entity.Car;
import com.zhenjin.rmi.facade.CarFacade;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CarFacadeImpl implements CarFacade {

    private List<Car> carList;

    {
        //模拟一个数据库
        Car uno = new Car("uno", "black", 2000);
        Car gol = new Car("gol", "black", 2010);
        Car argo = new Car("argo", "green", 2019);
        carList = Arrays.asList(uno, gol, argo);
    }


    @Override
    public Car getByModel(String model) {
        //根据用户名从数据库取出对应的用户信息
        Supplier<NullPointerException> exception = () -> new NullPointerException("Não foi encontrado o modelo " + model);
        return carList.stream().filter(t -> t.getModel().equals(model)).findFirst().orElseThrow(exception);
    }


    @Override
    public List<Car> getByColor(String color) {
        //根据用户名从数据库取出对应的用户信息
        return carList.stream().filter(t -> t.getColor().equals(color)).collect(Collectors.toList());
    }


	@Override
	public void showIp(String ip) throws RemoteException {
		log.info("Client connected from {}", ip);		
	}

}
