package pe.edu.i202221222.t2_pomacaja_josue.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language languageId;

    @OneToMany(mappedBy = "filmId", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FilmActor> filmActors;

    @OneToMany(mappedBy = "film", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FilmCategory> filmCategories;

    @OneToMany(mappedBy = "filmId", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Inventory> inventories;

}
