package com.apirest.miprimeraapirest.model.dto;
import com.apirest.miprimeraapirest.model.entity.Cliente;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

}
