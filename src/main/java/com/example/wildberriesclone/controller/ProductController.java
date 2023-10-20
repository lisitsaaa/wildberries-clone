package com.example.wildberriesclone.controller;

import com.example.wildberriesclone.dto.product.ProductDto;
import com.example.wildberriesclone.service.ProductService;
import com.example.wildberriesclone.wrapper.ProductWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@PreAuthorize("hasAnyRole('SELLER', 'ADMIN')")
@RequiredArgsConstructor
public class ProductController {
    private final ProductWrapper productWrapper;
    private final ProductService productService;

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto,
                           BindingResult bindingResult,
                           @AuthenticationPrincipal UserDetails userDetails){
        return productWrapper.save(productDto, bindingResult, userDetails);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id,
                       @AuthenticationPrincipal UserDetails userDetails){
        productService.remove(id, userDetails);
    }
}
