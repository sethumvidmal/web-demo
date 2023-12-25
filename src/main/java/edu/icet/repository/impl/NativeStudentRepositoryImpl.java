package edu.icet.repository.impl;

import edu.icet.repository.NativeStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NativeStudentRepositoryImpl implements NativeStudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer retrieveStudentCount() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM students;",
                Integer.class
        );
    }

    @Override
    public List<String> retrieveFirstNameById(String id) {
        return jdbcTemplate.queryForList(
                "SELECT first_name FROM student",
                String.class
        );
    }

}
