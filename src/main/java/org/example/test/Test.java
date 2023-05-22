package org.example.test;

import org.example.datos.PersonaDAO;
import org.example.domain.Persona;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.seleccionar();
        for (Persona persona: personas) {
            System.out.println(persona);
        }
//
//        personas.forEach(persona -> {
//            System.out.println(persona);
//        });
    }
}
