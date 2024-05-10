package com.apirest.miprimeraapirest.controller;

import com.apirest.miprimeraapirest.model.dto.ClienteDto;
import com.apirest.miprimeraapirest.model.entity.Cliente;
import com.apirest.miprimeraapirest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;
    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        try{
            Cliente clienteCreate = clienteService.save(clienteDto);
            Cliente getClienteData = Cliente.builder()
                    .idCliente(clienteCreate.getIdCliente())
                    .nombre(clienteCreate.getNombre())
                    .apellido(clienteCreate.getApellido())
                    .correo(clienteCreate.getCorreo())
                    .fechaRegistro(clienteCreate.getFechaRegistro())
                    .build();
            return ResponseEntity.ok(getClienteData);
        }catch(DataAccessException exDt){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al Crear el cliente: "+ exDt.getMessage());
        }
    }

    @PutMapping("cliente")
    public ResponseEntity<?> update( @RequestBody ClienteDto cliente){
        try{
            Cliente clienteUpdate = clienteService.save(cliente);
            Cliente getClienteData = Cliente.builder()
                    .idCliente(clienteUpdate.getIdCliente())
                    .nombre(clienteUpdate.getNombre())
                    .apellido(clienteUpdate.getApellido())
                    .correo(clienteUpdate.getCorreo())
                    .fechaRegistro(clienteUpdate.getFechaRegistro()).build();

            return  ResponseEntity.ok(getClienteData);
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
    public ResponseEntity<?> showById(@PathVariable("id") Integer id){
        try {

            Cliente clienteShowById = clienteService.findById(id);
            Cliente getClienteData = Cliente.builder()
                    .idCliente(clienteShowById.getIdCliente())
                    .nombre(clienteShowById.getNombre())
                    .apellido(clienteShowById.getApellido())
                    .correo(clienteShowById.getCorreo())
                    .fechaRegistro(clienteShowById.getFechaRegistro()).build();
            return ResponseEntity.ok(getClienteData);
        }catch(DataAccessException ex){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Error al recuperar al cliente: + " + ex.getMessage());
        }

    }

        @GetMapping("clientes")
        public ResponseEntity<?> findAll() {
            try {
                Iterable<Cliente> clientes = clienteService.findAll();
                return ResponseEntity.ok(clientes);
            } catch (DataAccessException ex) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("Error al recuperar los clientes: " + ex.getMessage());
            }
        }
    }
