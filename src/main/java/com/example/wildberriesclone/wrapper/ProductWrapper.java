package com.example.wildberriesclone.wrapper;

import com.example.wildberriesclone.dto.product.ProductDto;
import com.example.wildberriesclone.entity.product.Product;
import com.example.wildberriesclone.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static com.example.wildberriesclone.mapper.ProductMapper.INSTANCE;

@Component
@RequiredArgsConstructor
public class ProductWrapper {
    private final ProductService productService;

    public ProductDto save(ProductDto productDto, BindingResult bindingResult, UserDetails userDetails){
        Product savedProduct = productService.save(INSTANCE.dtoToProduct(productDto),
                bindingResult, userDetails);

        return INSTANCE.productToDto(savedProduct);
    }
}
