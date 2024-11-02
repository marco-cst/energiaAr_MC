package controller.Dao;

import controller.Dao.implement.AdapterDao;
import controller.Dao.implement.InversionistaDao;
import models.Persona;
import models.ProyectoEnergia;

public class PersonaDao extends AdapterDao{

    private InversionistaDao inversionista;
    private ProyectoEnergia proyecto;
    private int size = 0;

    private Persona persona;

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

    // V - PS
    // public Boolean save() throws Exception{
    //     Integer inversionistaId = getInversionista().getSize() + 1;
    //     persona.setIdPersona(inversionistaId);

    //     return true;
    // }

}
