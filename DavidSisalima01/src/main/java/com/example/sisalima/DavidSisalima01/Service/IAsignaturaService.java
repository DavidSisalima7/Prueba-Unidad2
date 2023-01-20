package com.example.sisalima.DavidSisalima01.Service;

import com.example.sisalima.DavidSisalima01.Model.Asignatura;

import java.util.List;

public interface IAsignaturaService {
    public List<Asignatura> findAll();
    public Asignatura save(Asignatura asignatura);
    public Asignatura findById(Integer id);
    public void delete(Integer id);
}
