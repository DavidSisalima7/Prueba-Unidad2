package com.example.sisalima.DavidSisalima01.Controller;
import com.example.sisalima.DavidSisalima01.Model.Asignatura;
import com.example.sisalima.DavidSisalima01.Service.IAsignaturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/asignatura")
public class ControllerAsignatura {
    @Autowired
    IAsignaturaService asignaturaService;

    /*
   @GetMapping("/listar")
   public List<Cancion>listarCancion(){
       try {
           return cancionService.findAll();
       }catch (Exception e){

       }
       return cancionService.findAll();
   }*/

    @GetMapping("/buscar/{id}")
    public Asignatura buscar(@PathVariable Integer id){
        return asignaturaService.findById(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Asignatura>> getAll() {
        try {
            return new ResponseEntity<>(asignaturaService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    /*
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cancion guardarCancion(@RequestBody Cancion cancion){
        return cancionService.save(cancion);
    }
*/
    @PostMapping("/guardar")
    public ResponseEntity<Asignatura> guardarAsig(@RequestBody Asignatura asignatura){
        try {
            return new ResponseEntity<>(asignaturaService.save(asignatura), HttpStatus.CREATED);
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
    public ResponseEntity<?> EliminarAsig(@PathVariable("id") Integer id) {
        try {
            asignaturaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR no se pudo eliminar entidad relacionada");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Asignatura> updateClient(@RequestBody Asignatura asig, @PathVariable("id") Integer id){
        Asignatura canUp = asignaturaService.findById(id);

        if(canUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                Asignatura asignatura=asignaturaService.findById(id);
                asignatura.setNombre(asig.getNombre());
                asignatura.setCarrera(asig.getCarrera());
                asignatura.setHora_ini(asig.getHora_ini());
                asignatura.setHora_fin(asig.getHora_fin());
                return new ResponseEntity<>(asignaturaService.save(asignatura), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
