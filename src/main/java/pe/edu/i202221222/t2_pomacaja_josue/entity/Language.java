package pe.edu.i202221222.t2_pomacaja_josue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;
    private String name;
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "languageId", fetch = FetchType.EAGER)
    private List<Film> films;
}
