package productmicro.productmicro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import productmicro.productmicro.dto.ProductRequest;
import productmicro.productmicro.dto.ProductResponse;
import productmicro.productmicro.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
   
   private final ProductService productService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void createProduct(@RequestBody ProductRequest productRequest){
          productService.createProduct(productRequest);
   }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
   public List<ProductResponse> getAllProduct(){
         return productService.getAllProduct();

   }

}
