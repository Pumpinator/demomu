/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.primerparcial.service;

import org.utl.dsm.primerparcial.repository.UserRepository;

import java.sql.*;
import java.util.List;
import org.utl.dsm.primerparcial.model.User;
import org.utl.dsm.primerparcial.util.MySQLConnection;

/**
 *
 * @author alejandro
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }
    
    public List<User> list() throws SQLException {
        try (Connection connection = MySQLConnection.getConnection()) {
            userRepository.setConnection(connection);
            return userRepository.list();
        }
    }

    public User save(User user) throws SQLException {
        try (Connection connection = MySQLConnection.getConnection()) {
            userRepository.setConnection(connection);
            user.encodePassword();
            return userRepository.save(user);
        }
    }
}
