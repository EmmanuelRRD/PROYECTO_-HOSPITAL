package modelo;

public class Proveedor {
    private String id_Proveedor;
    private String nombre;
    private String primerAP;
    private String segundoAP;
    private String direccion;
    private String numTel;
    private String numFax;

    public Proveedor(String id_Proveedor, String nombre, String primerAP, String segundoAP, String direccion, String numTel, String numFax) {
        this.id_Proveedor = id_Proveedor;
        this.nombre = nombre;
        this.primerAP = primerAP;
        this.segundoAP = segundoAP;
        this.direccion = direccion;
        this.numTel = numTel;
        this.numFax = numFax;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id_Proveedor=" + id_Proveedor +
                ", nombre='" + nombre + '\'' +
                ", primerAP='" + primerAP + '\'' +
                ", segundoAP='" + segundoAP + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTel=" + numTel +
                ", numFax=" + numFax +
                '}';
    }

    public Object[] tablaContenidoProveedor() {

        Object[] objetoProveedor = {id_Proveedor,nombre,primerAP,segundoAP,direccion,numTel,numTel};

        return objetoProveedor;


    }

    public String getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(String id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAP() {
        return primerAP;
    }

    public void setPrimerAP(String primerAP) {
        this.primerAP = primerAP;
    }

    public String getSegundoAP() {
        return segundoAP;
    }

    public void setSegundoAP(String segundoAP) {
        this.segundoAP = segundoAP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNumFax() {
        return numFax;
    }

    public void setNumFax(String numFax) {
        this.numFax = numFax;
    }
}
