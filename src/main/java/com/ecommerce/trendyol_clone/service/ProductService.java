package com.ecommerce.trendyol_clone.service;
import com.ecommerce.trendyol_clone.model.Product;
import com.ecommerce.trendyol_clone.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id,Product newProduct){

        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null){

            existingProduct.setName(newProduct.getName());
            existingProduct.setPrice(newProduct.getPrice());
            existingProduct.setStock(newProduct.getStock());

            return productRepository.save(existingProduct);
        }

        return null;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
