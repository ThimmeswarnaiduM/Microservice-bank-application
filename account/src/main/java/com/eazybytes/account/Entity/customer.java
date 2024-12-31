package com.eazybytes.account.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class customer extends BasicEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@TableGenerator(
        name = "customer_seq_gen",
        table = "customer_seq",
        pkColumnName = "next_val",
        valueColumnName = "next_val",
        allocationSize = 1
)
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;

}
