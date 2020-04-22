package com.linhua.study.service;

import com.linhua.study.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-21 4:15 下午
 */

@Service
public class CarService {

    @Autowired
    private Car car;
}
