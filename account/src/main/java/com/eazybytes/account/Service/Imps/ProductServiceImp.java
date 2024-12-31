package com.eazybytes.account.Service.Imps;

import com.eazybytes.account.Entity.product;
import com.eazybytes.account.Repository.ProductRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp {
    private final ProductRespository repo;
    public List<product> getallProducts(){
        return repo.findAll();
    }

}
