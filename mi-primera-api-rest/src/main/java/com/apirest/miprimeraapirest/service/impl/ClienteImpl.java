package com.apirest.miprimeraapirest.service.impl;

import com.apirest.miprimeraapirest.model.dao.ClienteDao;
import com.apirest.miprimeraapirest.model.dto.ClienteDto;
import com.apirest.miprimeraapirest.model.entity.Cliente;
import com.apirest.miprimeraapirest.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteDao clienteDao;

    //solo es para una consulta, osea que no se va a hacer modificaciones
    @Transactional()
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .fechaRegistro(clienteDto.getFechaRegistro()).build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional()
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Transactional()
    @Override
    public Iterable<Cliente> findAll() {
        return clienteDao.findAll();
    }

}
//Acá ya es la logica implementando el CLienteDao para poder utilizar

