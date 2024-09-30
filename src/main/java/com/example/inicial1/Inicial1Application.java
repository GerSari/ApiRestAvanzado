package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.DomicilioRepository;
import com.example.inicial1.repositories.PersonaRepository;
import com.example.inicial1.services.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {
    private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

    @Autowired
    private PersonaServicesImpl personaServiceImpl;
    @Autowired
    private LocalidadServicesImpl localidadServicesImpl;
    @Autowired
    private DomicilioServicesImpl domicilioServicesImpl;
    @Autowired
    private AutorServicesImpl autorServiceImpl;


    public static void main(String[] args) {
        SpringApplication.run(Inicial1Application.class, args);

        System.out.println("Funcionando correctamente");
    }


    @Bean
    @Transactional
    CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository) {
        return args -> {

            // Creo un objeto localidad
            Localidad localidad1 = Localidad.builder()
                    .denominacion("Mendoza")
                    .build();

            // Guardo la localidad primero
            localidadServicesImpl.save(localidad1);


            // Creo un objeto persona
            Persona per1 = Persona.builder().
                    nombre("German").apellido("Sari").
                    build();

            // Creo un objeto domicilio y asigno la localidad
            Domicilio dom1 = Domicilio.builder()
                    .calle("Perito Moreno")
                    .numero(1300)
                    .localidad(localidad1)  // Usar la misma localidad ya guardada
                    .build();

            per1.setDomicilio(dom1);

            personaRepository.save(per1);

            //  segunda persona
            Persona per2 = Persona.builder()
                    .nombre("juan")
                    .apellido("Gomez")
                    .build();

            Domicilio dom2 = Domicilio.builder()
                    .calle("San Martin")
                    .numero(1000)
                    .localidad(localidad1)
                    .build();

            per2.setDomicilio(dom2);
            personaRepository.save(per2);


        };

    };

}
