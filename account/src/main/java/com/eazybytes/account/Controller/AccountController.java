package com.eazybytes.account.Controller;




import com.eazybytes.account.Config.AccountPro;
import com.eazybytes.account.Config.Contactdetails;
import com.eazybytes.account.Constants.AccountConstant;
import com.eazybytes.account.DTO.CustomerDto;
import com.eazybytes.account.DTO.ErrorResponseDto;

import com.eazybytes.account.DTO.ResponseDto;
import com.eazybytes.account.Service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
@Tag(
    name = "Curd Rest API for Account in Eazy Bank",
    description = "Curd Rest API for Account in Eazy Bank to create, update, delete and get all customers"
)

public class AccountController {
    private final AccountPro accountProperties;
    private final Contactdetails contactDetails;
    private final IAccountService accountService;
    @Operation(
            summary = "Create account for Account in Eazy Bank",
            description = "Rest API to create Customer and Account inside Eazy Bank"
    )
    @ApiResponse(
            responseCode = "201",
            description = " HTTP Status Created"
    )
    @PostMapping( "/register")
    public ResponseEntity<ResponseDto> register(@Valid  @RequestBody CustomerDto dto) {

        accountService.createAccount(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstant.STATUS_201,
                AccountConstant.MESSAGE_201));

    }
    @Operation(
            summary = "Get Customer Details for Account in Eazy Bank",
            description = "Rest API to get Customer Details inside Eazy Bank"

    )
    @ApiResponse(
            responseCode = "200",
            description = " HTTP Status OK"
    )
    @GetMapping("/getCustomerDetails")
    public ResponseEntity<CustomerDto> getCustomerDetails(@RequestParam   @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}") String mobileNumber) {
        CustomerDto customerDetails = accountService.getCustomerDetails(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDetails);

    }
    @Operation(
            summary = "Update Account for Account in Eazy Bank",
            description = "Rest API to update Customer and Account inside Eazy Bank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = " HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = " HTTP Status Expectation Failed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)

                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = " HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)

                    )
            )


    })
    @PutMapping("/updateAccount")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto dto) {
        boolean updateAccount = accountService.updateAccount(dto);

        if (updateAccount) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,
                    AccountConstant.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountConstant.STATUS_417,
                    AccountConstant.MESSAGE_417_Update));
        }
    }
    @Operation(
            summary = "Delete Account for Account in Eazy Bank",
            description = "Rest API to delete Customer and Account inside Eazy Bank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = " HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = " HTTP Status Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = " HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)

                    )
            )

    })
    @DeleteMapping("/deleteAccount")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam   @Pattern(message = "mobileNumber should have 10 digits", regexp = "[0-9]{10}") String mobileNumber) {
        boolean deleteAccount = accountService.deleteAccount(mobileNumber);

        if (deleteAccount) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,
                    AccountConstant.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountConstant.STATUS_417,
                    AccountConstant.MESSAGE_417_Delete));
        }
    }
    @GetMapping("/info")
    public String getInfo() {
        return "Message: " + accountProperties.getMessage() +

                ", Contact Email: " + contactDetails.getEmail() +
                ", Contact Support: " + contactDetails.getOnCallSupport();
    }

    @GetMapping("/allCustomers")

    public ResponseEntity<ResponseDto> getAllCustomers() {

        List allCustomers = accountService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200 + allCustomers));}
}
