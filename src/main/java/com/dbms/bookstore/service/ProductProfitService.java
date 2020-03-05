package com.dbms.bookstore.service;

import com.dbms.bookstore.model.ProductProfit;
import com.dbms.bookstore.repository.ProductProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductProfitService {
    private ProductProfitRepository productProfitRepository;

    @Autowired
    public ProductProfitService(ProductProfitRepository productProfitRepository) {
        this.productProfitRepository = productProfitRepository;
    }

    public List<ProductProfit> findAll() {
        List<Object[]> list = this.productProfitRepository.getAll();
        List<ProductProfit> productProfits = new LinkedList<>();
        for (Object[] objects : list) {
            ProductProfit productProfit = new ProductProfit();
            productProfit.setId((Integer) objects[0]);
            productProfit.setProfit((Long) objects[1]);
            productProfit.setName((String) objects[2]);
            productProfit.setStoreId((Integer) objects[3]);
            productProfits.add(productProfit);
        }
        return productProfits;
    }
}
