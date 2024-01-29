package mx.edu.utez.Libros.model.libro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="libro")
@NoArgsConstructor
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String folio;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false)
    private String nombautor;
    @Column(length = 50, nullable = false)
    private String apellautor;
    @Column(length = 50, nullable = false)
    private int numpag;
    @Column(length = 50, nullable = false)
    private String categoria;
    @Column(columnDefinition = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechapublic;
    @Column(length = 50, nullable = false)
    private String isbn;

    public Libro(Long id, String folio, String nombre, String nombautor,String apellautor, int numpag, String categoria, LocalDate fechapublic, String isbn) {
        this.id = id;
        this.folio = folio;
        this.nombre = nombre;
        this.nombautor = nombautor;
        this.apellautor = apellautor;
        this.numpag = numpag;
        this.categoria = categoria;
        this.fechapublic = fechapublic;
        this.isbn = isbn;
    }
}
