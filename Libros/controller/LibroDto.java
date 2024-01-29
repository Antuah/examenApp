package mx.edu.utez.Libros.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Libros.model.libro.Libro;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class LibroDto {
    private Long id;
    private String folio;
    private String nombre;
    private String nombautor;
    private String apellautor;
    private int numpag;
    private String categoria;
    private LocalDate fechapublic;
    private String isbn;

    public Libro toEntity(){
        return new Libro(id, folio, nombre, nombautor, apellautor, numpag, categoria, fechapublic, isbn);
    }

    @Override
    public String toString() {
        return "LibroDto{" +
                "id=" + id +
                ", folio='" + folio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nombautor='" + nombautor + '\'' +
                ", apellautor='" + apellautor + '\'' +
                ", numpag=" + numpag +
                ", categoria='" + categoria + '\'' +
                ", fechapublic=" + fechapublic +'\''+
                ", isbn=" + isbn +
                '}';
    }
}
