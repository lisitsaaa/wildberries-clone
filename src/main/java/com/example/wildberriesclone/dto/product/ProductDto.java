package com.example.wildberriesclone.dto.product;

import com.example.wildberriesclone.dto.productProperty.ProductPropertyDto;
import com.example.wildberriesclone.dto.user.UserInfoDto;
import com.example.wildberriesclone.entity.product.Category;
import com.example.wildberriesclone.entity.product.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private String name;
    private double price;
    private String article;
    private String description;
    private UserInfoDto seller;
    private Category category;
    private ProductStatus status;
    private List<ProductPropertyDto> productProperties;
}
