package wap;

import com.github.javafaker.Faker;
import wap.model.Product;
import wap.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestData {

    public static final List<Product> PRODUCT_LIST(){
        Faker faker = new Faker();
        Product[] products = new Product[30];
        return Arrays.stream(products)
                .map(product -> new Product(faker.commerce().productName(),faker.commerce().price())).collect(Collectors.toList());
    }

    public static final List<User> USERS_DATA = Arrays.asList(
            new User("Hisham","123"),
            new User("admin","123"),
            new User("user","123")
    );
}
