package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryRepository implements InventoryRepositoryInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addInventory(Inventory inventory) {
        String sql = "insert into inventory (inventory_ClothesId, inventory_Size, inventory_Color, inventory_Stock)" +
                "values (?,?,?,?)";
        jdbcTemplate.update(sql, inventory.getInventoryClothesId(), inventory.getInventorySize(),
                inventory.getInventoryColor(), inventory.getInventoryStock());
    }

    @Override
    public void updateInventory(Long id, Inventory inventory) {
        String sql = "update inventory set inventory_ClothesId=?, inventory_Size=?, inventory_Color=?, inventory_Stock=? where id=?";
        jdbcTemplate.update(sql, inventory.getInventoryClothesId(), inventory.getInventorySize(),
                inventory.getInventoryColor(), inventory.getInventoryStock(), id);
    }

    @Override
    public void deleteInventory(long id) {
        String sql = "delete from inventory where id=?";
        jdbcTemplate.update(sql, id);
    }

    public Inventory getInventoryById(long id) {
        String sql = "select * from inventory where id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Inventory(
                rs.getLong("id"),
                rs.getLong("inventory_ClothesId"),
                rs.getInt("inventory_Size"),
                rs.getString("inventory_Color"),
                rs.getLong("inventory_Stock")
        ), id);
    }

    @Override
    public Inventory getInventoryByClothesId(long id) {
        String sql = "select * from inventory where inventory_ClothesId=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Inventory(
                rs.getLong("id"),
                rs.getLong("inventory_ClothesId"),
                rs.getInt("inventory_Size"),
                rs.getString("inventory_Color"),
                rs.getLong("inventory_Stock")
        ), id);
    }

    @Override
    public List<Inventory> getAllInventory() {
        String sql = "select * from inventory";
        try{
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Inventory(
                    rs.getLong("id"),
                    rs.getLong("inventory_ClothesId"),
                    rs.getInt("inventory_Size"),
                    rs.getString("inventory_Color"),
                    rs.getLong("inventory_Stock")
            ));
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
