package pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.dto.ApiResponse;
import pdp.entity.Product;
import pdp.repository.ProductRepository;
import pdp.utils.DbConfig;

//bean + logika
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void save(Product product) {
        productRepository.saveProduct(product);
    }

    public ApiResponse delete(String model) {
        if (!productRepository.delete(model)) return new ApiResponse("xatolik", false);
        return new ApiResponse("Deleted!", true);
    }

    public ApiResponse edit(String model) {
        Product edit = productRepository.edit(model);
        return new ApiResponse("Mana", true, edit);
    }
}
