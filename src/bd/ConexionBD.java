package bd;

import java.sql.*;

public class ConexionBD {
    static String x;
    private Connection conexion;
    private Statement stm;


    private ResultSet resultSet;

    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/BD_Escuela_Topcios_2024";

            conexion = DriverManager.getConnection(URL, "root", "12345678");

        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en el DRIVER");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en la URL");
        }
    }
}
