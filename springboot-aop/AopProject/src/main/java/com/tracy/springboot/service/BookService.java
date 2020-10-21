package com.tracy.springboot.service;

import com.tracy.springboot.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Tracy
 * @date 2020/10/11 16:17
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 用户购买图书
     * @param username
     * @param bookId
     */
    @Transactional
    public void purchase(String username, String bookId) {

        //获得图书价格
        int price = bookDao.getPrice(bookId);

        //修改图书库存
        bookDao.updateStock(bookId);

        //修改用户余额
        bookDao.updateBalance(username, price);

    }

    /**
     * 获取图书得价格，仅查询，可readOnly
     * 用于演示Isolation
     * @param bookId
     */
    @Transactional
    public void getPrice(String bookId) {

        System.out.println(bookDao.getPrice(bookId));

        System.out.println(bookDao.getPrice(bookId));

        System.out.println(bookDao.getPrice(bookId));
    }

    /**
     * 修改图书的库存量
     * @param bookId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeStock(String bookId) {

        bookDao.updateStock(bookId);
    }

    /**
     * 修改用户的余额
     * @param username
     * @param price
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeBalance(String username, Integer price) {

        bookDao.updateBalance(username, price);

    }

    /**
     * 测试本类方法的隔离级别
     */
    @Transactional
    public void testPro() {

        //修改用户余额  REQUIRES_NEW
        changeBalance("Tom", 100);

        //修改库存  REQUIRES
        changeStock("001");

//        int i = 10/0;
    }
}
