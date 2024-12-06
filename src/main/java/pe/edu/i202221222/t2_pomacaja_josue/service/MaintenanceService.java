package pe.edu.i202221222.t2_pomacaja_josue.service;

import pe.edu.i202221222.t2_pomacaja_josue.dto.FilmDetailDto;
import pe.edu.i202221222.t2_pomacaja_josue.dto.FilmDto;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Film;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Language;

import java.util.List;

public interface MaintenanceService {

    List<Language> getAllLanguages();
    //CONSEGUIR TODOS LAS PELICULAS
    List<FilmDto> getAllFilms();

    FilmDetailDto findById(int i);
    void deleteFilm(int i);

    void insertFilm(FilmDetailDto filmDetailDto);

    void updateFilm(FilmDetailDto filmDetailDto);


}
