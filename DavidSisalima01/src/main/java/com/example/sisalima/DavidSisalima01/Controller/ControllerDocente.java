package com.example.sisalima.DavidSisalima01.Controller;

import com.example.sisalima.DavidSisalima01.Model.Docente;
import com.example.sisalima.DavidSisalima01.Service.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/docente")
public class ControllerDocente {
    @Autowired
    IDocenteService docenteService;
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarDocente(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(docenteService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    @GetMapping("/buscar/{id}")
    public Docente buscarDocente(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(docenteService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return docenteService.findById(id);
    }
    */

    @GetMapping("/listar")
    public ResponseEntity<List<Docente>> getAll() {
        try {
            return new ResponseEntity<>(docenteService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/guardar")
    public ResponseEntity<Docente> guardarDocente(@RequestBody Docente docente){
        try {
            return new ResponseEntity<>(docenteService.save(docente), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    /*
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable Integer id){
        cancionService.delete(id);
    }
*/
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> EliminarDocente(@PathVariable("id") Integer id) {
        try {
            docenteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR no se pudo eliminar entidad relacionada");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Docente> updateClient(@RequestBody Docente docente, @PathVariable("id") Integer id){
        Docente canUp = docenteService.findById(id);

        if(canUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                Docente doc=docenteService.findById(id);
                doc.setCelular(docente.getCelular());
                doc.setApellido(docente.getApellido());
                doc.setEmail(docente.getEmail());
                return new ResponseEntity<>(docenteService.save(doc), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}

