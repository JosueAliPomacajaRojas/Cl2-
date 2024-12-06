package pe.edu.i202221222.t2_pomacaja_josue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private Timestamp lastUpdate;
}
