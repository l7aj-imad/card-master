package com.esisa.Cardmaster.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esisa.Cardmaster.models.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {

	Optional<Theme> findThemeById(int id);
}
