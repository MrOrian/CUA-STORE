package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.DetailOrder;
import com.example.salesbackend.Model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailOrderRepository implements DetailOrderRepositoryInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addDetailOrder(DetailOrder detailOrder) {
        String sql = "insert into detailOrder(detailrOder_OrderId, detailrOder_ClothesId, detailrOder_Quantity" +
                "detailrOder_Price, detailrOder_DiscountId, detailrOder_DiscountValue) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, detailOrder.getDetailOrderId(), detailOrder.getDetailClothesId(), detailOrder.getDetailOrderQuantity(),
                detailOrder.getDetailOrderPrice(), detailOrder.getDetailDiscountId(), detailOrder.getDetailDiscountValue());
    }

    @Override
    public void updateDetailOrder(Long id, DetailOrder detailOrder) {
        String sql = "update detailOrder set detailrOder_OrderId=?, detailrOder_ClothesId=?, detailrOder_Quantity=?" +
                "detailrOder_Price=?, detailrOder_DiscountId=?, detailrOder_DiscountValue=? where id=?";
        jdbcTemplate.update(sql, detailOrder.getDetailOrderId(), detailOrder.getDetailClothesId(), detailOrder.getDetailOrderQuantity(),
                detailOrder.getDetailOrderPrice(), detailOrder.getDetailDiscountId(), detailOrder.getDetailDiscountValue(), id);
    }

    @Override
    public void deleteDetailOrder(long id) {
        String sql = "delete from detailOrder where id =?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public DetailOrder getDetailOrderById(long id) {
        String sql = "select * from detailOrder where id=?";
        try{
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new DetailOrder(
                    rs.getLong("detailOrder_OrderId"),
                    rs.getLong("detailOrder_ClothesId"),
                    rs.getLong("detailOrder_Quantity"),
                    rs.getLong("detailOrder_Price"),
                    rs.getLong("detailOrder_DiscountId"),
                    rs.getLong("detailOrder_DiscountValue")
            ),id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public DetailOrder getDetailOrderByOrderId(long id) {
        String sql = "select * from detailOrder where detailOrder_OrderId=?";
        try{
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new DetailOrder(
                    rs.getLong("detailOrder_OrderId"),
                    rs.getLong("detailOrder_ClothesId"),
                    rs.getLong("detailOrder_Quantity"),
                    rs.getLong("detailOrder_Price"),
                    rs.getLong("detailOrder_DiscountId"),
                    rs.getLong("detailOrder_DiscountValue")
            ),id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<DetailOrder> getAllDetailOrders() {
        String sql = "select * from detailOrder";
        try{
            return jdbcTemplate.query(sql, (rs, rowNum) -> new DetailOrder(
                    rs.getLong("detailOrder_OrderId"),
                    rs.getLong("detailOrder_ClothesId"),
                    rs.getLong("detailOrder_Quantity"),
                    rs.getLong("detailOrder_Price"),
                    rs.getLong("detailOrder_DiscountId"),
                    rs.getLong("detailOrder_DiscountValue")
            ));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
