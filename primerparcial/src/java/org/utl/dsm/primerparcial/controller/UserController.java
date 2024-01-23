/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.primerparcial.controller;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.primerparcial.model.User;
import org.utl.dsm.primerparcial.service.AuthService;
import org.utl.dsm.primerparcial.service.UserService;

/**
 *
 * @author alejandro
 */
@Path("/user")
public class UserController {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            UserService userService = new UserService();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(userService.list())).build();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return null;
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(String json) {
        try {
            UserService userService = new UserService();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(userService.save(gson.fromJson(json, User.class)))).build();
        } catch (NullPointerException exception) {
            exception.getMessage();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return null;
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String json) {
        try {
            AuthService authService = new AuthService();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(authService.login(gson.fromJson(json, User.class)))).build();
        } catch (NullPointerException exception) {
            exception.getMessage();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return null;
    }

    @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(String json) {
        try {
            AuthService authService = new AuthService();
            Gson gson = new Gson();
            return Response.ok(gson.toJson(authService.logout(gson.fromJson(json, User.class)))).build();
        } catch (NullPointerException exception) {
            exception.getMessage();
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return null;
    }
}
