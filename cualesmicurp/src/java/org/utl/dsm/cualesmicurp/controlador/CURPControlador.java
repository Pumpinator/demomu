/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cualesmicurp.controlador;

import com.google.gson.Gson;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.utl.dsm.cualesmicurp.modelo.CURP;

/**
 *
 * @author alejandro
 */
@Path("")
public class CURPControlador {
    
    @POST
    @Path("/generar")
    @Produces("application/json")
    public Response generar(String json) {
        Gson gson = new Gson();
        CURP datos = gson.fromJson(json, CURP.class);
        CURP curp = new CURP(datos.getNombre(), datos.getPrimerApellido(), datos.getSegundoApellido(), datos.getDiaDeNacimiento(), datos.getMesDeNacimiento(), datos.getAñoDeNacimiento(), datos.getSexo(), datos.getEstado());
        curp.generar();
        return Response.ok(gson.toJson(curp)).build();
    }
    
}
