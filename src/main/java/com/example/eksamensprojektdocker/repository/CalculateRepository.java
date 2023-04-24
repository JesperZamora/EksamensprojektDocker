package com.example.eksamensprojektdocker.repository;

import com.example.eksamensprojektdocker.repository.util.DB_Connector;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculateRepository {
    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        String SQL = "SELECT * FROM users;";

        try {
            Statement stmt = DB_Connector.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                users.add(rs.getString("user_name"));
            }
            stmt.close();

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}