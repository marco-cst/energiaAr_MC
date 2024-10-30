package models;

public class Inversionista extends Persona{
    private float montoInvertido;
    private String tipoInversionista;

    public Inversionista(int idPersona, String nombre, String apellido, String DNI, String celular) {
        super(idPersona, nombre, apellido, DNI, celular);
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
