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
            return ResponseEntity.ok(clienteCreate);
        }catch(DataAccessException exDt){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al Crear el cliente: "+ exDt.getMessage());
        }
    }

    @PutMapping("cliente")
    public ResponseEntity<?> update( @RequestBody Cliente cliente){
        try{
            Cliente clienteCreated = clienteService.save(cliente);
            return  ResponseEntity.ok(clienteCreated);
        }catch (DataAccessException exDt){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al Actualizar el cliente: "+ exDt.getMessage());
        }
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            Cliente cliente = clienteService.findById(id);
            clienteService.delete(cliente);
            return ResponseEntity.noContent().build();
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el cliente: " + ex.getMessage());
        }
    }


    @GetMapping("cliente/{id}")
    public Cliente showById(@PathVariable("id") Integer id){
        return clienteService.findById(id);
    }

        @GetMapping("clientes")
        public ResponseEntity<?> findAll() {
            try {
                Iterable<Cliente> clientes = clienteService.findAll();
                return ResponseEntity.ok(clientes);
            } catch (DataAccessException ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al recuperar los clientes: " + ex.getMessage());
            }
        }
    }
