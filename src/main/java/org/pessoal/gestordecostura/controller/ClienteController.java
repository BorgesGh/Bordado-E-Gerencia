package org.pessoal.gestordecostura.controller;

import org.pessoal.gestordecostura.repository.ClienteRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    public ClienteController(ClienteRepository clienteRepository) {
    }
}
