package com.eazybytes.account.Repository;


import com.eazybytes.account.Entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<customer, Long> {
    Optional<customer> findByMobileNumber(String mobileNumber);
}

