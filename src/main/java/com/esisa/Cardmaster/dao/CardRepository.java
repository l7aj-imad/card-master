package com.esisa.Cardmaster.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esisa.Cardmaster.models.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

	Optional<Card> findCardById(int id);

	Optional<List<Card>> findCardsByName(String name);
	
	Optional<List<Card>> findCardsByTitle(String title);
	
}
