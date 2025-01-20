package com.shaik.acknowledge.JDBCwithspring.repository;

import com.shaik.acknowledge.JDBCwithspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/** Literally the above annotation handle and throw granular exception**/
public class UserRespository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveUser(String userName, Integer age) {
        String sql = "INSERT INTO user(user_name, user_age) VALUES(?, ?)";
        jdbcTemplate.update(sql, userName, age);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) ->{
            User user = new User();
            user.setUserId(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setAge(rs.getInt(3));
            return user;
        });
    }
}
