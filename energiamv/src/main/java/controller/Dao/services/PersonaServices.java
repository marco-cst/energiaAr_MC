package controller.Dao.services;

import controller.Dao.PersonaDao;
import models.Persona;

public class PersonaServices {
    
    private PersonaDao personaDao;
    
    public PersonaServices() {
        this.personaDao = new PersonaDao();
    }

    public Persona getPersona(){
        return this.personaDao.getPersona();
    }

    public void setPersona( Persona persona){
        this.personaDao.setPersona(persona);
    }

    //V - PD

    // public Boolean save() throws Exception{
    //     return this.personaDao.save();
    // }


}
