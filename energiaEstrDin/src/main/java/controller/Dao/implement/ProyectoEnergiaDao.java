package controller.Dao.implement;

import controller.tda.list.LinkedList;
import controller.tda.list.ListEmptyException;
import models.ProyectoEnergia;


public class ProyectoEnergiaDao {
    private LinkedList<ProyectoEnergia> proyectos;
    

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

    // public LinkedList<ProyectoEnergia> getProyectos() {
    //     return proyectos;
    // }

    public LinkedList<ProyectoEnergia> getAllProyectos() {
        return proyectos;
    }

    public void guardarDatos() {
        // Llamamos al método en AdapterDao para guardar la LinkedList de proyectos
        AdapterDao.saveProyectos(proyectos, "src/main/java/Data/proyectos.json");
    }

    public void cargarDatos() {
        // Cargamos los datos y los asignamos a la lista de proyectos
        proyectos = AdapterDao.loadProyectos("src/main/java/Data/proyectos.json");
    }

/*
    public int getCantidadProyectos() {
        return proyectos.size();
    }

    public void guardarDatos() {
        ProyectoEnergia[] proyectosArray = proyectos.toArray(new ProyectoEnergia[proyectos.size()]);
        AdapterDao.saveProyectos(proyectosArray, "src/main/java/Data/proyectos.json");
    }

    public void cargarDatos() {
        ProyectoEnergia[] proyectosArray = AdapterDao.cargarProyectos("src/main/java/Data/proyectos.json");
        proyectos = new LinkedList<>();
        for (ProyectoEnergia proyecto : proyectosArray) {
            proyectos.add(proyecto);
        }
    }

 */
}
