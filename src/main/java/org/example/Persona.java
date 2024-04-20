package org.example;

public class Persona {

    //Atributos de la persona.
    private int id;
    private String nombre;
    private int edad;
    private String ciudad;

    //Constructor.
    public Persona (String nombre, int edad, String ciudad, int id){
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
