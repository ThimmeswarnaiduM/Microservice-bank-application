package com.eazybytes.account.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Customer")
public class CustomerDto {
      @NotNull(message = "name cannot be null")
      @Size(min = 2, message = "name should have atleast 2 characters")
      @Schema(description = "Name of the customer",example = "John Doe")
    private String name;
      @NotNull(message = "email cannot be null")
      @Email
      @Schema(description = "Email of the customer",example = "hjv2j@example.com")
    private String email;
      @NotNull(message = "mobileNumber cannot be null")
      @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}")
      @Schema(description = "Mobile number of the customer",example = "1234567890")
    private String mobileNumber;
      @Schema(description = "Account details of the customer")
    private AccountDto accountDto;
}
