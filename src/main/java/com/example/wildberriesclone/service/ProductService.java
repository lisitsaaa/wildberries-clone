package com.example.wildberriesclone.service;

import com.example.wildberriesclone.entity.product.Product;
import com.example.wildberriesclone.exception.ExistsException;
import com.example.wildberriesclone.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import static com.example.wildberriesclone.service.util.Validator.checkBindingResult;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    @Value("${EXISTED}") private String existed_message;

    private final ProductRepository productRepository;
    private final UserService userService;

    public Product save(Product product, BindingResult bindingResult, UserDetails userDetails){
        checkBindingResult(bindingResult);
        if (productRepository.findByArticle(product.getArticle()).isPresent()) {
            throw new ExistsException(String.format(existed_message, product.getArticle()));
        }
        product.setSeller(userService.findByUsername(userDetails.getUsername()));
        return productRepository.save(product);
    }
}
