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

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static String BASE_PATH = "src/main/java/Data";

    private static void verificarDirectorio() {
        File directorio = new File(BASE_PATH);

        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println("Directorio creado: " + BASE_PATH);
        } //else{
            //throw new RuntimeException("El directorio existe ");
        //}
    }

        //guard persona

        // public static void savePersona(Persona persona, String nombreArchivo) {
        //     verificarDirectorio();
        //     String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        //     try (FileWriter writer = new FileWriter(rutaArchivo)) {
        //         gson.toJson(persona, writer);
        //         System.out.println("Archivo guardado en: " + rutaArchivo);
        //     } catch (IOException e) {
        //         System.out.println("Error al guardar el archivo: " + e.getMessage());
        //     }
        // }


    //save datos en json
    /*
    public static void saveProyectos(ProyectoEnergia[] proyectos, String nombreArchivo){
        verificarDirectorio();
        //String json = gson.toJson(proyectos); //CPL

        String rutaArchivo = BASE_PATH + nombreArchivo;

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(proyectos, writer);
            System.out.println("Archivo guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    */

    public static void saveProyectos(ProyectoEnergia[] proyectos, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(proyectos, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar los proyectos: " + e.getMessage());
        }
    }


    //Cargar datos en json
    public static ProyectoEnergia[] subirProyecto(String nombreArchivo){
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + nombreArchivo;
        
        try (FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, ProyectoEnergia[].class);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return new ProyectoEnergia[0];
        }
    }

    // Guarda los datos de inversionistas en un archivo JSON
    /*
        public static void saveInversionistas(Inversionista[] inversionistas, String nombreArchivo) {
            verificarDirectorio();
            String rutaArchivo = BASE_PATH + nombreArchivo;

            try(FileWriter writer = new FileWriter(rutaArchivo)) {
                gson.toJson(inversionistas, writer);
                System.out.println("Archivo datos inversionistas guardado en: " + rutaArchivo);
            } catch (Exception e) {
                System.out.println("Error al guardar el archivo inversionistas: " + e.getMessage());
            }
        }
    */

    //add Reciente
    /*
    public static void saveInversionistas(Inversionista nuevoInversionista, String filePath) { //(Inversionista[] inversionistas, String filePath)
        //implementaros para agregar mas info a la lista, sin perder la anterior
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        Inversionista[] inversionistasExistentes = cargarInversionistas(filePath);
        Inversionista[] nuevosInversionistas = new Inversionista[inversionistasExistentes.length + 1]; //+ inversionistas.length

        System.arraycopy(inversionistasExistentes, 0, nuevosInversionistas, 0,inversionistasExistentes.length); // Default -> opy(rutaArchivo, 0, nuevosInversionistas, 0, 0);

        nuevosInversionistas[inversionistasExistentes.length] = nuevoInversionista;

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(nuevosInversionistas, writer); // (inversionistas, writer);
            System.out.println("Archivo datos inversionistas guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los inversionistas: " + e.getMessage());
        }
    }
        */

        public static void saveInversionistas(Inversionista nuevoInversionista, String filePath) {
            verificarDirectorio();
            String rutaArchivo = BASE_PATH + "/" + filePath;
        
            // Cargar los inversionistas existentes
            Inversionista[] inversionistasExistentes = cargarInversionistas(filePath);
        
            // Crear un nuevo array con tamaño incrementado
            Inversionista[] nuevosInversionistas = new Inversionista[inversionistasExistentes.length + 1];
        
            // Copiar los inversionistas existentes al nuevo array
            System.arraycopy(inversionistasExistentes, 0, nuevosInversionistas, 0, inversionistasExistentes.length);
        
            // Agregar el nuevo inversionista al final del nuevo array
            nuevosInversionistas[inversionistasExistentes.length] = nuevoInversionista;
        
            // Guardar el nuevo array en el archivo JSON
            try (FileWriter writer = new FileWriter(rutaArchivo)) {
                gson.toJson(nuevosInversionistas, writer);
                System.out.println("Archivo datos inversionistas guardado en: " + rutaArchivo);
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo inversionistas: " + e.getMessage());
            }
        }
    //-----

    // Carga los datos de inversionistas desde un archivo JSON
    /*
    public static Inversionista[] cargarInversionistas(String filePath) { //nombreArchivo
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath; //nombreArchivo

        try (FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, Inversionista[].class);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo inversionistas: " + e.getMessage());
            return new Inversionista[0];
        }
            */
            public static Inversionista[] cargarInversionistas(String filePath) {
                verificarDirectorio();
                String rutaArchivo = BASE_PATH + "/" + filePath;
            
                try (FileReader reader = new FileReader(rutaArchivo)) {
                    return gson.fromJson(reader, Inversionista[].class);
                } catch (IOException e) {
                    System.out.println("Error al cargar el archivo inversionistas: " + e.getMessage());
                    return new Inversionista[0];
                }

            

    }


    //testeoooooos
    /* PRIMERO FUNCIONA MENOS PARA LOS MONTOS ni TIPO INVESIONISTA
    public static void savePersona(Persona nuevaPersona, String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        // Cargar las personas existentes
        Persona[] personasExistentes = cargarPersonas(nombreArchivo);
    
        // Crear un nuevo array con tamaño incrementado
        Persona[] nuevasPersonas = new Persona[personasExistentes.length + 1];
    
        // Copiar las personas existentes al nuevo array
        System.arraycopy(personasExistentes, 0, nuevasPersonas, 0, personasExistentes.length);
    
        // Agregar la nueva persona al final del nuevo array
        nuevasPersonas[personasExistentes.length] = nuevaPersona;
    
        // Guardar el nuevo array en el archivo JSON
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(nuevasPersonas, writer);
            System.out.println("Archivo guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    */

    public static void savePersona(Persona nuevaPersona, String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
        // Cargar las personas existentes
        Persona[] personasExistentes = cargarPersonas(nombreArchivo);
    
        // Crear un nuevo array con tamaño incrementado
        Persona[] nuevasPersonas = new Persona[personasExistentes.length + 1];
    
        // Copiar las personas existentes al nuevo array
        System.arraycopy(personasExistentes, 0, nuevasPersonas, 0, personasExistentes.length);
    
        // Agregar la nueva persona al final del nuevo array
        nuevasPersonas[personasExistentes.length] = nuevaPersona;
    
        // Guardar el nuevo array en el archivo JSON
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

}
