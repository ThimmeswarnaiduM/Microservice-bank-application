package com.eazybytes.Cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "ErrorResponse", description = "Error Response")
public class ErrorReponseDto {
    @Schema(description = "API Path",example = "/account")
    private String apiPath;
    @Schema(description = "Error Code",example = "500")
    private HttpStatus errorCode;
    @Schema (description = "Error Message",example = "Internal Server Error")
    private String errorMessage;
    @Schema(description = "Error Time",example = "2021-01-01T00:00:00")
    private LocalDateTime error;

}
