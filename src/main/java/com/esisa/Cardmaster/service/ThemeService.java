package com.esisa.Cardmaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esisa.Cardmaster.dao.ThemeRepository;
import com.esisa.Cardmaster.exception.NotFoundException;
import com.esisa.Cardmaster.models.Theme;

@Service
public class ThemeService {
	private final ThemeRepository themeRepository;

	@Autowired
	public ThemeService(ThemeRepository themeRepository) {
		super();
		this.themeRepository = themeRepository;
	}
	
	public Theme addTheme(Theme theme){
        return themeRepository.save(theme);
    }

    public Theme findThemeById(int id){
        return themeRepository.findThemeById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }

    public List<Theme> findAllThemes(){
        return themeRepository.findAll();
    }
	
    public Theme updateTheme(Theme theme){
        return  themeRepository.save(theme);
    }

    public void deleteTheme(int id){
    	themeRepository.deleteById(id);
    }
}
