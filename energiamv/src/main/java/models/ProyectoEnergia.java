package models;

public class ProyectoEnergia {
    private String nombreProyecto;
    private String estado;
    private double montoInversion;
    private String tiempoInicioConstruccion;
    private String tiempoFinConstruccion;
    private String tiempoVida;
    private String ubicacion;
    private float capacidadGeneracionDiaria;

    private Inversionista[] inversionistas;
    private int numeroInversionistas;

    // Constructor
    public ProyectoEnergia(String nombreProyecto, String estado, double montoInversion, String tiempoInicioConstruccion, String tiempoFinConstruccion, String tiempoVida, String ubicacion, float capacidadGeneracionDiaria) {
        this.nombreProyecto = nombreProyecto;
        this.estado = estado;
        this.montoInversion = montoInversion;
        this.tiempoInicioConstruccion = tiempoInicioConstruccion;
        this.tiempoFinConstruccion = tiempoFinConstruccion;
        this.tiempoVida = tiempoVida;
        this.ubicacion = ubicacion;
        this.capacidadGeneracionDiaria = capacidadGeneracionDiaria;
        this.inversionistas = new Inversionista[10]; //inicialmente sera 10, pero con metodos se podra aumentar
        this.numeroInversionistas = 0;
    }


    // Getters y Setters
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

    public Inversionista[] getInversionistas() {
        return inversionistas;
    }

    public void setInversionistas(Inversionista[] inversionistas) {
        this.inversionistas = inversionistas;
    }

    public int getNumeroInversionistas() {
        return numeroInversionistas;
    }

    public void setNumeroInversionistas(int numeroInversionistas) {
        this.numeroInversionistas = numeroInversionistas;
    }

    // Metodos



}
