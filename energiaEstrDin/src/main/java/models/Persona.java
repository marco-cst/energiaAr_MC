package models;

import com.google.gson.annotations.Expose;

public class Persona {
    @Expose
    private int idPersona;
    @Expose
    private String nombre;
    @Expose
    private String apellido;
    @Expose
    private String DNI;
    @Expose
    private String celular;
    @Expose
    private float montoInvertido;
    @Expose
    private String tipoInversionista;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellido, String DNI, String celular, float montoInvertido, String tipoInversionista) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.celular = celular;
        this.montoInvertido = montoInvertido;
        this.tipoInversionista = tipoInversionista;
    }

    // Getters y Setters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public float getMontoInvertido() {
        return montoInvertido;
    }

    public void setMontoInvertido(float montoInvertido) {
        this.montoInvertido = montoInvertido;
    }

    public String getTipoInversionista() {
        return tipoInversionista;
    }

    public void setTipoInversionista(String tipoInversionista) {
        this.tipoInversionista = tipoInversionista;
    }
}