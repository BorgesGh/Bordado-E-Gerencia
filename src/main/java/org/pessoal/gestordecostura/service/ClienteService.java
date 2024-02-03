package org.pessoal.gestordecostura.service;

import org.pessoal.gestordecostura.dto.ClienteRecordDTO;
import org.pessoal.gestordecostura.exceptions.MaiorDeIdadeException;
import org.pessoal.gestordecostura.model.ClienteModel;
import org.pessoal.gestordecostura.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    private ClienteModel createModel(ClienteRecordDTO clienteRecordDTO) throws MaiorDeIdadeException {
        ClienteModel clienteModel = new ClienteModel();
        if(clienteRecordDTO.idade() < 18){ // Regra de negocio qualquer
            throw new MaiorDeIdadeException();
        }
        BeanUtils.copyProperties(clienteRecordDTO,clienteModel);
        return clienteModel;
    }
    public void saveCliente(ClienteRecordDTO clienteRecordDTO) throws MaiorDeIdadeException {
        var clienteModel = createModel(clienteRecordDTO);
        clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> getAllClients(){
        return clienteRepository.findAll();
    }

}
