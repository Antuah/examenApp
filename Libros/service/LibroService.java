package mx.edu.utez.Libros.service;

import mx.edu.utez.ExamenVBO.model.person.Person;
import mx.edu.utez.Libros.config.ApiResponse;
import mx.edu.utez.Libros.model.libro.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import mx.edu.utez.Libros.model.libro.LibroRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;


@Service
public class LibroService {
    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<mx.edu.utez.Libros.config.ApiResponse> findById(Long id) {
        return new ResponseEntity<>(new mx.edu.utez.Libros.config.ApiResponse(repository.findById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Transactional
    public ResponseEntity<mx.edu.utez.Libros.config.ApiResponse> update(Libro libro, Long id) {
        Optional<Libro> foundLibro = repository.findById(id);
        if (foundLibro.isPresent()) {
            libro.setId(id);
            return new ResponseEntity<>(new mx.edu.utez.Libros.config.ApiResponse(repository.save(libro), HttpStatus.OK), HttpStatus.OK);
        }
        return new ResponseEntity<>(new mx.edu.utez.Libros.config.ApiResponse(HttpStatus.BAD_REQUEST, true, "RecordNotFound"), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<mx.edu.utez.Libros.config.ApiResponse> save(Libro libro) {
        String a = String.valueOf(libro.getNombre().charAt(0));
        String b = String.valueOf(libro.getNombautor().charAt(0));
        String c = libro.getNombre().substring(0, 2);
        String d = libro.getFechapublic().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String e = libro.getIsbn().substring(0, 4);

        Random random = new Random();
        String f = String.valueOf((char) (random.nextInt(26) + 'a'));
        String g = String.valueOf(random.nextInt(10));

        libro.setFolio(a + b + c + d + e + f + g);

        Optional<Libro> foundLibro = repository.findByFolio(libro.getFolio());
        if (foundLibro.isPresent())
            return new ResponseEntity<>(new mx.edu.utez.Libros.config.ApiResponse(HttpStatus.BAD_REQUEST, true, "RecordAlreadyExist"), HttpStatus.BAD_REQUEST);
        libro = repository.saveAndFlush(libro);
        return new ResponseEntity<>(new mx.edu.utez.Libros.config.ApiResponse(repository.saveAndFlush(libro), HttpStatus.OK), HttpStatus.OK);
    }
}


