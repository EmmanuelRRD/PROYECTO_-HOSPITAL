package controlador;

import bd.ConexionBD;
import modelo.Proveedor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO {
    ConexionBD conexionBD = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //============================= METODOS ABCC ================================
    //Metodo de ALTAS
    public boolean agregarProveedor(Proveedor proveedor){
        PreparedStatement prdst = null;
        boolean res = false;

        String sql = "INSERT INTO farmaceuticos (ID_Farmaceuticos, Nombre_Proveedor, Primer_Ap, Segundo_Ap, Direccion, Num_Tel, Num_Fax) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Object[] parametros = {
            proveedor.getId_Proveedor(),
            proveedor.getNombre(),
            proveedor.getPrimerAP(),
            proveedor.getSegundoAP(),
            proveedor.getDireccion(),
            proveedor.getNumTel(),
            proveedor.getNumFax()
        };

        ConexionBD conexionBD = new ConexionBD();
        res = conexionBD.ejecutarInstruccionDML(sql, parametros);

        return res;

    }

    public boolean eliminarProveedor(Object idProveedor){
        String sql = "DELETE FROM farmaceuticos WHERE ID_Farmaceuticos=?";

        return conexionBD.ejecutarInstruccionDML(sql, new Object[]{idProveedor});
    }

    public boolean actualizarAlumno(Proveedor proveedor){
        String sql = "UPDATE farmaceuticos SET Nombre_Proveedor='"+proveedor.getNombre()+"',Primer_Ap='"+proveedor.getPrimerAP()+"', Segundo_AP='"+proveedor.getSegundoAP()+"',Direccion='"+proveedor.getDireccion()+"', Num_Tel='"+proveedor.getNumTel()+"', Num_Fax='"+proveedor.getNumFax()+"'";
        Object[] parametros = {
                proveedor.getId_Proveedor(),
                proveedor.getNombre(),
                proveedor.getPrimerAP(),
                proveedor.getSegundoAP(),
                proveedor.getDireccion(),
                proveedor.getNumTel(),
                proveedor.getNumFax()
        };
        return true;
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

    public ArrayList<String> buscarProveedores(String datoBuscar,String tablaSql) throws SQLException {
        ArrayList litaProveedores = new ArrayList();

        String sql = "select * from "+tablaSql;
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String idF = rs.getString(datoBuscar);
                litaProveedores.add(idF);

            }while (rs.next());

        }catch (SQLException e){
            System.out.println(e);
        }

        return  litaProveedores;
    }


}
