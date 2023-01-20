package com.example.sisalima.DavidSisalima01.Service;

import com.example.sisalima.DavidSisalima01.Model.Docente;
import com.example.sisalima.DavidSisalima01.Repository.IDocenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class IDocenteServiceImp implements IDocenteService{

    @Autowired
    private IDocenteDao docenteDao;
    @Override
    @Transactional(readOnly=true)
    public List<Docente> findAll() {
        return docenteDao.findAll();
    }

    @Override
    @Transactional
    public Docente save(Docente asignatura) {
        return docenteDao.save(asignatura);
    }

    @Override
    @Transactional(readOnly=true)
    public Docente findById(Integer id) {
        return docenteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        docenteDao.deleteById(id);
    }
}
