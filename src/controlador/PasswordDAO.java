package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import bd.ConexionBD;
import modelo.Proveedor;

public class PasswordDAO {
    ConexionBD conexionBD = new ConexionBD();

    public String validarDatos(String usuario){
        String sql = "select * from password";
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        String pass="";

        try{
            rs.next();

            do{
                String nP = rs.getString("Usuario");
                String apU = rs.getString("Contraseña");

                if (usuario.equals(rs.getString("Usuario"))){
                    pass = rs.getString("Contraseña");
                }

            }while (rs.next());

        }catch (SQLException e){
        }

        return pass;
    }

    public boolean crearUsuario(String user,String password){
        boolean resul;
        String sql = "INSERT INTO password (Usuario, Contraseña) VALUES (?,?)";

        Object[] parametros = {
            user,password
        };

        resul = conexionBD.ejecutarInstruccionDML(sql, parametros);

        return resul;
    }

}
