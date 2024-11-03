package controller.Dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Inversionista;
import models.Persona;
import models.ProyectoEnergia;

public class AdapterDao{

    //private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

    private static String BASE_PATH = "src/main/java/Data";

    private static void verificarDirectorio() {
        File directorio = new File(BASE_PATH);

        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println("Directorio creado: " + BASE_PATH);
        }
    }

    public static void saveProyecto(ProyectoEnergia nuevoProyecto, String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        ProyectoEnergia[] proyectosExistentes = cargarProyectos(nombreArchivo);
        ProyectoEnergia[] nuevosProyectos = new ProyectoEnergia[proyectosExistentes.length + 1];
    
        System.arraycopy(proyectosExistentes, 0, nuevosProyectos, 0, proyectosExistentes.length);
    
        nuevosProyectos[proyectosExistentes.length] = nuevoProyecto;
    
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(nuevosProyectos, writer);
            System.out.println("Archivo guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    //subir datos en json
    public static ProyectoEnergia[] cargarProyectos(String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        try (FileReader reader = new FileReader(rutaArchivo)) {
            ProyectoEnergia[] proyectos = gson.fromJson(reader, ProyectoEnergia[].class);
            return proyectos != null ? proyectos : new ProyectoEnergia[0];
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return new ProyectoEnergia[0];
        }
    }

    public static void saveInversionistas(Inversionista nuevoInversionista, String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;
    
        Inversionista[] inversionistasExistentes = cargarInversionistas(filePath);        
        Inversionista[] nuevosInversionistas = new Inversionista[inversionistasExistentes.length + 1];
    
        System.arraycopy(inversionistasExistentes, 0, nuevosInversionistas, 0, inversionistasExistentes.length);
    
        nuevosInversionistas[inversionistasExistentes.length] = nuevoInversionista;
    
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(nuevosInversionistas, writer);
            System.out.println("Archivo datos inversionistas guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo inversionistas: " + e.getMessage());
        }
    }


     public static Inversionista[] cargarInversionistas(String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, Inversionista[].class);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return new Inversionista[0];
        }
    }

    public static void savePersona(Persona nuevaPersona, String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        Persona[] personasExistentes = cargarPersonas(nombreArchivo);    
        Persona[] nuevasPersonas = new Persona[personasExistentes.length + 1];
    
        System.arraycopy(personasExistentes, 0, nuevasPersonas, 0, personasExistentes.length);

        nuevasPersonas[personasExistentes.length] = nuevaPersona;
    
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(nuevasPersonas, writer);
            System.out.println("Archivo guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
    public static Persona[] cargarPersonas(String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, Persona[].class);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return new Persona[0];
        }
    }

    public static void updatePersona(Persona[] personas, int index, Persona nuevaPersona) throws IndexOutOfBoundsException {
        if (index < 0 || index >= personas.length) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        }
        personas[index] = nuevaPersona;
    }

    public static Persona[] deletePersona(Persona[] personas, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= personas.length) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        }
        Persona[] nuevoArreglo = new Persona[personas.length - 1];
        for (int i = 0, j = 0; i < personas.length; i++) {
            if (i != index) {
                nuevoArreglo[j++] = personas[i];
            }
        }
        return nuevoArreglo;
    }

}
