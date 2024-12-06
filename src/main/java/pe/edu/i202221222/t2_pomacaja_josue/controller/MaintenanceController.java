package pe.edu.i202221222.t2_pomacaja_josue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.i202221222.t2_pomacaja_josue.dto.FilmDetailDto;
import pe.edu.i202221222.t2_pomacaja_josue.dto.FilmDto;
import pe.edu.i202221222.t2_pomacaja_josue.entity.Language;
import pe.edu.i202221222.t2_pomacaja_josue.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    /**
     * Index
     */
    @GetMapping("/start")
    public String start(Model model){
        List<FilmDto> filmDtos = maintenanceService.getAllFilms();
        model.addAttribute("filmDtos",filmDtos);
        return "maintenance";
    }

    //DETALLE
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id,Model model){
        FilmDetailDto filmDetailDto = maintenanceService.findById(id);
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-detail";
    }

    //GUARDAR
    @GetMapping("/create")
    public String create(Model model){
        List<Language> languages = maintenanceService.getAllLanguages();
        Language language = new Language();
        language.getName();
        FilmDetailDto filmDetailDto = new FilmDetailDto(0,
                "",
                "",
                0,
                0,
                "",
                0,
                0.0,
                0,
                0.0,
                "",
                "",
                null);

        model.addAttribute("languages",languages);
        model.addAttribute("filmDetailDto",filmDetailDto);
        return "maintenance-create";
    }

    @PostMapping("/create-confirm")
    public String createConfirm(FilmDetailDto filmDetailDto){
        maintenanceService.insertFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    //Update
    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model){
        FilmDetailDto filmDetailDto = maintenanceService.findById(id);
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-update";
    }

    @PostMapping("/update-confirm")
    public String editConfirm(FilmDetailDto filmDetailDto) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }
}
