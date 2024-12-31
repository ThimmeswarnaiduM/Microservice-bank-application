package com.eazybytes.account.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(name = "Error Response")
public class ErrorResponseDto {
    @Schema(description = "API Path",example = "/account")
private String apiPath;
    @Schema(description = "Error Code",example = "500")
private HttpStatus errorCode;
    @Schema
private String errorMessage;
    @Schema(description = "Error Time",example = "2021-01-01T00:00:00")
private LocalDateTime error;

    public ErrorResponseDto() {

    }
}
