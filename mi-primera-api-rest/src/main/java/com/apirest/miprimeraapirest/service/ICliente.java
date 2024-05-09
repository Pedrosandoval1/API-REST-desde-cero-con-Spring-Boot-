package com.apirest.miprimeraapirest.service;

import com.apirest.miprimeraapirest.model.entity.Cliente;

public interface ICliente {
    Cliente save(Cliente cliente);
    Cliente findById(Integer id);
    void delete (Cliente cliente);

    Iterable<Cliente> findAll ();


}
//Creamos una interface para poder hacer las respectivas modificaciones
//que vamos a querer hacer, si no tiene aquí registrado
//lo que vamos a utilizar, no te va a permitir utilizar
