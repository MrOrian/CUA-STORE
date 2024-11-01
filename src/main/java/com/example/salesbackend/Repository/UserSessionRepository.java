package com.example.salesbackend.Repository;

import com.example.salesbackend.DTO.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

@Repository
public class UserSessionRepository implements UserSessionRepositoryInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserSession getUserSession(String session) {
        String sql = "select * from user_sessions where session_id=?";
        System.out.println(session);
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new UserSession(
                rs.getString("session_id"),
                rs.getString("username"),
                rs.getString("role")
        ), session);
    }

    @Override
    public void generateSession(UserSession userSession) {
        userSession.setCreateAt(new Timestamp(System.currentTimeMillis()));
        userSession.setExpireAt(new Timestamp(System.currentTimeMillis()+30*60*1000));
        String sql = "insert into user_sessions (session_id, username, role, created_at, expires_at) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, userSession.getSessionId(), userSession.getUserName(), userSession.getRole(),
                    userSession.getCreateAt(), userSession.getExpireAt());
    }

    @Override
    public void deleteSession(String session) {
        String sql = "delete from user_sessions where session_id = ?";
        jdbcTemplate.update(sql, session);
    }

    @Override
    public void deleteExpiredSession() {
        String sql = "delete from user_sessions where expires_at < NOW()";
        jdbcTemplate.update(sql);
    }
}
