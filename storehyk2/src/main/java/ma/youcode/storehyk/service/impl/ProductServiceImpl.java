package ma.youcode.storehyk.service.impl;

import ma.youcode.storehyk.model.Product;
import ma.youcode.storehyk.repository.ProductRepository;
import ma.youcode.storehyk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    //Injection de dépendances Framework Spring
    //L'autowiring laisse le conteneur déterminer automatiquement l'objet géré par le conteneur qui sera injecté comme dépendance d'un autre objet.
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }//findAll

    public void updateProduct(Product product) {
        productRepository.save(product);
    }//add or update

    public void removeProductById(long id) {
        productRepository.deleteById(id);
    }//delete

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }//search by id

    public List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
    //findList by ProductDTO.categoryId

}
