package com.swagger.presentation.controller;


import com.swagger.persistence.entity.Cliente;
import com.swagger.persistence.entity.Producto;
import com.swagger.presentation.dto.ClienteDTO;
import com.swagger.service.implementation.ClienteServiceImpl;
import com.swagger.utility.JwtRequestCli;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
@RequiredArgsConstructor

public class ClienteController {



    @Autowired
    ClienteServiceImpl clienteService;




    @PostMapping("/lista")
    public ResponseEntity<ClienteDTO> listarCliente(@RequestBody JwtRequestCli jwtclient) throws Exception {
        String aa=this.Encriptar(jwtclient.getCodigoUnico(),"");
        Cliente oCliente  =clienteService.findCodigoUnicoLike(this.Encriptar(jwtclient.getCodigoUnico(),""));
        ClienteDTO oclie=new ClienteDTO();
        oclie.setNombres(oCliente.getNombres());
        oclie.setApellidos(oCliente.getApellidos());
        oclie.setTipoDocumento(oCliente.getTipoDocumento());
        oclie.setNumeroDocumento(oCliente.getNumeroDocumento());

        for (Producto producto : oCliente.getProd()) {
            Producto newProd=new Producto();
            producto.setTipoProductos(producto.getTipoProductos());
            producto.setNombre(producto.getNombre());
            producto.setSaldo(producto.getSaldo());
            oclie.getProd().add(producto);
        }
        //Cliente oCliente  = clienteService.findCodigoUnicoLike(this.Encriptar(jwtclient.getCodigoUnico(),""));
        return new ResponseEntity<ClienteDTO>(oclie, HttpStatus.OK) ;
    }



    public SecretKeySpec CrearClave(String llave){
        try{
            byte[] cadena = llave.getBytes("UTF8");
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena,16);
            SecretKeySpec secretKeySpec=new SecretKeySpec(cadena,"AES");
            return secretKeySpec;
        }catch (Exception e){
            return null;
        }
    }

    public String Encriptar(String encriptar,String Llave){
        try{
           SecretKeySpec secret=CrearClave(Llave);
                Cipher ciper = Cipher.getInstance ("AES");
            ciper.init(Cipher.ENCRYPT_MODE,secret);
            byte [] cadena = encriptar.getBytes("UTF8");
            byte [] encriptada=ciper.doFinal(cadena);

            String cadena_encriptada= String.valueOf(Base64.getEncoder().encodeToString(encriptada));
            return  cadena_encriptada;
        }catch (Exception e){
            return "";
        }
    }

}
