package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface{
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addOrder(Order order) {
        String sql = "insert into order(order_UserId, order_Date, order_TotalPrice, order_Status," +
                "order_PaymentMethod, order_PaymentStatus, order_ShippingAddress, order_ShippingCost)" +
                "values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, order.getOrderUserId(), order.getOrderDate(), order.getOrderTotalPrice(),
                order.getOrderStatus(), order.getOrderPaymentMethod(), order.getOrderPaymentStatus(),
                order.getOrderShippingAddress(), order.getOrderShippingCost());
    }

    @Override
    public void updateOrder(Long id ,Order order) {
        String sql = "update order set order_UserId=?, order_Date=?, order_TotalPrice=?, order_Status=?," +
                "order_PaymentMethod=?, order_PaymentStatus=?, order_ShippingAddress=?, order_ShippingCost=? where " +
                "id=?";
        jdbcTemplate.update(sql, order.getOrderUserId(), order.getOrderDate(), order.getOrderTotalPrice(),
                order.getOrderStatus(), order.getOrderPaymentMethod(), order.getOrderPaymentStatus(),
                order.getOrderShippingAddress(), order.getOrderShippingCost(), id);
    }

    @Override
    public void deleteOrder(long id) {
        String sql = "delete from order where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Order getOrderById(long id) {
        String sql = "select * from order where id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Order(
                rs.getLong("id"),
                rs.getLong("order_UserId"),
                rs.getDate("order_Date").toLocalDate(),
                rs.getLong("order_TotalPrice"),
                rs.getString("order_Status"),
                rs.getString("order_PaymentMethod"),
                rs.getString("order_PaymentStatus"),
                rs.getString("order_ShippingAddress"),
                rs.getLong("order_ShippingCost")
        ), id);
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "select * from order";
        try{
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Order(
                    rs.getLong("id"),
                    rs.getLong("order_UserId"),
                    rs.getDate("order_Date").toLocalDate(),
                    rs.getLong("order_TotalPrice"),
                    rs.getString("order_Status"),
                    rs.getString("order_PaymentMethod"),
                    rs.getString("order_PaymentStatus"),
                    rs.getString("order_ShippingAddress"),
                    rs.getLong("order_ShippingCost")
            ));
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {
        String sql = "select * from order where order_UserId=?";
        try{
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Order(
                    rs.getLong("id"),
                    rs.getLong("order_UserId"),
                    rs.getDate("order_Date").toLocalDate(),
                    rs.getLong("order_TotalPrice"),
                    rs.getString("order_Status"),
                    rs.getString("order_PaymentMethod"),
                    rs.getString("order_PaymentStatus"),
                    rs.getString("order_ShippingAddress"),
                    rs.getLong("order_ShippingCost")
            ), id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
