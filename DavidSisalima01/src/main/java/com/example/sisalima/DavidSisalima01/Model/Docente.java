package com.example.sisalima.DavidSisalima01.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="docentes")
public class Docente implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "id_docente")
    private Integer id_docente;
    @Column(name="nombre",nullable=false, length=50, unique=true)
    @NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
    @NotNull(message="No puede ser nulo")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    /*
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_asignatura", referencedColumnName ="id_asignatura")
    private Asignatura asignatura;
}
