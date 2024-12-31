package com.eazybytes.account.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.transaction.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Response")
public class ResponseDto  {
    @Schema(description = "Status code of the API",example = "200")
    private String stringCode;
    @Schema(description = "Status message of the API",example = "OK")
    private String statusMsg;

}
