package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscountRepository implements DiscountRepositoryInterface{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addDiscount(Discount discount) {
        String sql = "insert into discount(discount_Code, discount_Value, discount_ClothesId," +
                "discount_MinOrder, discount_DateStart, discount_DateEnd, discount_Status) " +
                "values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, discount.getDiscountCode(), discount.getDiscountValue(), discount.getDiscountClothesId(),
            discount.getDiscountMinOrder(), discount.getDiscountDateStart(), discount.getDiscountDateEnd(),
                discount.getDiscountStatus());
    }

    @Override
    public void updateDiscount(Long id, Discount discount) {
        String sql = "update discount set discount_Code=?, discount_Value=?, discount_ClothesId=?," +
                "discount_MinOrder=?, discount_DateStart=?, discount_DateEnd=?, discount_Status=? where id=?";
        jdbcTemplate.update(sql, discount.getDiscountCode(), discount.getDiscountValue(), discount.getDiscountClothesId(),
                discount.getDiscountMinOrder(), discount.getDiscountDateStart(), discount.getDiscountDateEnd(),
                discount.getDiscountStatus(), id);
    }

    @Override
    public void deleteDiscount(long id) {
        String sql = "delete from discount where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Discount getDiscountById(long id) {
        String sql = "select * from discount where id=?";
        try{
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Discount(
                    rs.getString("discount_Code"),
                    rs.getLong("discount_Value"),
                    rs.getLong("discount_ClothesId"),
                    rs.getLong("discount_MinOrder"),
                    rs.getDate("discount_DateStart"),
                    rs.getDate("discount_DateEnd"),
                    rs.getString("discount_Status")
            ),id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Discount getDiscountByStatus(String status) {
        String sql = "select * from discount where discount_Status=?";
        try{
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Discount(
                    rs.getString("discount_Code"),
                    rs.getLong("discount_Value"),
                    rs.getLong("discount_ClothesId"),
                    rs.getLong("discount_MinOrder"),
                    rs.getDate("discount_DateStart"),
                    rs.getDate("discount_DateEnd"),
                    rs.getString("discount_Status")
            ),status);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Discount> getAllDiscounts() {
        String sql = "select * from discount ";
        try{
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Discount(
                    rs.getString("discount_Code"),
                    rs.getLong("discount_Value"),
                    rs.getLong("discount_ClothesId"),
                    rs.getLong("discount_MinOrder"),
                    rs.getDate("discount_DateStart"),
                    rs.getDate("discount_DateEnd"),
                    rs.getString("discount_Status")
            ));
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
