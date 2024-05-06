package com.apirest.miprimeraapirest.model.dao;

import com.apirest.miprimeraapirest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}

//Acá se está encapsulando la logica de acceso ala base de datos.
//El objetivo principal de un DAO es proporcionar una capa de abstracción
//entre la lógica de negocio de tu aplicación (representada por los servicios) y la lógica de acceso a los datos (interactuar con la base de datos).
//Por medio de ese crudrepository, hace referencia a Cliente y el ID
//Por eso hacemos referencia a ClienteDao para poder modificar los datos
