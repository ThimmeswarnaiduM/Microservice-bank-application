package com.eazybytes.Loans.Mapper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "contactdetails")
public class Contactdetails {
    private String email;
    private String name;
    private String onCallSupport;
}
