package com.example.salesbackend.Repository;

import com.example.salesbackend.DTO.ClothesDTO;
import com.example.salesbackend.Model.Clothes;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClothesRepository implements ClothesRepositoryInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addClothes(Clothes clothes) {
        String sql = "insert into clothes (clothes_Name, clothes_Type, clothes_Price, clothes_Brand, clothes_Image, clothes_Description, clothes_Status)" +
                "values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, clothes.getClothesName(), clothes.getClothesType(), clothes.getClothesPrice(),
            clothes.getClothesBrand(), clothes.getClothesImage(), clothes.getClothesDescription(), clothes.getClothesStatus()
        ) ;
    }

    @Override
    public void updateClothes(Clothes clothes, Long id) {
        String sql = "update clothes set clothes_Name=?, clothes_Type=?, clothes_Price=?, clothes_Brand=?, clothes_Image=?, clothes_Description=?, clothes_Status=? where id=?";
        jdbcTemplate.update(sql, clothes.getClothesName(), clothes.getClothesType(), clothes.getClothesPrice(),
                clothes.getClothesBrand(), clothes.getClothesImage(), clothes.getClothesDescription(), clothes.getClothesStatus(), id);
    }

    @Override
    public void deleteClothes(long id) {
        String sql = "update clothes set clothes_Status='delete' where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Clothes getClothesById(Long id) {
        String sql = "select * from clothes where id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Clothes(
                rs.getLong("id"),
                rs.getString("clothes_Name"),
                rs.getString("clothes_Type"),
                rs.getLong("clothes_Price"),
                rs.getString("clothes_Brand"),
                rs.getString("clothes_Image"),
                rs.getString("clothes_Description"),
                rs.getString("clothes_Status")
        ),id);
    }

    @Override
    public Clothes getClothesByName(String name) {
        String sql = "select * from clothes where clothes_Name=?";
        List<Clothes> clothesList = jdbcTemplate.query(sql, (rs, rowNum) -> new Clothes(
                rs.getLong("id"),
                rs.getString("clothes_Name"),
                rs.getString("clothes_Type"),
                rs.getLong("clothes_Price"),
                rs.getString("clothes_Brand"),
                rs.getString("clothes_Image"),
                rs.getString("clothes_Description"),
                rs.getString("clothes_Status")
        ), name);
        return clothesList.isEmpty() ? null : clothesList.get(0);
    }

    @Override
    public List<Clothes> getClothesByType(String type) {
        String sql = "select * from clothes where clothes_Type=?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Clothes(
                rs.getLong("id"),
                rs.getString("clothes_Name"),
                rs.getString("clothes_Type"),
                rs.getLong("clothes_Price"),
                rs.getString("clothes_Brand"),
                rs.getString("clothes_Image"),
                rs.getString("clothes_Description"),
                rs.getString("clothes_Status")
        ),type);
    }

    @Override
    public List<Clothes> getAllClothes() {
        String sql = "select * from clothes";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Clothes(
                rs.getLong("id"),
                rs.getString("clothes_Name"),
                rs.getString("clothes_Type"),
                rs.getLong("clothes_Price"),
                rs.getString("clothes_Brand"),
                rs.getString("clothes_Image"),
                rs.getString("clothes_Description"),
                rs.getString("clothes_Status")
        ));
    }
}
