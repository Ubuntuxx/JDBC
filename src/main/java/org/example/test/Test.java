package org.example.test;

import org.example.datos.PersonaDAO;
import org.example.domain.Persona;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.seleccionar();

//        insertando nuevo objeto
//        Persona persona = new Persona("Carlos", "Marin", "correo@corre.com", "775-119-5049");
//        personaDAO.insertar(persona);

        //borrando registro
//        Persona personadelete = new Persona(1198);
//        personaDAO.borrar(personadelete);

        //editar
        Persona personEdit = new Persona(7, "Claudio", "X Gonzalez", "caludio@correo.com", "555-654-9878");
        personaDAO.editar(personEdit);

//        for (Persona persona : personas) {
//            System.out.println(persona);
//        }

    }
}
