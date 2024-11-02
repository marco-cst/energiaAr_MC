package models;

import com.google.gson.annotations.Expose;

import controller.tda.list.LinkedList;

public class ProyectoEnergia {
    @Expose
    private Integer idProyecto;
    @Expose
    private String nombreProyecto;
    @Expose
    private String estado;
    @Expose
    private double montoInversion;
    @Expose
    private String tiempoInicioConstruccion;
    @Expose
    private String tiempoFinConstruccion;
    @Expose
    private String tiempoVida;
    @Expose
    private String ubicacion;
    @Expose
    private float capacidadGeneracionDiaria;
    private int cantidadProyectos;

    @Expose
    private LinkedList<Inversionista> inversionistas;

    //private Inversionista[] inversionistas;
    @Expose
    private int numeroInversionistas;

    // Constructor
    public ProyectoEnergia(Integer idProyecto, String nombreProyecto, String estado, double montoInversion, String tiempoInicioConstruccion, String tiempoFinConstruccion, String tiempoVida, String ubicacion, float capacidadGeneracionDiaria, int cantidadProyectos) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.estado = estado;
        this.montoInversion = montoInversion;
        this.tiempoInicioConstruccion = tiempoInicioConstruccion;
        this.tiempoFinConstruccion = tiempoFinConstruccion;
        this.tiempoVida = tiempoVida;
        this.ubicacion = ubicacion;
        this.capacidadGeneracionDiaria = capacidadGeneracionDiaria;
        this.inversionistas = new LinkedList<>();
        this.numeroInversionistas = 0;
        this.cantidadProyectos = 0;
    }

    // Getters y Setters
    public Integer getIdProyecto(){
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMontoInversion() {
        return montoInversion;
    }

    public void setMontoInversion(double montoInversion) {
        this.montoInversion = montoInversion;
    }

    public String getTiempoInicioConstruccion() {
        return tiempoInicioConstruccion;
    }

    public void setTiempoInicioConstruccion(String tiempoInicioConstruccion) {
        this.tiempoInicioConstruccion = tiempoInicioConstruccion;
    }

    public String getTiempoFinConstruccion() {
        return tiempoFinConstruccion;
    }

    public void setTiempoFinConstruccion(String tiempoFinConstruccion) {
        this.tiempoFinConstruccion = tiempoFinConstruccion;
    }

    public String getTiempoVida() {
        return tiempoVida;
    }

    public void setTiempoVida(String tiempoVida) {
        this.tiempoVida = tiempoVida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getCapacidadGeneracionDiaria() {
        return capacidadGeneracionDiaria;
    }   

    public void setCapacidadGeneracionDiaria(float capacidadGeneracionDiaria) {
        this.capacidadGeneracionDiaria = capacidadGeneracionDiaria;
    }

    // GS Inversionistas

    public LinkedList<Inversionista> getInversionistas() {
        return inversionistas;
    }

    public void setInversionistas(LinkedList<Inversionista> inversionistas) {
        this.inversionistas = inversionistas;
    }

    // public Inversionista[] getInversionistas() {
    //     return inversionistas;
    // }

    // public void setInversionistas(Inversionista[] inversionistas) {
    //     this.inversionistas = inversionistas;
    // }

    public int getNumeroInversionistas() {
        return numeroInversionistas;
    }

    public void setNumeroInversionistas(int numeroInversionistas) {
        this.numeroInversionistas = numeroInversionistas;
    }

    // GS Num proyectos

    public int getCantidadProyectos(){
        return cantidadProyectos;   
    }

    public void setCantidadProyectos(int cantidadProyectos){
        this.cantidadProyectos = cantidadProyectos;
    }
}
