package com.apirest.miprimeraapirest.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "clientes")
public class Cliente  implements Serializable {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idCliente;

    @Column(name = "nombre")
     private String nombre;

    @Column(name = "apellido")
     private String apellido;

    @Column(name = "correo")
     private String correo;


    @Column(name = "fechaRegistro")
     private Date fechaRegistro;
}

