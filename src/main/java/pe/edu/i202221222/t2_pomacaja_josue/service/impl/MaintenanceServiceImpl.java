package pe.edu.i202221222.t2_pomacaja_josue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i202221222.t2_pomacaja_josue.dto.FilmDetailDto;
import pe.edu.i202221222.t2_pomacaja_josue.dto.FilmDto;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Film;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Language;
import pe.edu.i202221222.t2_pomacaja_josue.repository.FilmRepository;
import pe.edu.i202221222.t2_pomacaja_josue.repository.LanguageRepository;
import pe.edu.i202221222.t2_pomacaja_josue.service.MaintenanceService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    /**
     * Llamado a los repos
     */
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;


    @Override
    public List<FilmDto> getAllFilms() {
        List<FilmDto> films = new ArrayList<>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(
                    film.getFilmId(),
                    film.getTitle(),
                    film.getLanguageId().getName(),
                    film.getRentalRate());
            films.add(filmDto);
        });
        return films;
    }

    @Override
    public FilmDetailDto findById(int i) {
        Optional<Film> filmOptional = filmRepository.findById(i);
        return filmOptional.map(film -> new FilmDetailDto(film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getLanguageId().getLanguageId(),
                film.getLanguageId().getName(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate())
        ).orElse(null);
    }

    @Override
    public void deleteFilm(int i) {
        filmRepository.deleteById(i);
    }

    @Override
    public void insertFilm(FilmDetailDto filmDetailDto) {
        Film film = new Film();
        film.setTitle(filmDetailDto.title());
        film.setDescription(filmDetailDto.description());
        film.setReleaseYear(filmDetailDto.releaseYear());
        film.setRentalDuration(filmDetailDto.rentalDuration());
        film.setRentalRate(filmDetailDto.rentalRate());
        film.setLength(filmDetailDto.length());
        film.setReplacementCost(filmDetailDto.replacementCost());
        film.setRating(filmDetailDto.rating());
        film.setOriginalLanguageId(null);
        film.setLastUpdate(new Timestamp(new Date().getTime()));
        film.setSpecialFeatures(filmDetailDto.specialFeatures());
        Optional<Language> languageOptional = languageRepository.findById(filmDetailDto.languageId());
        Language languageOp = languageOptional.get();
        film.setLanguageId(languageOp);
        filmRepository.save(film);

    }

    @Override
    public void updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        Film film = optional.get();

        film.setTitle(filmDetailDto.title());
        film.setDescription(filmDetailDto.description());
        film.setReleaseYear(filmDetailDto.releaseYear());
        film.setRentalDuration(filmDetailDto.rentalDuration());
        film.setRentalRate(filmDetailDto.rentalRate());
        film.setLength(filmDetailDto.length());
        film.setReplacementCost(filmDetailDto.replacementCost());
        film.setRating(filmDetailDto.rating());
        film.setSpecialFeatures(filmDetailDto.specialFeatures());
        film.setLastUpdate(new Timestamp(new Date().getTime()));

        filmRepository.save(film);
    }

    @Override
    public List<Language> getAllLanguages() {
        List<Language>languages= (List<Language>) languageRepository.findAll();
        return languages;
    }
}
