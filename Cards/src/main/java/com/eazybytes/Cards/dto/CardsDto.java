package com.eazybytes.Cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Cards")
public class CardsDto {
    @NotNull(message = "mobileNumber cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "mobileNumber should have 10 digits")
    @NotEmpty(message = "mobileNumber cannot be empty")
    @Schema(description = "Mobile number of the customer",example = "1234567890")
    private String mobileNumber;
    @NotNull(message = "cardType cannot be null")
    @NotEmpty(message = "cardType cannot be empty")
    @Schema(description = "Type of the card",example = "Visa")
    private String cardType;
    @NotNull(message = "cardNumber cannot be null")
    @NotEmpty(message = "cardNumber cannot be empty")
    @Schema(description = "Card number of the customer",example = "1234567890")
    private String cardNumber;
    @NotNull(message = "totalLimit cannot be null")
    @NotNull(message = "totalLimit cannot be empty")
    @Schema(description = "Total limit of the card",example = "100000")
    private int totalLimit;
    @NotNull(message = "amountUsed cannot be null")
    @NotNull(message = "amountUsed cannot be empty")
    @Schema(description = "Amount used in the card",example = "10000")
    private int amountUsed;
    @NotNull(message = "availableAmount cannot be null")
    @NotNull(message = "availableAmount cannot be empty")
    @Schema(description = "Available amount in the card",example = "90000")
    private int availableAmount;
}
