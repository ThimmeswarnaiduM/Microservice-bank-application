package com.eazybytes.account.Audit;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@AllArgsConstructor
@Component("AuditImp")
public class AuditImp implements AuditorAware<String> {

  

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin_ms");
    }
}
