package com.example.sisalima.DavidSisalima01.Service;

import com.example.sisalima.DavidSisalima01.Model.Asignatura;
import com.example.sisalima.DavidSisalima01.Repository.IAsignaturaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class IAsignaturaServiceImp implements IAsignaturaService {
    @Autowired
    private IAsignaturaDao asignaturaDao;
    @Override
    @Transactional(readOnly=true)
    public List<Asignatura> findAll() {
        return asignaturaDao.findAll();
    }

    @Override
    @Transactional
    public Asignatura save(Asignatura asignatura) {
        return asignaturaDao.save(asignatura);
    }

    @Override
    @Transactional (readOnly=true)
    public Asignatura findById(Integer id) {
        return asignaturaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        asignaturaDao.deleteById(id);
    }
}
