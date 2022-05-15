package pdp.repository;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pdp.entity.Product;
import pdp.utils.DbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {


    @SneakyThrows
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = DbConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from product");

        while (resultSet.next()) {
            Product product = new Product();
            product.setMaker(resultSet.getString(1));
            product.setModel(resultSet.getString(2));
            product.setType(resultSet.getString(3));
            products.add(product);
        }
        return products;
    }

    @SneakyThrows
    public void saveProduct(Product product) {
        Connection connection = DbConfig.getConnection();
        PreparedStatement preparedStatement
                = connection.prepareStatement("insert into product values(?,?,?)");

        preparedStatement.setString(1, product.getMaker());
        preparedStatement.setString(2, product.getModel());
        preparedStatement.setString(3, product.getType());
        preparedStatement.execute();
    }

    @SneakyThrows
    public boolean delete(String model) {
        Connection connection = DbConfig.getConnection();

        PreparedStatement preparedStatement
                = connection.prepareStatement(
                "delete from product where model=?");

        preparedStatement.setString(1, model);
        boolean execute = preparedStatement.execute();
        return execute;
    }

    public Product edit(String model) {
        Product edited = null;
        for (Product product : getProducts()) {
            if (product.getModel().equals(model)) {
                edited = product;
            }
        }
        return edited;
    }
}
