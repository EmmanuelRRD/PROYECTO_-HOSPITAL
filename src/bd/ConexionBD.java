package bd;

import java.sql.*;

public class ConexionBD {

    static String x;
    private Connection conexion;
    private Statement stm;
    /* NOTA: es preferible utilizar PreparedStatement para evitar
                SQL INJECTION
     */

    private ResultSet resultSet;

    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/hospital";

            conexion = DriverManager.getConnection(URL, "root", "12345678");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el DRIVER");
            throw new RuntimeException(e);

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en la URL");
        }
    }

    //metodo para operaciones ABC (Altas, Bajas y Cambios)
    //(Data Manipulation Language)
    public boolean ejecutarInstruccionDML(String instruccionSQL){
        boolean res = false;
        try {
            stm = conexion.createStatement();

            if (stm.executeUpdate(instruccionSQL) >= 1)
                res=true;

        } catch (SQLException e) {
            System.out.println("Error en instrucción");
            throw new RuntimeException(e);

        }
        return res;
    }

    //metodo para consultas
    public ResultSet ejecutarConsultaSQL(String instruccionSQL){
        resultSet = null;

        try{
            stm = conexion.createStatement();
            resultSet = stm.executeQuery(instruccionSQL);
        }catch(SQLException e){
            System.out.println("Error en instruccion SQL");
        }

        return resultSet;
    }

    public static void main(String[] args) {
        new ConexionBD();
    }

}//class