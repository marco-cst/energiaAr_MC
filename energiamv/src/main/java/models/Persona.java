package models;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private String DNI;
    private String celular;

    private Inversionista inversionista;

    private float montoInvertido;
    private String tipoInversionista;


//new
    //private Persona obj;

    public Persona() {
        //obj = new Persona();
    }
//---

    public Persona(int idPersona, String nombre, String apellido, String DNI, String celular, float montoInvertido, String tipoInversionista) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.celular = celular;
        this.montoInvertido = montoInvertido;
        this.tipoInversionista = tipoInversionista;
    }
 
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

    //testeo
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
