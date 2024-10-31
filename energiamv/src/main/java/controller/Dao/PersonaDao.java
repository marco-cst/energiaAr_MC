package controller.Dao;

import controller.Dao.implement.AdapterDao;
import controller.Dao.implement.InversionistaDao;
import models.Persona;
import models.ProyectoEnergia;



public class PersonaDao extends AdapterDao{

    private InversionistaDao inversionista;
    //private Inversionista inversionist;
    private ProyectoEnergia proyecto;
    
//new
    private int size = 0;


    //private Persona persona = new Persona(); 

    private Persona persona;


    // public PersonaDao(Inversionista inversionista, ProyectoEnergia proyecto) {
    //     //this.inversionist = inversionista;
    //     //this.proyecto = proyecto;
    // }

    public PersonaDao() {
        this.persona = new Persona();
    }

    public Persona getPersona(){
        if (persona == null) {
            persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public InversionistaDao getInversionista() {
        if (inversionista == null) {
            inversionista = new InversionistaDao();
        }
        return inversionista;
    }

    // public Integer getSize(){
    //     return this.size;
    // }



    public Boolean save() throws Exception{
        // Guardar inversionista
        Integer inversionistaId = getInversionista().getSize() + 1;
        persona.setIdPersona(inversionistaId);
        //inversionista.setInversionistas(inversionista.getInversionistas());
        //inversionista.setId(inversionistaId);
        //saveInversionista(inversionista);

        // Guardar proyecto
        // Integer proyectoId = getProyectos().size() + 1;
        // proyecto.setIdProyecto(proyectoId);
        // //saveProyecto(proyecto);
        // //saveProyecto(proyecto);

        return true;
    }

//save por complementar
    public void savePersona(Persona persona) {
        // Implementar la lógica para guardar la persona
        AdapterDao.savePersona(persona, "inversionista.json");
    }


}
