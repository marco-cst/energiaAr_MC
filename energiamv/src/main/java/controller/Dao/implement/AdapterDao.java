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

        public static void savePersona(Persona persona, String nombreArchivo) {
            verificarDirectorio();
            String rutaArchivo = BASE_PATH + "/" + nombreArchivo;
    
            try (FileWriter writer = new FileWriter(rutaArchivo)) {
                gson.toJson(persona, writer);
                System.out.println("Archivo guardado en: " + rutaArchivo);
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo: " + e.getMessage());
            }
        }


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

    public static void saveInversionistas(Inversionista[] inversionistas, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(inversionistas, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar los inversionistas: " + e.getMessage());
        }
    }

    // Carga los datos de inversionistas desde un archivo JSON
    public static Inversionista[] cargarInversionistas(String nombreArchivo) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + nombreArchivo;

        try (FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, Inversionista[].class);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo inversionistas: " + e.getMessage());
            return new Inversionista[0];
        }

    }

}
