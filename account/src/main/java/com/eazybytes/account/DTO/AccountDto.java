package com.eazybytes.account.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name= "Account")
public class AccountDto {
    @Schema(description = "Account Number" , example = "1234567890")
    @Pattern(message = "accountNumber should have 10 digits", regexp = "[0-9]{10}")
    @NotNull(message = "accountNumber cannot be null")
    @NotEmpty(message = "accountNumber cannot be empty")
    private String accountNumber;
    @Schema(description = "Branch Address" , example = "Anantappura")

    @NotEmpty(message = "branchAddress cannot be empty")
    @NotNull(message = "branchAddress cannot be null")
    private String branchAddress;
    @Schema(description = "Account Type" , example = "Savings")
    @NotEmpty(message = "accountType cannot be empty")
    @NotNull(message = "accountType cannot be null")
    private String accountType;

}
