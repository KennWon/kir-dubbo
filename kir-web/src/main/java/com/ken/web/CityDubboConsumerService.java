package com.ken.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ken.model.City;
import com.ken.service.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public void printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
