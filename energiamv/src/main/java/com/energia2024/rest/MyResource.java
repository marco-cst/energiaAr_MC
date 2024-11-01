package com.energia2024.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.Dao.implement.AdapterDao;
import controller.Dao.services.PersonaServices;
import models.Persona;

/**
 * Root resource (exposed at "myresource" path)
 */

 /* */

 /* INICIO Y FIN
@Path("myresource")
public class MyResource {
DE COMENTARIO*/

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        //return "Got it!";

        //HashMap mapa = new HashMap<>();
        HashMap<String, String> mapa = new HashMap<>();
        PersonaServices  pd = new PersonaServices();
        String aux = "";

        try {
            Persona persona = pd.getPersona();
            pd.getPersona().setIdPersona(2);
            pd.getPersona().setNombre("Josefine");
            pd.getPersona().setApellido("Vargosa");
            pd.getPersona().setDNI("001-882893-092");
            pd.getPersona().setCelular("999-342-123");

            // Inversionista inversionista = new Inversionista(persona.getIdPersona(), persona.getNombre(), persona.getApellido(), persona.getDNI(), persona.getCelular());
            // AdapterDao.saveInversionistas(inversionista, "inversonista.json");

           AdapterDao.savePersona(persona, "inversionista.json");
            
            aux = "se agregan datos a la lista " + persona; //+persona

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e);
            mapa.put("msg", "error");
            mapa.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }

        mapa.put("msg", "ok");
        mapa.put("data", "test "+aux);
        return Response.ok(mapa).build();
    }
    
}
     */

/*
    private ProyectoEnergiaDao proyectoEnergiaDao = new ProyectoEnergiaDao();
    private InversionistaDao inversionistaDao = new InversionistaDao();
    
    @POST
    @Path("/addProyecto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProyecto(ProyectoEnergia proyecto) {
        proyectoEnergiaDao.addProyectos(proyecto);
        proyectoEnergiaDao.guardarDatos(); // Guarda en JSON
        return Response.ok("{\"msg\": \"Proyecto agregado exitosamente\"}").build();
    }

    @POST
    @Path("/addInversionista")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInversionista(Inversionista inversionista) {
        inversionistaDao.addInversionista(inversionista);
        proyectoEnergiaDao.guardarDatos(); // Guarda también los inversionistas en JSON
        return Response.ok("{\"msg\": \"Inversionista agregado exitosamente\"}").build();
    }

 */

 @Path("myresource")
 public class MyResource {
 
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getIt() {
         HashMap<String, String> mapa = new HashMap<>();
         PersonaServices pd = new PersonaServices();
         String aux = "";
 
         try {
             Persona persona = pd.getPersona();
             persona.setIdPersona(3);
             persona.setNombre("Juan");
             persona.setApellido("Aguilar");
             persona.setDNI("001-8765556-0");
             persona.setCelular("123-2345-086");
             
             // Guardar la persona en un archivo JSON
             AdapterDao.savePersona(persona, "personas.json");

             aux = "Persona guardada: " + persona;
 
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