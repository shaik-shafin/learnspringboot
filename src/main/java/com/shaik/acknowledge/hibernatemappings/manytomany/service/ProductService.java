package com.shaik.acknowledge.hibernatemappings.manytomany.service;

import com.shaik.acknowledge.hibernatemappings.manytomany.domain.Product;
import com.shaik.acknowledge.hibernatemappings.manytomany.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() { return productRepository.findAll(); }

    public Product getProductById(Integer id) { return productRepository.findById(id).get(); }

    public Product saveProduct(Product product) { return productRepository.save(product); }

    public void deleteProduct(Integer id) { productRepository.deleteById(id); }
}
