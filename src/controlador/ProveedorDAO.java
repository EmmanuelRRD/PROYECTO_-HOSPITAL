package controlador;

import bd.ConexionBD;
import modelo.Proveedor;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO {
    ConexionBD conexionBD = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //============================= METODOS ABCC ================================
    //Metodo de ALTAS
    public String user(String usuario){
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

    public boolean agregarProveedor(Proveedor proveedor,String nombreTabla,String idProveedor){
        boolean res = false;

        String sql = "INSERT INTO "+nombreTabla+" ("+idProveedor+", Nombre, Primer_Ap, Segundo_Ap, Telefono, Fax, Estado, Municipio, Colonia, calle,numeroCalle) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        Object[] parametros = {
            proveedor.getId_Proveedor(),
            proveedor.getNombre(),
            proveedor.getPrimerAP(),
            proveedor.getSegundoAP(),
            proveedor.getNumTel(),
            proveedor.getNumFax(),
            proveedor.getEstado(),
            proveedor.getMunicipio(),
            proveedor.getColonia(),
            proveedor.getCalle(),
            proveedor.getNumeroCalle()
        };

        ConexionBD conexionBD = new ConexionBD();

        res = conexionBD.ejecutarInstruccionDML(sql, parametros);

        return res;

    }

    public boolean eliminarProveedor(Object idProveedor,String tabla,String identProveedor){
        String sql = "DELETE FROM "+tabla+" WHERE "+identProveedor+"=?";

        return conexionBD.ejecutarInstruccionDML(sql, new Object[]{idProveedor});
    }

    public boolean actualizarProveedor(Proveedor proveedor,String nombreTabla,String idProveeedor){
        String sql = "UPDATE "+nombreTabla+" SET Nombre=?, Primer_Ap=?, Segundo_AP=?, Telefono=?, Fax=?, Estado=?, Municipio=?, Colonia=?, calle=?, numeroCalle=? WHERE "+idProveeedor+"=?" ;
        boolean res = false;

        Object[] parametros = {
                proveedor.getNombre(),
                proveedor.getPrimerAP(),
                proveedor.getSegundoAP(),
                proveedor.getNumTel(),
                proveedor.getNumFax(),
                proveedor.getEstado(),
                proveedor.getMunicipio(),
                proveedor.getColonia(),
                proveedor.getCalle(),
                proveedor.getNumeroCalle(),
                proveedor.getId_Proveedor()
        };
        ConexionBD conexionBD = new ConexionBD();
        res = conexionBD.ejecutarInstruccionDML(sql, parametros);
        return res;
    }

    public ArrayList tablaCompletaProveedores(String idFarmaciutico,String tabla) throws SQLException {
        ArrayList litaProveedores = new ArrayList();

        String sql = "select * from "+tabla;
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String idF = rs.getString(idFarmaciutico);
                String nP = rs.getString("Nombre");
                String apU = rs.getString("Primer_Ap");
                String sgAP = rs.getString("Segundo_Ap");
                String tel = rs.getString("Telefono");
                String  fx = rs.getString("Fax");
                String  st = rs.getString("Estado");
                String  mun = rs.getString("Municipio");
                String  col = rs.getString("Colonia");
                String  calle = rs.getString("calle");
                String  numCll = rs.getString("numeroCalle");

                Proveedor p = new Proveedor(idF,nP,apU,sgAP,tel,fx,st,mun,col,calle,numCll);

                litaProveedores.add(p.tablaContenidoProveedor());

            }while (rs.next());

        }catch (SQLException e){
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

    public String[] arregloDatos(String cajaId, String nombres, String primerAP, String segundoAP, String numTel, String numFax, String estado, String municipio, String colonia, String calle, String numCalle) {

        String[] datos = {cajaId, nombres, primerAP, segundoAP, numTel, numFax, estado, municipio, colonia, calle, numCalle};

        return datos;
    }

    public ArrayList<String> consultarProveedor(int posicion,String datoBuscar,String idProveedor,String tablaSql) throws SQLException {
        ArrayList litaProveedores = new ArrayList();
        Proveedor p = null;
        String sql = "select * from "+tablaSql;
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String[] contenedor = new String[11];

                String idF = rs.getString(idProveedor);
                String nP = rs.getString("Nombre");
                String apU = rs.getString("Primer_Ap");
                String sgAP = rs.getString("Segundo_Ap");
                String tel = rs.getString("Telefono");
                String  fx = rs.getString("Fax");
                String  st = rs.getString("Estado");
                String  mun = rs.getString("Municipio");
                String  col = rs.getString("Colonia");
                String  calle = rs.getString("calle");
                String  numCll = rs.getString("numeroCalle");

                contenedor = arregloDatos(idF,nP,apU,sgAP,tel,fx,st,mun,col,calle,numCll);

                if (datoBuscar.equals(contenedor[posicion])){

                        p = new Proveedor(idF,nP,apU,sgAP,tel,fx,st,mun,col,calle,numCll);
                        litaProveedores.add(p.tablaContenidoProveedor());
                }

            }while (rs.next());

        }catch (SQLException e){
            System.out.println(e);
        }

        return  litaProveedores;
    }

}
