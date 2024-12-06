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
public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film filmId;

    private Timestamp lastUpdate;
}
