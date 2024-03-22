package productmicro.productmicro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import productmicro.productmicro.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
    
}
