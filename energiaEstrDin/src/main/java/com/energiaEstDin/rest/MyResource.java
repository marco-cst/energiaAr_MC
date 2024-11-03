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
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        HashMap<String, String> mapa = new HashMap<>();
        PersonaServices pd = new PersonaServices();
        String aux = "";

        try {
            LinkedList<Inversionista> inversionistasList = new LinkedList<>();
            Inversionista inversionista = new Inversionista(4, "Lizet", "Cardenas", "123456", "0987654321", 100000.00f, "Inversionista Privado");
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
            ProyectoEnergia proyecto = new ProyectoEnergia(7, "Proyecto Hidroelectrica", "Construida", 750000.00, "2020-01-10", "2022-03-30", "18 años", "Guataquill", 120000.0f, 1);
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