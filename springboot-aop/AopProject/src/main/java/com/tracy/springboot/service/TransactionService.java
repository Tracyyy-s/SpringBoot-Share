package com.tracy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tracy
 * @date 2020/10/11 23:33
 */
@Service
public class TransactionService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void testPropagation() {

        //修改库存  REQUIRES
        bookService.changeStock("001");

        //修改用户余额  REQUIRES_NEW
        bookService.changeBalance("Tom", 100);

    }
}
