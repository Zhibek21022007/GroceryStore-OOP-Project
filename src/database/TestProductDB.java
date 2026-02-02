package database;

import com.zhkgrocerystore.management.FreshProduct;
import com.zhkgrocerystore.management.PackagedProduct;
import com.zhkgrocerystore.management.Product;
import database.ProductDAO;

public class TestProductDB {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product p1 = new FreshProduct(
                1,
                "Milk",
                550.0,
                10,
                7
        );

        Product p2 = new FreshProduct(
                2,
                "Bread",
                300.0,
                20,
                3
        );

        Product p3 = new PackagedProduct(
                3,
                "Chips",
                450.0,
                15,
                "2026-05-10"
        );

        Product p4 = new PackagedProduct(
                4,
                "Pasta",
                700.0,
                8,
                "2026-12-01"
        );

        dao.insertProduct(p1);
        dao.insertProduct(p2);
        dao.insertProduct(p3);
        dao.insertProduct(p4);


        dao.getAllProducts();
    }
}

