package com.esisa.Cardmaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esisa.Cardmaster.dao.CardRepository;
import com.esisa.Cardmaster.exception.NotFoundException;
import com.esisa.Cardmaster.models.Card;


@Service
public class CardService {
	private final CardRepository cardRepository;
	
	@Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
	
	public Card addCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Card findCardById(int id){
        return cardRepository.findCardById(id)
                .orElseThrow(() -> new NotFoundException("Card by id " + id + " was not found"));
    }
	
	public List<Card> findCardsByName(String name){
        return cardRepository.findCardsByName(name)
                .orElseThrow(() -> new NotFoundException("Card by name " + name + " was not found"));
    }
	
	public List<Card> findCardsByTitle(String title){
        return cardRepository.findCardsByName(title)
                .orElseThrow(() -> new NotFoundException("Card by title " + title + " was not found"));
    }
	
	public List<Card> findAllCards(){
        return cardRepository.findAll();
    }
	
	public Card updateCard(Card card) {
		return cardRepository.save(card);
	}
	
	public void deleteCard(int id) {
		cardRepository.deleteById(id);
	}
}
