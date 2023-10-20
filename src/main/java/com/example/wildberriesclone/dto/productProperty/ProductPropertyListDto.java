package com.example.wildberriesclone.dto.productProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProductPropertyListDto {
    private List<ProductPropertyDto> productProperties;
}
