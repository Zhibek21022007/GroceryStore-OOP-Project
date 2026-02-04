package database;

import com.zhkgrocerystore.management.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public void insertProduct(Product product) {

        String sql = "INSERT INTO product " +
                "(product_id, product_name, price, quantity, category) " +
                "VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getName());
            statement.setString(3, String.valueOf(product.getPrice()));
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getCategory());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("✅ Product inserted successfully!");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllProducts() {

        String sql = "SELECT * FROM product";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL PRODUCTS FROM DATABASE ---");

            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                String price = resultSet.getString("price");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Category: " + category);
                System.out.println("----------------------------");
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean updateProduct(Product product) {

        String sql = "UPDATE product SET product_name = ?, price = ?, quantity = ?, category = ? " +
                "WHERE product_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, product.getName());
            statement.setString(2, String.valueOf(product.getPrice()));
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getCategory());
            statement.setInt(5, product.getProductId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Product updated: " + product.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public Product getProductById(int productId) {

        String sql = "SELECT * FROM product WHERE product_id = ?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                double price = Double.parseDouble(rs.getString("price"));
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");

                rs.close();
                statement.close();

                return new Product(id, name, price, quantity) {
                    @Override
                    public String getProductType() {
                        return category;
                    }
                };
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }
    public boolean deleteProduct(int productId) {

        String sql = "DELETE FROM product WHERE product_id = ?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("✅ Product deleted (ID: " + productId + ")");
                return true;
            } else {
                System.out.println("⚠ No product found with ID: " + productId);
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public void searchByName(String name) {

        String sql = "SELECT * FROM product WHERE product_name ILIKE ? ORDER BY product_name";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getString("price") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getString("category")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByMinQuantity(int minQuantity) {

        String sql = "SELECT * FROM product WHERE quantity >= ? ORDER BY quantity DESC";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minQuantity);
            ResultSet resultSet = statement.executeQuery();

            boolean found = false;

            while (resultSet.next()) {
                found = true;

                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                double price = Double.parseDouble(resultSet.getString("price"));
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Price: " + price +
                                ", Quantity: " + quantity +
                                ", Category: " + category
                );
            }

            if (!found) {
                System.out.println(" No products found.");
            }

            resultSet.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(" Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


    public void searchByQuantityRange(int min, int max) {

        String sql = "SELECT * FROM product WHERE quantity BETWEEN ? AND ? ORDER BY quantity DESC";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getInt("quantity")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void updateProduct(int id, String name, double price, int quantity) {
    }
}
