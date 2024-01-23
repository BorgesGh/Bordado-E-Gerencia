package org.pessoal.gestordecostura.controller;

import jakarta.validation.Valid;
import org.pessoal.gestordecostura.dto.ClienteRecordDTO;
import org.pessoal.gestordecostura.model.ClienteModel;
import org.pessoal.gestordecostura.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/clietesSave")
    public ResponseEntity<ClienteModel> salvarCLiente (@RequestBody @Valid ClienteRecordDTO clienteRecordDTO){
        var ClienteModel = new ClienteModel(); // "var" é igual ao "auto" em c++
        BeanUtils.copyProperties(clienteRecordDTO,ClienteModel); //Copiando os dados do DTO para o model
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(ClienteModel)); // Retorno para a pagina html
        //Que tudo fui criado, juntamente com o dado que foi salvo no banco de dados

    }

    @GetMapping("/clientesGet")
    public ResponseEntity<List<ClienteModel>> listarClientes (){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @PutMapping("/clientesPut/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable(value = "id") UUID id, ClienteRepository clienteRepository){
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);

        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fulano não foi encontrado");
        }

        var clienteModel = clienteO.get();
        BeanUtils.copyProperties(clienteO,clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));

    }

}
