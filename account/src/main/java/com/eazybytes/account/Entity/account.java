package com.eazybytes.account.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity

@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class account extends BasicEntity {
    @Id
    private String accountNumber;
    private Long customerId;
    private String branchAddress;
    private String accountType;
}
