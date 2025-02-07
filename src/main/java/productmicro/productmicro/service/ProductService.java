package productmicro.productmicro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import productmicro.productmicro.dto.ProductRequest;
import productmicro.productmicro.dto.ProductResponse;
import productmicro.productmicro.model.Product;
import productmicro.productmicro.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product =Product.builder()
        .name(productRequest.getName())
        .description(productRequest.getDescription())
        .price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProduct() {
       List<Product> products=productRepository.findAll();
      return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
       return ProductResponse.builder()
              .id(product.getId())
              .name(product.getName())
              .description(product.getDescription())
              .price(product.getPrice())
              .build();
    }
    
    
}
