package mx.edu.utez.Libros.controller;

import jakarta.validation.Valid;
import mx.edu.utez.ExamenVBO.controller.dto.PersonDto;
import mx.edu.utez.ExamenVBO.service.PersonService;
import mx.edu.utez.Libros.config.ApiResponse;
import mx.edu.utez.Libros.model.libro.LibroRepository;
import mx.edu.utez.Libros.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
@CrossOrigin(origins = {"*"})
public class LibroController {
    private final LibroService service;
    public LibroController(LibroService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        return service.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<mx.edu.utez.Libros.config.ApiResponse> register(@Valid @RequestBody LibroDto dto){
        System.out.println(dto);
        return service.save(dto.toEntity());
    }
    @GetMapping("/{id}")
    public ResponseEntity<mx.edu.utez.Libros.config.ApiResponse> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<mx.edu.utez.Libros.config.ApiResponse> update(@PathVariable Long id, @RequestBody LibroDto dto){
        return service.update(dto.toEntity(), id);
    }




}
