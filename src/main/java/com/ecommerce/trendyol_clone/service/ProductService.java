package com.ecommerce.trendyol_clone.service;
import com.ecommerce.trendyol_clone.dto.ProductDto;
import com.ecommerce.trendyol_clone.model.Product;
import com.ecommerce.trendyol_clone.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;



    public ProductService(ProductRepository productRepository,ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public ProductDto getProductDtoById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product could not found!"));

       ProductDto productDto = modelMapper.map(product,ProductDto.class);

        return productDto;
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

    public List<Product> getProductsByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> searchProducts(String keyword){
        return productRepository.findByNameContaining(keyword);
    }
    public List<Product>  getAllProductSorted(String sortBy,String direction){

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return productRepository.findAll(sort);
    }
    // int page : which page are you in
    // int size : how many product in a page
    public Page<Product> getAllProductsWithPagination(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        return productRepository.findAll(pageable);
    }
}
