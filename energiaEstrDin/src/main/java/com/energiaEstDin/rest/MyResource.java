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
                             /*
@Path("myresource")
public class MyResource {
                            */
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
/*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
*/
/* PRINCIPAL
@Path("myresource")
public class MyResource {
    //persona-inversionista
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getIt() {
         HashMap<String, String> mapa = new HashMap<>();
         InversionistaDao pd = new InversionistaDao();
         String aux = "";
 
         try {
            Inversionista inversionista = new Inversionista(1, "Juan", "Perez", "123456", "0987654321", 100000.00f, "Inversionista Privado");
            LinkedList<Inversionista> inversionistasList = new LinkedList<>();
            inversionistasList.add(inversionista);
            AdapterDao.saveInversionistas(inversionistasList, "inversionistas.json");

             aux = "Persona inversionista guardada: " ;
 
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

    @GET
     @Path("/saveProyecto")
     @Produces(MediaType.APPLICATION_JSON)
     public Response saveProyecto() {
         HashMap<String, String> mapa = new HashMap<>();
         String aux = "";
 
         try {
             ProyectoEnergia proyecto = new ProyectoEnergia(4, "Proyecto Termo electrica", "En construccion", 750000.00, "2020-01-10", "2022-03-30", "18 años", "Guataquill", 120000.0f, 1);

            //Inversionista[] inversionistas = AdapterDao.loadInversionistas("inversionistas.json").toArray(new Inversionista[0]);

            //LinkedList<Inversionista> inversionistas = AdapterDao.loadInversionistas("inversionistas.json");

            AdapterDao.saveProyectos(proyecto, "Proyectos.json");
            
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
*/

/*
     private ProyectoEnergiaDao proyectoDao = new ProyectoEnergiaDao();
    private InversionistaDao inversionistaDao = new InversionistaDao();

    @POST
    @Path("/proyecto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProyecto(ProyectoEnergia proyecto) {
        proyectoDao.addProyecto(proyecto);
        proyectoDao.guardarDatos();
        return Response.status(Response.Status.CREATED).entity("Proyecto agregado").build();
    }

    @POST
    @Path("/inversionista")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addInversionista(Inversionista inversionista) {
        inversionistaDao.addInversionista(inversionista);
        inversionistaDao.guardarDatos();
        return Response.status(Response.Status.CREATED).entity("Inversionista agregado").build();
    }
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
        //Inversionista inver = new Inversionista();
        String aux = "";

        try {
            LinkedList<Inversionista> inversionistasList = new LinkedList<>();
            Inversionista inversionista = new Inversionista(3, "Carlos", "Perez", "123456", "0987654321", 100000.00f, "Inversionista Privado");
            inversionistasList.add(inversionista);
            AdapterDao.saveInversionistas(inversionistasList, "src/main/java/Data/inversionistas.json");

            // pd.setPersona(inversionista);
            // pd.saveInversionistas();


            //Inversionista inversionista = new Inversionista(1, "Juan", "Perez", "123456", "0987654321", 100000.00f, "Inversionista Privado");
            //LinkedList<Inversionista> inversionistasList = new LinkedList<>();
            //inversionistasList.add(inversionista);
            //AdapterDao.saveInversionistas(inversionistasList, "src/main/java/Data/inversionistas.json");
            //AdapterDao.saveInversionistas(inversionistasList, "inversionista.json");

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

    @GET
    @Path("/saveProyecto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProyecto() {
        HashMap<String, String> mapa = new HashMap<>();
        String aux = "";

        try {
            ProyectoEnergia proyecto = new ProyectoEnergia(4, "Proyecto Termo electrica", "En construccion", 750000.00, "2020-01-10", "2022-03-30", "18 años", "Guataquill", 120000.0f, 1);
            LinkedList<ProyectoEnergia> proyectosList = new LinkedList<>();
            proyectosList.add(proyecto);
            AdapterDao.saveProyectos(proyectosList, "src/main/java/Data/proyectos.json");

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