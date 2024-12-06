package pe.edu.i202221222.t2_pomacaja_josue.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Film;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film,Integer> {
    @Cacheable(value = "films")
    Iterable<Film> findAll();

    @CacheEvict(value = "films",allEntries = true)
    Film save(Film film);

    @Cacheable(value = "films", key = "#id")
    Optional<Film> findById(Integer id);

    @CacheEvict(value = "films",allEntries = true)
    void deleteById(Integer id);
}
