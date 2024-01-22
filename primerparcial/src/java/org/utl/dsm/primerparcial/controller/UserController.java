/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.primerparcial.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
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
    public Response findAll() throws SQLException {
        UserService userService = new UserService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(userService.list())).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String json) throws SQLException, URISyntaxException {
        AuthService authService = new AuthService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(authService.login(gson.fromJson(json, User.class)))).build();
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(String json) throws SQLException {
        UserService userService = new UserService();
        Gson gson = new Gson();
        return Response.ok(gson.toJson(userService.save(gson.fromJson(json, User.class)))).build();
    }
}
