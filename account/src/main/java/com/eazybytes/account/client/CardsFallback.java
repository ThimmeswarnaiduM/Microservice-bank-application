package com.eazybytes.account.client;

import com.eazybytes.account.DTO.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient {



    @Override
    public ResponseEntity<CardsDto> getCardsDetails(String mobileNumber) {
        return null;
    }
}
