package com.eazybytes.Cards.mappers;

import com.eazybytes.Cards.dto.CardsDto;
import com.eazybytes.Cards.entity.Cards;

public class CardsMapping
{
    public static CardsDto mapToDto(Cards cards, CardsDto cardsDto){

        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        return cardsDto;
    }
    public static Cards mapToEntity(CardsDto cardsDto, Cards cards){

        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        return cards;
    }
}
