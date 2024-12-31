package com.eazybytes.Cards.controller;

import com.eazybytes.Cards.constants.CardsConstants;
import com.eazybytes.Cards.dto.CardsDto;
import com.eazybytes.Cards.dto.ErrorReponseDto;
import com.eazybytes.Cards.dto.ResponseDto;
import com.eazybytes.Cards.mappers.AccountPro;
import com.eazybytes.Cards.mappers.Contactdetails;
import com.eazybytes.Cards.service.iCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
@Tag(
        name = "Curd Rest API for Account in Eazy Bank",
        description = "Curd Rest API for Account in Eazy Bank to create, update, delete and get all customers"
)
public class CardsController {

    private final iCardService service;
    private final AccountPro accountProperties;
    private final Contactdetails contactDetails;
    @Operation(
            summary = "Save  cards  details for Account in Eazy Bank ",
            description = "Rest API to get all cards for Account in Eazy Bank"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Save  cards  details for Account in Eazy Bank"
    )
    @PostMapping("/myCards")
    public ResponseEntity<ResponseDto> getCards(@RequestParam
                                                    @Valid
                                                    @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}") String mobileNumber) {
        service.getCards(mobileNumber);
        return ResponseEntity.ok(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));

    }
    @Operation(
            summary = "Get cards details for Account in Eazy Bank",
            description = "Rest API to get cards details inside Eazy Bank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get cards details for Account in Eazy Bank"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Expectation Failed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorReponseDto.class)
                    )
            )
    })
        @GetMapping("/myCardsDetails")
    public ResponseEntity<CardsDto> getCardsDetails(
            @RequestParam @Valid @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}") String mobileNumber) {

        CardsDto cardsDetails = service.getCardsDetails(mobileNumber);
            return ResponseEntity.status(HttpStatus.OK).body(cardsDetails);

        }
        @Operation(
                summary = "Update cards details for Account in Eazy Bank",
                description = "Rest API to update cards details inside Eazy Bank"
        )
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "Update cards details for Account in Eazy Bank"
                ),
                @ApiResponse(
                        responseCode = "417",
                        description = "HTTP Status Expectation Failed"
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "HTTP Status Internal Server Error"
                )

        })
        @PutMapping("/UpdateCards")
        public ResponseEntity<ResponseDto> updateCards(@RequestBody @Valid CardsDto cardsDto) {
            service.updateCards(cardsDto);
            return ResponseEntity.ok(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        @Operation(
                summary = "Delete cards details for Account in Eazy Bank",
                description = "Rest API to delete cards details inside Eazy Bank"
        )
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "Delete cards details for Account in Eazy Bank"
                ),
                @ApiResponse(
                        responseCode = "417",
                        description = "HTTP Status Expectation Failed"
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "HTTP Status Internal Server Error"
                )
        })
        @DeleteMapping("/deleteCards")
        public ResponseEntity<ResponseDto> deleteCards(@RequestParam @Valid @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}") String mobileNumber) {
            service.deleteCards(mobileNumber);
            return ResponseEntity.ok(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
    @GetMapping("/info")
    public String getInfo() {
        return "Message: " + accountProperties.getMessage() +
                ", Contact Email: " + contactDetails.getEmail() +
                ", Contact Support: " + contactDetails.getOnCallSupport();
    }


}
