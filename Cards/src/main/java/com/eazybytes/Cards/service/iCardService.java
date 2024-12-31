package com.eazybytes.Cards.service;

import com.eazybytes.Cards.dto.CardsDto;

public interface iCardService {
    void getCards(String mobileNumber);

     CardsDto getCardsDetails(String mobileNumber);

    Boolean updateCards(CardsDto cardsDto);

    void deleteCards(String mobileNumber);
}
