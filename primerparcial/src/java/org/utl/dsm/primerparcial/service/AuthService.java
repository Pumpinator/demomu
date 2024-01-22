/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.primerparcial.service;

import java.sql.Connection;
import java.sql.SQLException;
import org.utl.dsm.primerparcial.model.User;
import org.utl.dsm.primerparcial.repository.UserRepository;
import org.utl.dsm.primerparcial.util.MySQLConnection;

/**
 *
 * @author alejandro
 */
public class AuthService {

    private final UserRepository userRepository;

    public AuthService() {
        this.userRepository = new UserRepository();
    }

    public User login(User user) throws SQLException {
        try (Connection connection = MySQLConnection.getConnection();) {
            userRepository.setConnection(connection);
            user.encodePassword();
            user.encodeToken();
            return userRepository.login(user);
        }
    }
}
