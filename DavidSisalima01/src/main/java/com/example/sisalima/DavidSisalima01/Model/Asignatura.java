package com.example.sisalima.DavidSisalima01.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="asignatura")
public class Asignatura implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_asignatura")
    private Integer id_asignatura;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "hora_ini")
    private String hora_ini;
    @Column(name = "hora_fin")
    private String hora_fin;

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_docente", referencedColumnName ="id_docente")
    private Docente docente;
    */
    @JsonIgnore
    @OneToMany(mappedBy = "asignatura")
    private List<Docente> docenteList;
}
