package pe.edu.i202221222.t2_pomacaja_josue.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Language;

import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Language,Integer> {

    @Cacheable(value = "languages")
    Iterable<Language> findAll();

    @Cacheable(value = "languages", key = "#id")
    Optional<Language> findById(Integer id);
}
