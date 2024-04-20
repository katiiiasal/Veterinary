package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogsDAO {
    // La URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/veterinary";
    // Usuario y contraseña de la base de datos
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    // Consultas SQL
    private static final String INSERT_DOG = "INSERT INTO dogs (dogsname, kind, age, height, weight, color, ownersname) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_DOGS = "SELECT * FROM dogs";
    private static final String SELECT_DOG_BY_ID = "SELECT * FROM dogs WHERE id_dog = ?";
    private static final String UPDATE_DOG = "UPDATE dogs SET dogsname=?, kind=?, age=?, height=?, weight=?, color=?, ownersname=? WHERE id_dog=?";
    private static final String DELETE_DOG = "DELETE FROM dogs WHERE id_dog=?";

    // Método para establecer una conexión con la base de datos
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para cerrar una conexión, un PreparedStatement y un ResultSet
    private void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar un perro en la base de datos
    public int insertDog(Dogs dog) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_DOG)) {
            ps.setString(1, dog.getDogsName());
            ps.setString(2, dog.getKind());
            ps.setInt(3, dog.getAge());
            ps.setDouble(4, dog.getHeight());
            ps.setDouble(5, dog.getWeight());
            ps.setString(6, dog.getColor());
            ps.setString(7, dog.getOwnersname());
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    // Método para obtener un perro por su ID
    public Dogs selectDogById(int id) {
        Dogs dog = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_DOG_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dog = new Dogs();
                    dog.setIdDog(rs.getInt("id_dog"));
                    dog.setDogsName(rs.getString("dogsname"));
                    dog.setKind(rs.getString("kind"));
                    dog.setAge(rs.getInt("age"));
                    dog.setHeight(rs.getDouble("height"));
                    dog.setWeight(rs.getDouble("weight"));
                    dog.setColor(rs.getString("color"));
                    dog.setOwnersname(rs.getString("ownersname"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dog;
    }

    
    // Método para obtener todos los perros de la base de datos
    public List<Dogs> getAllDogs() {
        List<Dogs> dogs = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_DOGS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dogs dog = new Dogs();
                dog.setIdDog(rs.getInt("id_dog"));
                dog.setDogsName(rs.getString("dogsname"));
                dog.setKind(rs.getString("kind"));
                dog.setAge(rs.getInt("age"));
                dog.setHeight(rs.getDouble("height"));
                dog.setWeight(rs.getDouble("weight"));
                dog.setColor(rs.getString("color"));
                dog.setOwnersname(rs.getString("ownersname"));
                dogs.add(dog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dogs;
    }

    // Método para actualizar un perro en la base de datos
    public int updateDog(Dogs dog, int idDog) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_DOG)) {
            ps.setString(1, dog.getDogsName());
            ps.setString(2, dog.getKind());
            ps.setInt(3, dog.getAge());
            ps.setDouble(4, dog.getHeight());
            ps.setDouble(5, dog.getWeight());
            ps.setString(6, dog.getColor());
            ps.setString(7, dog.getOwnersname());
            ps.setInt(8, idDog);
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Método para eliminar un perro de la base de datos
    public int deleteDog(int id) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_DOG)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
