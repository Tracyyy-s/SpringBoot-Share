package com.tracy.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Tracy
 * @date 2020/10/11 16:15
 */
@Component
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //获取某图书的价格
    public int getPrice(String book_id) {
        String sql = "select price from book where book_id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,book_id);
    }

    /**
     * 修改余额
     * @param username
     * @param price
     */
    public void updateBalance(String username, int price) {
        String sql = "updateAAA account set balance=balance-? where username=?";
        jdbcTemplate.update(sql, price, username);
    }

    /**
     * 减某本书库存
     */
    public void updateStock(String book_id) {
        String sql = "update book_stock set stock=stock-1 where book_id=?";
        jdbcTemplate.update(sql,book_id);
    }
}
