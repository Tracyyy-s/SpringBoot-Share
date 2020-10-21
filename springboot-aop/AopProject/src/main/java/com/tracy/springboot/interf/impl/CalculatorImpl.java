package com.tracy.springboot.interf.impl;

import com.tracy.springboot.interf.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author Tracy
 * @date 2020/10/2 14:42
 */
@Service
public class CalculatorImpl implements Calculator {

    public int add(int i, int j) {
        System.out.println("add方法执行...");
        return i + j;
    }

    public Integer div(int i, int j) {
        System.out.println("div方法执行...");
        return i / j;
    }
}
