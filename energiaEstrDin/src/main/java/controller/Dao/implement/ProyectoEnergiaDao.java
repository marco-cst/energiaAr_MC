package controller.Dao.implement;

import controller.tda.list.LinkedList;
import controller.tda.list.ListEmptyException;
import models.ProyectoEnergia;


public class ProyectoEnergiaDao {
    // private LinkedList<ProyectoEnergia> proyectos;
    
    private LinkedList<ProyectoEnergia> proyectos = new LinkedList<>();


    public ProyectoEnergiaDao() {
        this.proyectos = new LinkedList<>();
    }

    public void addProyecto(ProyectoEnergia proyecto){
        proyectos.add(proyecto);
    }

    // public void removeProyecto(ProyectoEnergia proyecto) {
    //     this.proyectos.remove(proyecto);
    // }

    public ProyectoEnergia getProyectoEnergia(int indice) throws ListEmptyException {
        return proyectos.get(indice);
    }

    public LinkedList<ProyectoEnergia> getAllProyectos() {
        return proyectos;
    }

    public void guardarDatos() {
        AdapterDao.saveProyectos(proyectos, "src/main/java/Data/proyectos.json");
    }

    public void cargarDatos() {
        proyectos = AdapterDao.cargarProyectos("src/main/java/Data/proyectos.json");
    }

}
