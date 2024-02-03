package org.pessoal.gestordecostura.controller;

import jakarta.validation.Valid;
import org.pessoal.gestordecostura.dto.ClienteRecordDTO;
import org.pessoal.gestordecostura.exceptions.MaiorDeIdadeException;
import org.pessoal.gestordecostura.model.ClienteModel;
import org.pessoal.gestordecostura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/clientesSave")
    public ResponseEntity<String> salvarCLiente (@RequestBody @Valid ClienteRecordDTO clienteRecordDTO){
        try {
            clienteService.saveCliente(clienteRecordDTO);

        }catch (MaiorDeIdadeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente salvo com sucesso!"); // Retorno para a pagina html
        //Que tudo fui criado, juntamente com o dado que foi salvo no banco de dados

    }

    @GetMapping("/clientesGet")
    public ResponseEntity<List<ClienteModel>> listarClientes (){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAllClients());
    }


}
