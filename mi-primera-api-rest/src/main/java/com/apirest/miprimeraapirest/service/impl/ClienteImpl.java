package com.apirest.miprimeraapirest.service.impl;

import com.apirest.miprimeraapirest.model.dao.ClienteDao;
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
    public Cliente save(Cliente cliente) {
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

}
//Acá ya es la logica implementando el CLienteDao para poder utilizar

