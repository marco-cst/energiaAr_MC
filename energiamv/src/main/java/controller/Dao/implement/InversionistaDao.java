package controller.Dao.implement;

import models.Inversionista;

public class InversionistaDao {
    private Inversionista [] inversionistas;
    private int numeroInversionistas;

    private InversionistaDao obj;
    private Integer size;

    public InversionistaDao() {
        inversionistas = new Inversionista[10];
        numeroInversionistas = 0;
    }


    public void addInversionista(Inversionista inversionista){
        if(numeroInversionistas == inversionistas.length){
            redimensionarArrayInv();
        }
        inversionistas[numeroInversionistas++] = inversionista;
    }

    private void redimensionarArrayInv(){
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

    //new
    public Inversionista[] getInversionistas() {
        return inversionistas;
    }

    public void setInversionistas(Inversionista[] inversionistas) {
        this.inversionistas = inversionistas;
        this.numeroInversionistas = inversionistas.length;
    }

    //new 2

    public Integer getSize(){
        return this.size;
    }
}