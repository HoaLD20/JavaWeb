package Models.DAO;

import Models.Entities.Product;
import Models.utilize.FileUpload;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hoald
 */
public class ProductsDAO extends DBConnection {

    /**
     * Constructor
     */
    public ResultSet rs = null;

    /**
     * Constructor
     */
    public PreparedStatement pst = null;

    /**
     * Constructor
     */
    public DBConnection db;

    /**
     * Constructor
     */
    public int noOfRecords;

    Connection conn;

    /**
     * Constructor
     */
    public ProductsDAO() {
        db = new DBConnection();

        this.conn = db.getConnect();
    }

    /**
     *
     * @return all product in database
     */
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> listProducts = new ArrayList();
        String sql = "SELECT * FROM products ORDER BY pId DESC";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));
            }
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;
    }

    /**
     *
     * @param start
     * @param limit
     * @return
     */
    public ArrayList<Product> getAllProducts(int start, int limit) {
        ArrayList<Product> listProducts = new ArrayList();
        String sql = "select * from products ORDER BY pId DESC LIMIT ? , ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, start);
            pst.setInt(2, limit);
            rs = pst.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));
            }

            //get number of record in DB
            rs = conn.prepareStatement("SELECT count(*) FROM products").executeQuery();
            closeConnection();
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;
    }

    /**
     *
     * @param categoryId
     * @param start
     * @param limit
     * @return all Product By category
     */
    public List<Product> getAllProductByCategoryId(int categoryId, int start, int limit) {
        ArrayList<Product> listProducts = new ArrayList();
        try {
            pst = conn.prepareStatement("select * from products where cId=? ORDER BY pId DESC LIMIT ? , ?");
            pst.setInt(1, categoryId);
            pst.setInt(2, start);
            pst.setInt(3, limit);

            rs = pst.executeQuery();
            while (rs.next()) {
                listProducts.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));
            }
            pst = conn.prepareStatement("SELECT count(*) FROM products where cId=?");
            pst.setInt(1, categoryId);
            rs = pst.executeQuery();
            closeConnection();
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;

    }

    /**
     *
     * @return
     */
    public int getNoOfRecords() {
        return noOfRecords;
    }

    /**
     *
     * @param productId id Product
     * @return product by id
     */
    public Product getProduct(int productId) {
        Product product = new Product(); //to return value of select
        try {
            pst = conn.prepareStatement("select * from products where pId=?");
            pst.setInt(1, productId);
            rs = pst.executeQuery();
            if (rs.next()) {
                product.setpId(rs.getInt("pId"));
                product.setcId(rs.getInt("cId"));
                product.setpName(rs.getString("pName"));
                product.setpImage(rs.getString("pImage"));
                product.setpPrice(rs.getDouble("pPrice"));
                product.setpWeight(rs.getInt("pWeight"));
                product.setpDescription(rs.getString("pDescription"));
                product.setpQuantity(rs.getInt("pQuantity"));
                product.setpCreateDate(rs.getString("pCreateDate"));
//                conn.close();
                closeConnection();
                return product;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param categoryId
     * @param productId
     * @return
     */
    public ArrayList<Product> getRecommendedItem(int categoryId, int productId) {
        ArrayList<Product> getItem = new ArrayList();
        try {
            String sql = "SELECT * from products where pId <> ? and cId= ? ORDER BY pId ASC limit 6";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, productId);
            pst.setInt(2, categoryId);
            rs = pst.executeQuery();

            while (rs.next()) {
                getItem.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));

            }
            closeConnection();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return getItem;
    }

    /**
     *
     * @return
     */
    public ArrayList<Product> getLastProducts() {
        ArrayList<Product> selectLastProduct = new ArrayList();

        try {
            pst = conn.prepareStatement("select * from products ORDER BY pId DESC LIMIT 6 ");
            rs = pst.executeQuery();
            while (rs.next()) {
                selectLastProduct.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));
            }
            closeConnection();
            return selectLastProduct;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return rice of product
     */
    public double getMaxProductByPrice() {
        double highestprice = 0;

        try {
            pst = conn.prepareStatement("SELECT MAX(pPrice) AS HighestPrice FROM products");
            rs = pst.executeQuery();
            if (rs.next()) {
                highestprice = rs.getDouble("HighestPrice");
            }
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return highestprice;
    }

    /**
     *
     * @param productName name product
     * @return product by name
     */
    public ArrayList<Product> getProductByName(String productName) {
        ArrayList<Product> listProductByName = new ArrayList();
        try {
            pst = conn.prepareStatement("SELECT * FROM products WHERE pName LIKE ? ESCAPE '!'");
            productName = productName.replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            pst.setString(1, productName + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                listProductByName.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));
            }
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(listProductByName);
        return listProductByName;
    }

    /**
     *
     * @param priceStart
     * @param priceEnd
     * @return product by Start price and end price
     */
    public ArrayList<Product> getAllProductByPrice(double priceStart, double priceEnd) {
        ArrayList<Product> getAllProductByPrice = new ArrayList();

        try {
            pst = conn.prepareStatement("select * from products where  pPrice BETWEEN ? AND ?");
            pst.setDouble(1, priceStart);
            pst.setDouble(2, priceEnd);

            rs = pst.executeQuery();
            while (rs.next()) {
                getAllProductByPrice.add(new Product(rs.getInt("pId"), rs.getInt("cId"), rs.getString("pName"),
                        rs.getString("pImage"), rs.getDouble("pPrice"), rs.getInt("pWeight"),
                        rs.getString("pDescription"), rs.getInt("pQuantity"), rs.getString("pCreateDate")));
            }
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(getAllProductByPrice.size());
        return getAllProductByPrice;
    }

    /**
     *
     * @param product object of Product
     * @return true or false
     * @throws SQLException
     */
    public boolean updateProductQuantity(Product product) throws SQLException {
        int i = 0;
        PreparedStatement pst = conn.prepareStatement("update products set pQuantity=? where pId=?");
        pst.setInt(1, product.getpQuantity());
        pst.setInt(2, product.getpId());

        i = pst.executeUpdate();
        closeConnection();
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param id
     * @param path
     * @return
     */
    public boolean deleteProduct(int id, String path) {
        try {
            int i = 0;
            Product product = getProduct(id);
            boolean deleteFile = FileUpload.deleteFile(product.getpImage(), path);
            System.out.println(product.getpImage());
            if (deleteFile) {
                pst = conn.prepareStatement("DELETE FROM `products` WHERE pId=?");
                pst.setInt(1, id);
                i = pst.executeUpdate();
                closeConnection();
                if (i > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param cId
     * @param name
     * @param price
     * @param quantity
     * @param weight
     * @param img
     * @param date
     * @param discription
     * @return
     */
    public boolean addProduct(int cId, String name, double price, int quantity, int weight, String img, String date, String discription) {
        int i = 0;
        try {
            pst = conn.prepareStatement("INSERT INTO `products`(`cId`, `pName`, `pImage`, `pPrice`, `pWeight`, `pDescription`, `pQuantity`, `pCreateDate`) VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, cId);
            pst.setString(2, name);
            pst.setString(3, img);
            pst.setDouble(4, price);
            pst.setInt(5, weight);
            pst.setString(6, discription);
            pst.setInt(7, quantity);
            pst.setString(8, date);

            i = pst.executeUpdate();
            closeConnection();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param pId
     * @param cId
     * @param name
     * @param price
     * @param quantity
     * @param weight
     * @param img
     * @param date
     * @param description
     * @return
     */
    public boolean editProduct(int pId, int cId, String name, double price, int quantity, int weight, String img, String date, String description) {
        int i = 0;
        try {
            pst = conn.prepareStatement("UPDATE `products` SET `cId`=?,`pName`=?,`pImage`=?,`pPrice`=?,`pWeight`=?,`pDescription`=?,`pQuantity`=?,`pCreateDate`=? WHERE `pId`=?");
            pst.setInt(1, cId);
            pst.setString(2, name);
            pst.setString(3, img);
            pst.setDouble(4, price);
            pst.setInt(5, weight);
            pst.setString(6, description);
            pst.setInt(7, quantity);
            pst.setString(8, date);
            pst.setInt(9, pId);

            i = pst.executeUpdate();
            closeConnection();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
