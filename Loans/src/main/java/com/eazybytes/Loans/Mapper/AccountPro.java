package com.eazybytes.Loans.Mapper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "build.loans")
public class AccountPro {
    private String message;
    private String email;
    private String supportNumber;
}
