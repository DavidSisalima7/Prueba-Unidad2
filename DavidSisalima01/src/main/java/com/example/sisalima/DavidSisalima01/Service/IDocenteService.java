package com.example.sisalima.DavidSisalima01.Service;

import com.example.sisalima.DavidSisalima01.Model.Docente;

import java.util.List;

public interface IDocenteService {
    public List<Docente> findAll();
    public Docente save(Docente asignatura);
    public Docente findById(Integer id);
    public void delete(Integer id);
}
