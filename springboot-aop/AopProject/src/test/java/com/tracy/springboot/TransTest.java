package com.tracy.springboot;

import com.tracy.springboot.service.BookService;
import com.tracy.springboot.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Tracy
 * @date 2020/10/11 16:27
 */
@SpringBootTest
public class TransTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testTran() {

        bookService.purchase("Tom", "001");
    }

    @Test
    public void testException() {

        int i = 10 / 0;
    }

    @Test
    public void testTran2() {

        bookService.getPrice("001");

    }

    @Autowired
    private TransactionService transService;

    @Test
    public void testTran3() {

        transService.testPropagation();
    }

    @Test
    public void testTran4() {
        bookService.testPro();

        System.out.println(bookService.getClass());
        System.out.println(BookService.class);
    }

}
