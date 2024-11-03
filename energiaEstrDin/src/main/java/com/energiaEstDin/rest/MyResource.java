package com.energiaEstDin.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.Dao.implement.AdapterDao;
import controller.Dao.services.PersonaServices;
import controller.tda.list.LinkedList;
import models.Inversionista;
import models.ProyectoEnergia;

/**
 * Root resource (exposed at "myresource" path)
 */
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

 //newww

 @Path("myresource")
public class MyResource {
    // Persona-inversionista
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        HashMap<String, String> mapa = new HashMap<>();
        PersonaServices pd = new PersonaServices();
        String aux = "";

        try {
            LinkedList<Inversionista> inversionistasList = new LinkedList<>();
            Inversionista inversionista = new Inversionista(6, "Josep", "Benaditez", "0846593754", "0982356281", 140000.00f, "Inversionista Publico");

            inversionistasList.add(inversionista);
            AdapterDao.saveInversionistas(inversionistasList, "inversionistas.json");

            aux = "Persona inversionista guardada: ";

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e);
            mapa.put("msg", "error");
            mapa.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }

        mapa.put("msg", "ok");
        mapa.put("data", aux);
        return Response.ok(mapa).build();
    }

    // Proyectos
    @GET
    @Path("/saveProyecto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProyecto() {
        HashMap<String, String> mapa = new HashMap<>();
        String aux = "";
    
        try {
            LinkedList<ProyectoEnergia> proyectosList = new LinkedList<>();
            ProyectoEnergia proyecto = new ProyectoEnergia(5, "Proyecto Parque Eolico", "En construccion", 230000.00, "2023-01-10", "2025-03-30", "21 años", "Quito", 130000.0f, 0);
            proyectosList.add(proyecto);
            AdapterDao.saveProyectos(proyectosList, "proyectos.json");
    
            aux = "Proyecto guardado: ";
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e);
            mapa.put("msg", "error");
            mapa.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }
    
        mapa.put("msg", "ok");
        mapa.put("data", aux);
        return Response.ok(mapa).build();
    }
}