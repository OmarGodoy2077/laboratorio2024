package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //LLamar a la conexión.
        PersonaCRUD.conexion();

        //Llamar al ingreso de documentos.
        //PersonaCRUD.insertarPersona();

        //Llamar a la función de actualización de personas.
        //PersonaCRUD.actualizarPersona(123, "Anthony");

        //Llamar a la función de eliminar una persona.
        PersonaCRUD.eliminarPersona(222);

    //Llamar a la función para mostrar personas.
    PersonaCRUD.mostrarPersonas();

    //Llamar a la función cerrar conexión.
        //PersonaCRUD.cerrarConexion();

    }
}