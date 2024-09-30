package com.example.inicial1.controllers;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.services.AutorServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autor")
public abstract class AutorController extends BaseControllerImpl<Autor, AutorServicesImpl>{

    public AutorController() {
    }
}
