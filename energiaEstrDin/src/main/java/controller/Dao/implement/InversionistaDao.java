package controller.Dao.implement;

import controller.tda.list.LinkedList;
import controller.tda.list.ListEmptyException;
import models.Inversionista;

public class InversionistaDao {

    private LinkedList<Inversionista> inversionistas;

    public InversionistaDao() {
        inversionistas = new LinkedList<>();
    }

    public void addInversionista(Inversionista inversionista) {
        inversionistas.add(inversionista);
    }

    public Inversionista getInversionista(int indice) throws ListEmptyException {
        return inversionistas.get(indice);
    }
    
    public LinkedList<Inversionista> getAllInversionistas() {
        return inversionistas;
    }

    public void guardarDatos() {
        AdapterDao.saveInversionistas(inversionistas, "src/main/java/Data/inversionistas.json");
    }

    public void cargarDatos() {
        inversionistas = AdapterDao.cargarInversionistas("src/main/java/Data/inversionistas.json");
    }
}
