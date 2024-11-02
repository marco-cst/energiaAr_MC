package com.energiaEstDin.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;
import models.Inversionista;
import models.ProyectoEnergia;

@Path("proyectos")
public class ProyectosApi {

    @Path("/inversionistas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInversionistas() {
        HashMap<String, Object> mapa = new HashMap<>();

        try {
            LinkedList<Inversionista> inversionistas = AdapterDao.cargarInversionistas("inversionistas.json");

            mapa.put("msg", "ok");
            mapa.put("data", inversionistas);
            return Response.ok(mapa).build();

        } catch (Exception e) {
            System.out.println("Error al cargar inversionistas: " + e);
            mapa.put("msg", "error");
            mapa.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }
    }

    //proyectos
    @GET
    @Path("/infoProyectos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProyectos() {
        HashMap<String, Object> mapa = new HashMap<>();

        try {
            LinkedList<ProyectoEnergia> proyectos = AdapterDao.cargarProyectos("proyectos.json");

            mapa.put("msg", "ok");
            mapa.put("data", proyectos);
            return Response.ok(mapa).build();

        } catch (Exception e) {
            System.out.println("Error al cargar proyectos: " + e);
            mapa.put("msg", "error");
            mapa.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }
    }
}