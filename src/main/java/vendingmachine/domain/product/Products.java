package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Products {
    private List<Product> products;
    private int cheapestPrice;
    public Products() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        cheapestPrice = Math.min(cheapestPrice, product.getPrice());
        products.add(product);
    }

    public void print() {
        for (Product product : products) {
            product.print();
        }
    }

    public Product reduce(String name) {
        List<Product> collect = products.stream()
                .filter(product -> product.hasName(name))
                .collect(Collectors.toList());
        Product product = collect.get(0);
        product.sell();
        return product;
    }

    public int getCheapestPrice() {
        return cheapestPrice;
    }

    public boolean isSoldOut() {
        for (Product product : products) {
            if (product.getCount() != 0) {
                return false;
            }
        }
        return true;
    }

}
