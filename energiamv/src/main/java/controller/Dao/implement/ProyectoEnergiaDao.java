package controller.Dao.implement;

import java.io.File;

import models.Inversionista;
import models.ProyectoEnergia;

public class ProyectoEnergiaDao {
    private ProyectoEnergia[] proyectos;
    private int cantidadProyectos;
    private InversionistaDao inversionistaDao;

    private int cantidadInversionistas;
    private Inversionista[] inversionistas;

    public ProyectoEnergiaDao(){
        this.proyectos =  new ProyectoEnergia[10]; //10 como base, pero aumentara el num en caso de llegar al limite
        this.cantidadProyectos = 0;

        // this.inversionistas = new Inversionista[10];
        // this.cantidadInversionistas = 0;
        this.inversionistaDao = new InversionistaDao();
    }

    public void addProyectos(ProyectoEnergia proyecto){
        if(cantidadProyectos == proyectos.length){
            redimensionarArrayProyectos();
        }
        proyectos[cantidadProyectos++] = proyecto;
    }

    public void redimensionarArrayProyectos(){
        ProyectoEnergia[] newArrayProyectos = new ProyectoEnergia[proyectos.length+10];
        System.arraycopy(proyectos, 0, newArrayProyectos, 0, proyectos.length);
        proyectos = newArrayProyectos;
    }

    //inversionistas

    public void addInversionista(Inversionista inversionista) {
        inversionistaDao.addInversionista(inversionista);
    }

    public Inversionista[] getInversionistas() {
        return inversionistaDao.getInversionistas();
    }

    public int getNumeroInversionistas() {
        return inversionistaDao.getNumeroInversionistas();
    }

    //guardar y cargar datos
    public void guardarDatos() {
        File directory = new File("src/main/java/Data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        //AdapterDao.saveProyecto(proyectos, "src/main/java/Data/proyectos.json");
        for (ProyectoEnergia proyecto : proyectos) {
            AdapterDao.saveProyecto(proyecto, "src/main/java/Data/proyectos.json");
        }

        //AdapterDao.saveInversionistas(inversionistaDao.getInversionistas(), "src/main/java/Data/inversionistas.json");
        for (Inversionista inversionista : inversionistaDao.getInversionistas()) {
            AdapterDao.saveInversionistas(inversionista, "src/main/java/Data/inversionistas.json");
        }
    }

    public void cargarDatos() {
        proyectos = AdapterDao.cargarProyectos("proyectos.json");
        inversionistaDao.setInversionistas(AdapterDao.cargarInversionistas("inversionistas.json"));
        cantidadProyectos = proyectos.length;
    }

}
