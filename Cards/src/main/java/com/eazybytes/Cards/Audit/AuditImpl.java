package com.eazybytes.Cards.Audit;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@AllArgsConstructor
@Component("AuditImpl")
public class AuditImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("cards_ms");
    }
}
