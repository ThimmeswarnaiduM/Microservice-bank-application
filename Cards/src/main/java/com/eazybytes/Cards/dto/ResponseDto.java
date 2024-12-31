package com.eazybytes.Cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Response ")
public class ResponseDto {
     @Schema(description = "Status code in the response")
    private String statusCode;
     @Schema(description = "Status message in the response")
    private String statusMsg;


}
