package controller.Dao.services;

import controller.Dao.PersonaDao;
import models.Persona;

public class PersonaServices {
    
    private PersonaDao personaDao; //private PersonaDao obj;
    
    public PersonaServices() {
        this.personaDao = new PersonaDao();
    }

    public Persona getPersona(){
        //return obj.getPersona();
        return this.personaDao.getPersona();
    }

    public void setPersona( Persona persona){
        //obj.setPersona(persona);
        this.personaDao.setPersona(persona);
    }

    public Boolean save() throws Exception{
        //return obj.save();
        return this.personaDao.save();
    }


}
