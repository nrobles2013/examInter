package com.swagger.service.implementation;


import com.swagger.persistence.entity.Cliente;
import com.swagger.persistence.persistence.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class ClienteServiceImpl {
    @Autowired
    IClienteRepo clienteRepository;
    public Cliente findCodigoUnicoLike(String codigo){
        return clienteRepository.FindCodigoUnico(codigo);
    }


}
