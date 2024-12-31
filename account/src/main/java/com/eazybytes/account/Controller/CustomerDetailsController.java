package com.eazybytes.account.Controller;

import com.eazybytes.account.DTO.CustomerDetailsDto;
import com.eazybytes.account.DTO.ErrorResponseDto;
import com.eazybytes.account.Service.ICustomerDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Validated
@Tag(
      name = "Rest API for customer details in Eazy Bank",
        description = "Rest API for customer details in Eazy Bank to create, update, delete and get all customers"
)
public class CustomerDetailsController {

     private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class.getName());
    private final ICustomerDetails customerDetails;

    @Operation(
            summary = "Get customer details",
            description = "Get customer details by mobile number"
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Get customer details"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Expectation Failed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/customers")
    public ResponseEntity<CustomerDetailsDto>fetchCustomerDetail(
                                                                     @RequestParam @Valid
                                                                      @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}") String mobileNumber) {


        CustomerDetailsDto customerDetailsDto = customerDetails.fetchCustomerDetails(mobileNumber);

        return ResponseEntity.status(200).body(customerDetailsDto);
    }

}
