package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatsDAO {
    private final String url = "jdbc:mysql://localhost:3306/veterinary";
    private final String user = "root";
    private final String password = "toor";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int addCat(Cats cat) {
        String sql = "INSERT INTO cats (catsname, kind, age, height, weight, color, ownersname) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cat.getCatsName());
            pstmt.setString(2, cat.getKind());
            pstmt.setInt(3, cat.getAge());
            pstmt.setDouble(4, cat.getHeight());
            pstmt.setDouble(5, cat.getWeight());
            pstmt.setString(6, cat.getColor());
            pstmt.setString(7, cat.getOwnersname());
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public Cats getCatById(int idCat) {
        String sql = "SELECT * FROM cats WHERE id_cat = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCat);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Cats cat = new Cats();
                    cat.setIdCat(rs.getInt("id_cat"));
                    cat.setCatsName(rs.getString("catsname"));
                    cat.setKind(rs.getString("kind"));
                    cat.setAge(rs.getInt("age"));
                    cat.setHeight(rs.getDouble("height"));
                    cat.setWeight(rs.getDouble("weight"));
                    cat.setColor(rs.getString("color"));
                    cat.setOwnersname(rs.getString("ownersname"));
                    return cat;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public List<Cats> getAllCats() {
        List<Cats> catsList = new ArrayList<>();
        String sql = "SELECT * FROM cats";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cats cat = new Cats();
                cat.setIdCat(rs.getInt("id_cat"));
                cat.setCatsName(rs.getString("catsname"));
                cat.setKind(rs.getString("kind"));
                cat.setAge(rs.getInt("age"));
                cat.setHeight(rs.getDouble("height"));
                cat.setWeight(rs.getDouble("weight"));
                cat.setColor(rs.getString("color"));
                cat.setOwnersname(rs.getString("ownersname"));
                catsList.add(cat);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return catsList;
    }

    public int updateCat(Cats cat, int idCat) {
        String sql = "UPDATE cats SET catsname = ?, kind = ?, age = ?, height = ?, weight = ?, color = ?, ownersname = ? WHERE id_cat = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cat.getCatsName());
            pstmt.setString(2, cat.getKind());
            pstmt.setInt(3, cat.getAge());
            pstmt.setDouble(4, cat.getHeight());
            pstmt.setDouble(5, cat.getWeight());
            pstmt.setString(6, cat.getColor());
            pstmt.setString(7, cat.getOwnersname());
            pstmt.setInt(8, idCat);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int deleteCat(int idCat) {
        String sql = "DELETE FROM cats WHERE id_cat = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCat);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    
}
