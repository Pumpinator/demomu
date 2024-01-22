/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.dsm.primerparcial.test;

import java.sql.SQLException;
import org.utl.dsm.primerparcial.model.User;
import org.utl.dsm.primerparcial.service.AuthService;
import org.utl.dsm.primerparcial.service.UserService;

/**
 *
 * @author alejandro
 */
public class UserTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
    }
    
    public static User testEncode() {
        User user = new User("alejandrodcardona5@gmail.com", "alejandro2023");
        user.encodePassword();
        return user;
    }
    
    public static User testLogin() throws SQLException {
        AuthService authService = new AuthService();
        User user = new User("alejandrodcardona5@gmail.com", "alejandro2023"); 
        return authService.login(user);
    }
    
    public static User testCreate() throws SQLException {
        UserService userService = new UserService();
        User user = new User("alejandrodcardona5@gmail.com", "alejandro2023"); 
        return userService.save(user);
    }
}
