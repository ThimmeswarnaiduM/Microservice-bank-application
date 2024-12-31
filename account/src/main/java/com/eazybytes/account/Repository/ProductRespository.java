package com.eazybytes.account.Repository;

import com.eazybytes.account.Entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<product,Long> {
}
