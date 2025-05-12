package org.bigxp.bigxp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/db")
    public String home(){
        String query = "SELECT DATABASE();";
        return jdbcTemplate.queryForObject(query, String.class);
    }
}
