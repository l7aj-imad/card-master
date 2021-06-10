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

import com.esisa.Cardmaster.models.Card;
import com.esisa.Cardmaster.service.CardService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/card")
public class CardController {
	private final CardService cardService;

	public CardController(CardService cardService) {
		super();
		this.cardService = cardService;
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.findAllCards();
        return  new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable("id") int id){
        Card Card = cardService.findCardById(id);
        return new ResponseEntity<>(Card, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody Card Card){
        Card newCard = cardService.addCard(Card);
        return new ResponseEntity<>(newCard, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Card> updateCard(@RequestBody Card Card){
        Card updateCard = cardService.updateCard(Card);
        return new ResponseEntity<>(updateCard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Card> deleteCard(@PathVariable("id") int id){
        cardService.deleteCard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
