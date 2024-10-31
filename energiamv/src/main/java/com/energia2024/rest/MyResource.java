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
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
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
            pd.getPersona().setNombre("Jose");
            pd.getPersona().setApellido("Valdez");
            pd.getPersona().setDNI("001-9999999-0");
            pd.getPersona().setCelular("999-111-3333");

            AdapterDao.savePersona(persona, "inversionista.json");
            
            aux = "se agregan datos a la lista " ; //+persona

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

}
