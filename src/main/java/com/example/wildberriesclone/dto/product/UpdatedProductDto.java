package com.example.wildberriesclone.dto.product;

import com.example.wildberriesclone.dto.productProperty.ProductPropertyDto;
import com.example.wildberriesclone.entity.product.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UpdatedProductDto {
    private String name;
    private double price;
    private String article;
    private String description;
    private Category category;
    private List<ProductPropertyDto> productProperties;
}
