package com.example.inicial1.controllers;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.services.LibroServicesImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServicesImpl>{

}
