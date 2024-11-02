package controller.Dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.tda.list.LinkedList;
import models.Inversionista;
import models.ProyectoEnergia;

public class AdapterDao { //AdapterDao<T>
    //private Class<T> clazz;
    //private Gson g;

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static String BASE_PATH = "src/main/java/Data";

    
    private static void verificarDirectorio() {
        File directorio = new File(BASE_PATH);

        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println("Directorio creado: " + BASE_PATH);
        }
    }

    //sin arrayList
/*
    public static void saveProyectos(LinkedList<ProyectoEnergia> proyectos, String filePath) {
        // String json = gson.toJson(proyectos);
        // System.out.println(json);
        try (FileWriter writer = new FileWriter(filePath)){
            ArrayList<ProyectoEnergia> list = proyectos.toArrayList(); // Convertimos a ArrayList temporal
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
 
    public static void saveProyectos(LinkedList<ProyectoEnergia> proyectos, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            ProyectoEnergia[] array = proyectos.toArray(new ProyectoEnergia[proyectos.size()]);
            gson.toJson(array, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

    public static void saveProyectos(LinkedList<ProyectoEnergia> proyectos, String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(proyectos, writer);
            System.out.println("Archivo guardado en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }


    public static LinkedList<ProyectoEnergia> loadProyectos(String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        LinkedList<ProyectoEnergia> proyectos = new LinkedList<>();
        try (FileReader reader = new FileReader(filePath)) {
            ProyectoEnergia[] arrayProyectos = gson.fromJson(reader, ProyectoEnergia[].class);
            for (ProyectoEnergia proyecto : arrayProyectos) {
                proyectos.add(proyecto);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            //e.printStackTrace();
        }
        return proyectos;
    }

    public static void saveInversionistas(LinkedList<Inversionista> inversionistas, String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(inversionistas, writer);
            System.out.println("Archivo datos inversionistas guardado en: " + rutaArchivo);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error al guardar el archivo inversionistas: " + e.getMessage());
        }
    }


    public static LinkedList<Inversionista> loadInversionistas(String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        LinkedList<Inversionista> inversionistas = new LinkedList<>();
        try (FileReader reader = new FileReader(filePath)) {
            Inversionista[] arrayInversionistas = gson.fromJson(reader, Inversionista[].class);
            for (Inversionista inversionista : arrayInversionistas) {
                inversionistas.add(inversionista);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return inversionistas;
    }

    //AGREGADOS PARA PROBAR
    //     public static void saveInversionistas(LinkedList<Inversionista> inversionistas, String filePath) {
    //     try (FileWriter writer = new FileWriter(filePath)) {
    //         Inversionista[] array = inversionistas.toArray(new Inversionista[inversionistas.size()]);
    //         gson.toJson(array, writer);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public static void saveProyectos(LinkedList<ProyectoEnergia> proyectos, String filePath) {
    //     try (FileWriter writer = new FileWriter(filePath)) {
    //         ProyectoEnergia[] array = proyectos.toArray(new ProyectoEnergia[proyectos.size()]);
    //         gson.toJson(array, writer);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
