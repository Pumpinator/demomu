/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.primerparcial.model;

import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author alejandro
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String token;

    public User() {
    }
    
    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String username) {
        this.username = username;
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "{"
                + "\n\t\"id\": " + id
                + ",\n\t\"username\": " + username
                + ", \n\t\"password\": " + password
                + ", \n\t\"token\": " + token
                + "\n}";
    }

    public void encodePassword() {
        this.password = DigestUtils.md5Hex(password);
    }
    
    public void encodeToken() {
        String firstPart = this.username;
        String secondPart = "DSM501";
        Date date = new Date();
        String thirdPart = date.toString();
        String token = firstPart + "-" + secondPart + "-" + thirdPart;
        this.token = DigestUtils.sha512Hex(token);
    }
}
