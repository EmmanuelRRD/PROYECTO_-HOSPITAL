package controlador;

import bd.ConexionBD;
import modelo.Proveedor;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ProveedorDAO {
    ConexionBD conexionBD = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //============================= METODOS ABCC ================================
    //Metodo de ALTAS
    public boolean agregarProveedor(Proveedor proveedor){
        boolean res = false;

        String sql = "INSERT INTO farmaceuticos VALUES('"+proveedor.getId_Proveedor()+"','"+proveedor.getNombre()+"','"+proveedor.getPrimerAP()+"','"+proveedor.getSegundoAP()+"','"+proveedor.getDireccion()+"','"+proveedor.getNumTel()+"','"+proveedor.getNumFax()+"')";

        res = conexionBD.ejecutarInstruccionDML(sql);
        return res;

    }

    public boolean eliminarProveedor(String numControl){
        String sql = "DELETE FROM farmaceuticos WHERE ID_Farmaceuticos='"+numControl+"'";

        return conexionBD.ejecutarInstruccionDML(sql);
    }

    public boolean actualizarAlumno(Proveedor proveedor){
        String sql = "UPDATE farmaceuticos SET Nombre_Proveedor='"+proveedor.getNombre()+"',Primer_Ap='"+proveedor.getPrimerAP()+"', Segundo_AP='"+proveedor.getSegundoAP()+"',Direccion='"+proveedor.getDireccion()+"', Num_Tel='"+proveedor.getNumTel()+"', Num_Fax='"+proveedor.getNumFax()+"'";
        return conexionBD.ejecutarInstruccionDML(sql);
    }

    public ArrayList objProveedores(String filtro) throws SQLException {
        ArrayList litaProveedores = new ArrayList();

        String sql = "select * from farmaceuticos";
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String idF = rs.getString("ID_Farmaceuticos");
                String nP = rs.getString("Nombre_Proveedor");
                String apU = rs.getString("Primer_Ap");
                String sgAP = rs.getString("Segundo_Ap");
                String d = rs.getString("Direccion");
                String nT = rs.getString("Num_Tel");
                String  nF = rs.getString("Num_Fax");

                Proveedor p = new Proveedor(idF,nP,apU,sgAP,d,nT,nF);

                litaProveedores.add(p.tablaContenidoProveedor());

            }while (rs.next());

        }catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Tabla sin contenido!!!!");
        }

        return  litaProveedores;
    }


}
