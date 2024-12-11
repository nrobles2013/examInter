package com.swagger.service.interfaces;



import com.swagger.persistence.entity.Cliente;

public interface IClienteService extends ICRUD<Cliente,Integer>{
    Cliente findBycodigounicoLike(String tpparticipe, String username);



}
