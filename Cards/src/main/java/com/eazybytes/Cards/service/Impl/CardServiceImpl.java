package com.eazybytes.Cards.service.Impl;

import com.eazybytes.Cards.constants.CardsConstants;
import com.eazybytes.Cards.dto.CardsDto;
import com.eazybytes.Cards.entity.Cards;
import com.eazybytes.Cards.exception.CardAlreadyExistException;
import com.eazybytes.Cards.exception.ResourceNotFoundException;
import com.eazybytes.Cards.mappers.CardsMapping;
import com.eazybytes.Cards.repository.CardsRepository;
import com.eazybytes.Cards.service.iCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements iCardService {
    private final CardsRepository repo;

    @Override
    public void getCards(String mobileNumber) {
        Optional<Cards> byMobileNumber = repo.findByMobileNumber(mobileNumber);

        if (byMobileNumber.isPresent()) {
            throw new CardAlreadyExistException("Card already exist");
        }

repo.save(createNewCard(mobileNumber));
    }

    @Override
    public CardsDto getCardsDetails(String mobileNumber) {
        Cards cards = repo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber)
        );
        CardsDto cardsDto = CardsMapping.mapToDto(cards, new CardsDto());
        return cardsDto;
    }

    @Override
    public Boolean updateCards(CardsDto cardsDto) {
        Cards cards = repo.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "cardNumber", cardsDto.getCardNumber())
        );
        CardsMapping.mapToEntity(cardsDto, cards);
        repo.save(cards);
        return true;
    }

    @Override
    public void deleteCards(String mobileNumber) {
        Cards cards = repo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber)
        );
        repo.deleteById(cards.getCardId());
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }
}
