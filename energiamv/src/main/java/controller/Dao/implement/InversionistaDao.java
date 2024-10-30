package controller.Dao.implement;

import models.Inversionista;

public class InversionistaDao {
    private Inversionista [] inversionistas;
    private int numeroInversionistas;

    public InversionistaDao() {
        inversionistas = new Inversionista[10];
        numeroInversionistas = 0;
    }

    public void addInversionista(Inversionista inversionista){
        if(numeroInversionistas == inversionistas.length){
            redimensionarArray();
        }
        inversionistas[numeroInversionistas++] = inversionista;
    }

    private void redimensionarArray(){
        Inversionista [] nuevoArrayInv = new Inversionista[inversionistas.length+10];
        System.arraycopy(inversionistas, 0, nuevoArrayInv, 0, inversionistas.length);
        inversionistas = nuevoArrayInv;
    }

    public Inversionista getInversionista(int indice){
        if (indice >= numeroInversionistas || indice < 0){
            throw new IndexOutOfBoundsException("Indice: "+indice+", Size: "+numeroInversionistas);
        }
        return inversionistas[indice];
    }

    public int getNumeroInversionistas(){
        return numeroInversionistas;
    }
}
