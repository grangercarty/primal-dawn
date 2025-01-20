package com.github.grangercarty.primaldawn.mapper;

import com.github.grangercarty.primaldawn.model.Dinosaur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DinosaurRowMapper implements RowMapper<Dinosaur> {

    @Override
    public Dinosaur mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.setId(resultSet.getInt("id"));
        dinosaur.setHeight(resultSet.getInt("height"));
        dinosaur.setWeight(resultSet.getInt("weight"));
        dinosaur.setFood(resultSet.getString("food"));
        dinosaur.setName(resultSet.getString("name"));
        return dinosaur;
    }
}
