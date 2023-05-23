package org.example.test;

import org.example.datos.PersonaDAO;
import org.example.domain.Persona;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.seleccionar();
//        for (Persona persona : personas) {
//            System.out.println(persona);
//        }

        //insertando nuevo objeto
        Persona persona = new Persona("Carlos", "Marin", "correo@corre.com", "775-119-5049");
        personaDAO.insertar(persona);

        for (Persona persona1 : personas) {
            System.out.println(persona1);
        }

    }
}
