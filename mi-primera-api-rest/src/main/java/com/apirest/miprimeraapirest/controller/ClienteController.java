package com.apirest.miprimeraapirest.controller;

import com.apirest.miprimeraapirest.model.entity.Cliente;
import com.apirest.miprimeraapirest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;
    Map<String, Object> response = new HashMap<>();
    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        try{
            Cliente clienteCreate = clienteService.save(cliente);
            return new ResponseEntity<>(clienteCreate, HttpStatus.CREATED);
        }catch(DataAccessException exDt){
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("cliente")
    public ResponseEntity<?> update( @RequestBody Cliente cliente){
        try{
            Cliente clienteCreated = clienteService.save(cliente);
            return new ResponseEntity<>(clienteCreated, HttpStatus.CREATED);
        }catch (DataAccessException exDt){
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        // @PathVariable("id") para utilizar el path Variable se tiene que nombrar a la variable;
        // también se puede utilziar el @RequestParam
        try{
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        }catch(DataAccessException exDt){
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("cliente/{id}")
    public Cliente showById(@PathVariable("id") Integer id){
        return clienteService.findById(id);
    }

    @GetMapping("cliente")
    public Iterable<Cliente> findAll(){
        try{
            Iterable<Cliente> clienteFindAll =  clienteService.findAll();
            return new ResponseEntity<>(clienteFindAll, HttpStatus.OK).getBody();
        }catch(DataAccessException exDt){
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return (Iterable<Cliente>) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR).getBody();
        }

    }
}
