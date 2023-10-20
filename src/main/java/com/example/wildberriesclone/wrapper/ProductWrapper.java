package com.example.wildberriesclone.wrapper;

import com.example.wildberriesclone.dto.product.ProductDto;
import com.example.wildberriesclone.dto.product.ProductListDto;
import com.example.wildberriesclone.entity.product.Category;
import com.example.wildberriesclone.entity.product.Product;
import com.example.wildberriesclone.entity.product.ProductStatus;
import com.example.wildberriesclone.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

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

    public ProductDto getByArticle(String article){
        return INSTANCE.productToDto(productService.findByArticle(article));
    }

    public ProductListDto getByCategoryWithPagination(Category category, PageRequest pageRequest){
        ProductListDto productListDto = new ProductListDto();
        List<ProductDto> products = new ArrayList<>();

        productService.findByCategoryWithPagination(category, pageRequest)
                .forEach(product ->
                        products.add(
                                INSTANCE.productToDto(product)));
        productListDto.setProducts(products);
        return productListDto;
    }
    public ProductListDto getByNameWithPagination(String name, PageRequest pageRequest){
        ProductListDto productListDto = new ProductListDto();
        List<ProductDto> products = new ArrayList<>();

        productService.findByName(name, pageRequest)
                .forEach(product ->
                        products.add(
                                INSTANCE.productToDto(product)));
        productListDto.setProducts(products);
        return productListDto;
    }

    public ProductDto changeStatus(ProductStatus productStatus, long id){
        return INSTANCE.productToDto(productService.updateStatus(productStatus, id));
    }
}
