package com.esisa.Cardmaster.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esisa.Cardmaster.models.Theme;
import com.esisa.Cardmaster.service.ThemeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/theme")
public class ThemeController {
	private final ThemeService themeService;

	public ThemeController(ThemeService themeService) {
		super();
		this.themeService = themeService;
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Theme>> getAllThemes(){
        List<Theme> users = themeService.findAllThemes();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable("id") int id){
    	Theme theme = themeService.findThemeById(id);
        return new ResponseEntity<>(theme, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Theme> addTheme(@RequestBody Theme theme){
    	Theme newTheme = themeService.addTheme(theme);
        return new ResponseEntity<>(newTheme, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Theme> updateTheme(@RequestBody Theme theme){
    	Theme updateTheme = themeService.updateTheme(theme);
        return new ResponseEntity<>(updateTheme, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Theme> deleteTheme(@PathVariable("id") int id){
    	themeService.deleteTheme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
