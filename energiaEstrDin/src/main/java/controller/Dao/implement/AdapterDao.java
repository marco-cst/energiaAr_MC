package controller.Dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.tda.list.LinkedList;
import controller.tda.list.Node;
import controller.tda.list.SerializableLinkedList;
import models.Inversionista;
import models.ProyectoEnergia;

public class AdapterDao {

    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    private static String BASE_PATH = "src/main/java/Data";

    private static void verificarDirectorio() {
        File directorio = new File(BASE_PATH);

        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println("Directorio creado: " + BASE_PATH);
        }
    }

    public static void saveProyectos(LinkedList<ProyectoEnergia> proyectos, String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        LinkedList<ProyectoEnergia> proyectosExistentes = cargarProyectos(filePath);

        Node<ProyectoEnergia> current = proyectos.getHeader();
        while (current != null) {
            proyectosExistentes.add(current.getInfo());
            current = current.getNext();
        }

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            SerializableLinkedList<ProyectoEnergia> serializableList = new SerializableLinkedList<>(proyectosExistentes);
            gson.toJson(serializableList.getElements(), writer);
            System.out.println("Archivo datos proyectos guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo proyectos: " + e.getMessage());
        }
    }

    public static LinkedList<ProyectoEnergia> cargarProyectos(String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;
    
        LinkedList<ProyectoEnergia> proyectos = new LinkedList<>();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            ProyectoEnergia[] arrayProyectos = gson.fromJson(reader, ProyectoEnergia[].class);
            for (ProyectoEnergia proyecto : arrayProyectos) {
                proyectos.add(proyecto);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return proyectos;
    }


    public static void saveInversionistas(LinkedList<Inversionista> inversionistas, String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        LinkedList<Inversionista> inversionistasExistentes = cargarInversionistas(filePath);
        Node<Inversionista> current = inversionistas.getHeader();
        while (current != null) {
            inversionistasExistentes.add(current.getInfo());
            current = current.getNext();
        }

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            SerializableLinkedList<Inversionista> serializableList = new SerializableLinkedList<>(inversionistasExistentes);
            gson.toJson(serializableList.getElements(), writer);
            System.out.println("Archivo datos inversionistas guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo inversionistas: " + e.getMessage());
        }
    }

    public static LinkedList<Inversionista> cargarInversionistas(String filePath) {
        verificarDirectorio();
        String rutaArchivo = BASE_PATH + "/" + filePath;

        LinkedList<Inversionista> inversionistas = new LinkedList<>(); //new LinkedList<>()
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Inversionista[] arrayInversionistas = gson.fromJson(reader, Inversionista[].class);
            for (Inversionista inversionista : arrayInversionistas) {
                inversionistas.add(inversionista);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return inversionistas;
    }


}

