package bd;

import java.sql.*;

public class ConexionBD {
    private PreparedStatement pstmt;
    private Connection conexion;
    private Statement stm;
    /* NOTA: es preferible utilizar PreparedStatement para evitar
                SQL INJECTION
     */

    private ResultSet resultSet;

    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/hospital_wellmeadows";

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
    public boolean ejecutarInstruccionDML(String instruccionSQL, Object[] parametros) {
        boolean res = false;
        try {
            pstmt = conexion.prepareStatement(instruccionSQL);
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }
            if (pstmt.executeUpdate() >= 1) {
                res = true;
            }
        } catch (SQLException e) {
            System.out.println("Error en instrucción");
            e.printStackTrace();
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