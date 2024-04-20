package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

public class PersonaCRUD {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    //Conectar con la Base de Datos.
    public static void conexion() {
        // Cadena de conexión, contiene la información de la instalación de MongoDB
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        // Se crean las configuraciones específicas para conexión y manejo de la db
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        // Crea la conexión y establece la comunicación
        mongoClient = MongoClients.create(settings);

        // Busca la base de datos y colección, si no existe, la crea
        database = mongoClient.getDatabase("laboratorio");
        collection = database.getCollection("personas");


    }

    public static void insertarPersona() {
        //Persona 1.
        Document persona1 = new Document("nombre", "Jason")
                .append("edad", 30)
                .append("ciudad", "New York")
                .append("id", 123);

        //Persona 2.
        Document persona2 = new Document("nombre", "Beyonce")
                .append("edad", 25)
                .append("ciudad", "Cayalá")
                .append("id", 222);

        //Persona 3.
        Document persona3 = new Document("nombre", "Sinaí")
                .append("edad", 22)
                .append("ciudad", "Las Tunas")
                .append("id", 333);

        //Insertar en la colección.
        collection.insertOne(persona1);
        collection.insertOne(persona2);
        collection.insertOne(persona3);

        System.out.println("Se ha insertado correctamente.");
    }

    public static void mostrarPersonas() {
        // Realiza una búsqueda en la colección para obtener todos los documentos
        FindIterable<Document> personas = collection.find();

        // Itera sobre los documentos encontrados e imprime la información de cada persona
        for (Document persona : personas) {
            String nombre = persona.getString("nombre");
            int edad = persona.getInteger("edad");
            int id = persona.getInteger("id");
            String ciudad = persona.getString("ciudad");

            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Ciudad: " + ciudad);
        }
    }

    //Actualización de un registro.
    public static void actualizarPersona(int id, String nuevoNombre) {
        Document filtro = new Document("id", id);
        Document actualizacion = new Document("$set", new Document("nombre", nuevoNombre));
        collection.updateOne(filtro, actualizacion);
        System.out.println("Nombre Actualizado.");
    }

    //Eliminar un registro.
    public static void eliminarPersona(int id) {
        try {
            Document filtro = new Document("id", id);
            DeleteResult result = collection.deleteOne(filtro);

            if (result.getDeletedCount() > 0) {
                System.out.println("Persona con ID: " + id + " eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ninguna persona con ID: " + id + ".");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar a la persona: " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión cerrada con MongoDB.");
        }
    }
}


