package com.eazybytes.Loans.Audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("AuditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOANS_MS");
    }
}