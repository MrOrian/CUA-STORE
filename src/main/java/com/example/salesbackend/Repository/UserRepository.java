package com.example.salesbackend.Repository;

import com.example.salesbackend.DTO.UserDTO;
import com.example.salesbackend.Model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryInterface{
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user(user_Name, user_Pass, user_FullName, user_Role, user_Date, user_Address, user_Email, user_Phone, user_Gender, user_Status ,active_token) values (?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, user.getuserName(), user.getuserPass(),
                user.getuserFullName(), user.getuserRole(), user.getuserDate(),
                user.getuserAddress(), user.getuserEmail(), user.getuserPhone(),
                user.getuserGender(), user.getuserStatus(), user.getUserActive());
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set user_Name=?, user_Pass=?, user_FullName=?, user_Role=?, user_Date=?, user_Address=?, user_Email=?, user_Phone=?, user_Gender=?, user_Status=?, reset_Token=?, active_token=? where id=?";
        jdbcTemplate.update(sql, user.getuserName(), user.getuserPass(),
                user.getuserFullName(), user.getuserRole(), user.getuserDate(),
                user.getuserAddress(), user.getuserEmail(), user.getuserPhone(),
                user.getuserGender(), user.getuserStatus(), user.getUserReset(), user.getUserActive(), user.getId());
    }

    @Override
    public void deleteUser(long id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<User> getUserById(long id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.query(sql,
                ps -> ps.setLong(1, id),
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("user_Name"),
                        rs.getString("user_Pass"),
                        rs.getString("user_FullName"),
                        rs.getString("user_Role"),
                        rs.getDate("user_Date").toLocalDate(),
                        rs.getString("user_Address"),
                        rs.getString("user_Email"),
                        rs.getString("user_Phone"),
                        rs.getString("user_Gender"),
                        rs.getString("user_Status"),
                        rs.getString("reset_token"),
                        rs.getString("active_token")
                )
        ).stream().findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("user_Name"),
                rs.getString("user_Pass"),
                rs.getString("user_FullName"),
                rs.getString("user_Role"),
                rs.getDate("user_Date").toLocalDate(),
                rs.getString("user_Address"),
                rs.getString("user_Email"),
                rs.getString("user_Phone"),
                rs.getString("user_Gender"),
                rs.getString("user_Status"),
                rs.getString("reset_token"),
                rs.getString("active_token")
        ));
    }

    @Override
    public UserDTO checkUserValid(UserDTO user) {
        String sql = "select * from user where user_Name=? or user_Email=?";
        try{
            return jdbcTemplate.queryForObject(sql, (rs, rowNum)-> new UserDTO(
                            rs.getString("user_Name"),
                            rs.getString("user_Pass"),
                            rs.getString("user_Role"),
                            rs.getString("user_Email"),
                            rs.getString("user_Status"),
                            rs.getString("reset_token")
                    ), user.getUserName(),user.getUserEmail()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "select * from user where user_Email= ?";

        try {
            List<User> users = jdbcTemplate.query(sql,
                    (rs, rowNum) -> new User(
                            rs.getLong("id"),
                            rs.getString("user_Name"),
                            rs.getString("user_Pass"),
                            rs.getString("user_FullName"),
                            rs.getString("user_Role"),
                            rs.getDate("user_Date").toLocalDate(),
                            rs.getString("user_Address"),
                            rs.getString("user_Email"),
                            rs.getString("user_Phone"),
                            rs.getString("user_Gender"),
                            rs.getString("user_Status"),
                            rs.getString("reset_token"),
                            rs.getString("active_token")
                    ), email);

            return users.isEmpty() ? null : users.get(0);

        } catch (DataAccessException e) {
            System.out.println("Error accessing data: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean validToken(String token) {
        String sql = "select * from user where reset_token=? or active_token=?";
        User user = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("user_Name"),
                rs.getString("user_Pass"),
                rs.getString("user_FullName"),
                rs.getString("user_Role"),
                rs.getDate("user_Date").toLocalDate(),
                rs.getString("user_Address"),
                rs.getString("user_Email"),
                rs.getString("user_Phone"),
                rs.getString("user_Gender"),
                rs.getString("user_Status"),
                rs.getString("reset_token"),
                rs.getString("active_token")
        ), token, token);
        if (user != null && !user.getuserName().isEmpty()) return true;
        return false;
    }

    @Override
    public User resetPassword(String token) {
        String sql = "select * from user where reset_token=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("user_Name"),
                rs.getString("user_Pass"),
                rs.getString("user_FullName"),
                rs.getString("user_Role"),
                rs.getDate("user_Date").toLocalDate(),
                rs.getString("user_Address"),
                rs.getString("user_Email"),
                rs.getString("user_Phone"),
                rs.getString("user_Gender"),
                rs.getString("user_Status"),
                rs.getString("reset_token"),
                rs.getString("active_token")
        ), token);
    }

    @Override
    public User activeUser(String token) {
        String sql = "select * from user where active_token=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("user_Name"),
                rs.getString("user_Pass"),
                rs.getString("user_FullName"),
                rs.getString("user_Role"),
                rs.getDate("user_Date").toLocalDate(),
                rs.getString("user_Address"),
                rs.getString("user_Email"),
                rs.getString("user_Phone"),
                rs.getString("user_Gender"),
                rs.getString("user_Status"),
                rs.getString("reset_token"),
                rs.getString("active_token")
        ), token);
    }


}
