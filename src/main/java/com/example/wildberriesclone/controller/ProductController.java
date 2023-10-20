package com.example.wildberriesclone.controller;

import com.example.wildberriesclone.dto.product.ProductDto;
import com.example.wildberriesclone.dto.product.ProductListDto;
import com.example.wildberriesclone.entity.product.Category;
import com.example.wildberriesclone.entity.product.ProductStatus;
import com.example.wildberriesclone.service.ProductService;
import com.example.wildberriesclone.wrapper.ProductWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
                           @AuthenticationPrincipal UserDetails userDetails) {
        return productWrapper.save(productDto, bindingResult, userDetails);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id,
                       @AuthenticationPrincipal UserDetails userDetails) {
        productService.remove(id, userDetails);
    }

    @PutMapping("/status/{ProductStatus}/{id}")
    public ProductDto changeProductStatus(@PathVariable ProductStatus ProductStatus,
                                          @PathVariable long id){
        return productWrapper.changeStatus(ProductStatus, id);
    }

    @GetMapping("/article/{article}")
    public ProductDto getByArticle(@PathVariable String article) {
        return productWrapper.getByArticle(article);
    }

    @GetMapping("/category/{category}")
    public ProductListDto getByCategoryWithPagination(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            @PathVariable Category category) {
        return productWrapper.getByCategoryWithPagination(category, PageRequest.of(page, size));
    }

    @GetMapping("/name/{name}")
    public ProductListDto getByNameWithPagination(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            @PathVariable String name) {
        return productWrapper.getByNameWithPagination(name, PageRequest.of(page, size));
    }
}
