package com.example.wildberriesclone.service;

import com.example.wildberriesclone.entity.product.Category;
import com.example.wildberriesclone.entity.product.Product;
import com.example.wildberriesclone.entity.product.ProductStatus;
import com.example.wildberriesclone.exception.ExistsException;
import com.example.wildberriesclone.exception.NotFoundException;
import com.example.wildberriesclone.exception.OwnerException;
import com.example.wildberriesclone.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.wildberriesclone.service.util.Validator.checkBindingResult;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    @Value("${EXISTED}") private String existed_message;
    @Value("${NOT_FOUND}") private String not_found_message;
    @Value("${NOT_YOUR_THING}") private String owner_message;

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

    public void remove(long id, UserDetails userDetails){
        Product product = findById(id);
        if (product.getSeller().getUsername().equals(userDetails.getUsername())){
            productRepository.delete(product);
        } else {
            throw new OwnerException(owner_message);
        }
    }

    public Product updateStatus(ProductStatus productStatus, long id){
        Product product = findById(id);
        product.setStatus(productStatus);
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> findByName(String name, PageRequest pageRequest){
        List<Product> productsByName = new ArrayList<>();
        for (Product product : productRepository.findAll(pageRequest).getContent()){
            if (product.getName().equals(name)) {
                productsByName.add(product);
            }
        }
        return getProductList(productsByName);
    }

    @Transactional(readOnly = true)
    public Product findByArticle(String article){
        return getCheckedProduct(productRepository.findByArticle(article));
    }

    @Transactional(readOnly = true)
    public List<Product> findByCategoryWithPagination(Category category, PageRequest pageRequest){
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : productRepository.findAll(pageRequest).getContent()){
            if (product.getCategory().equals(category)){
                productsByCategory.add(product);
            }
        }
        return getProductList(productsByCategory);
    }



    @Transactional(readOnly = true)
    public Product findById(long id){
        return getCheckedProduct(productRepository.findById(id));
    }


    private List<Product> getProductList(List<Product> products){
        if (CollectionUtils.isEmpty(products)) {
            throw new NotFoundException(not_found_message);
        }
        return products;
    }

    private Product getCheckedProduct(Optional<Product> product){
        if (product.isEmpty()) {
            throw new NotFoundException(not_found_message);
        }
        return product.get();
    }
}
