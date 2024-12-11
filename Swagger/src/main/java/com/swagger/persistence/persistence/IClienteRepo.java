package com.swagger.persistence.persistence;

import com.swagger.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {


    @Query(value = "select * from cliente where codigo_unico like '%'||:codigo||'%'",nativeQuery = true)
    Cliente FindCodigoUnico(@Param("codigo") String codigo);


}
