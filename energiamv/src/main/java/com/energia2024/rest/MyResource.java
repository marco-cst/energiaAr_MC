package com.energia2024.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.Dao.implement.AdapterDao;
import controller.Dao.services.PersonaServices;
import models.Inversionista;
import models.ProyectoEnergia;


 @Path("myresource")
 public class MyResource {
 
    //persona-inversionista
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getIt() {
         HashMap<String, String> mapa = new HashMap<>();
         PersonaServices pd = new PersonaServices();
         String aux = "";
 
         try {
             Inversionista inversionista = new Inversionista(11, "Maria", "Bendett", "0700555327", "0922344234", 18600.20f, "Inversionista Publico");

             AdapterDao.savePersona(inversionista, "inversionistas.json");

             aux = "Persona inversionista guardada: " + inversionista;
 
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

     //proyectos
     @GET
     @Path("/saveProyecto")
     @Produces(MediaType.APPLICATION_JSON)
     public Response saveProyecto() {
         HashMap<String, String> mapa = new HashMap<>();
         String aux = "";
 
         try {
             ProyectoEnergia proyecto = new ProyectoEnergia(5, "Proyecto Parque Eolico", "En construccion", 650000.00, "2022-03-05", "2024-05-20", "22 años", "Quito", 160000.0f, 2);

            //asginar inversionista a proyectos.
            Inversionista[] inversionistas = AdapterDao.cargarInversionistas("inversionistas.json");

            if (inversionistas.length > 0) {
                proyecto.setInversionistas(new Inversionista[]{inversionistas[3], inversionistas[5]});
                proyecto.setNumeroInversionistas(2);
            }
            //fin asignacion

             AdapterDao.saveProyecto(proyecto, "proyectos.json");
 
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