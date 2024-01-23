/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.primerparcial.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.primerparcial.model.User;

/**
 *
 * @author alejandro
 */
public class UserRepository {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<User> list() throws SQLException {
        String query = "SELECT u.id, u.username FROM users u";
        System.out.println(query);
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    users.add(new User(resultSet.getInt("id"), resultSet.getString("username")));
                }
            }
        }
        return users;
    }

    public User save(User user) throws SQLException {
        String query = (!esInsert(user))
                ? "UPDATE users u SET u.username = ?, u.password = ? WHERE u.id = ?"
                : "INSERT INTO users(username, password) VALUES (?, ?)";
        System.out.println(query);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            if (!esInsert(user)) {
                preparedStatement.setInt(3, user.getId());
            }
            preparedStatement.executeUpdate();
            if (esInsert(user)) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        user.setId(resultSet.getInt(1));
                    }
                }
            }
            return user;
        }
    }

    public User login(User user) throws SQLException {
        String query = "SELECT u.id FROM users u WHERE u.username = ? AND u.password = ?";
        System.out.println(query);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                } else {
                    user = null;
                }
            }
        }
        if (user != null) {
            query = "UPDATE users u SET u.token = ? WHERE u.id = ?";
            System.out.println(query);
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getToken());
                preparedStatement.setInt(2, user.getId());
                preparedStatement.executeUpdate();
            }
        }
        return user;
    }

    public User logout(User user) throws SQLException {
        String query = "UPDATE users u SET u.token = '' WHERE u.id = ?";
        System.out.println(query);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
        }
        return user;
    }

    private boolean esInsert(User user) {
        if (user.getId() == null) {
            return true;
        }
        return false;
    }
}
