package models;

public class PuestoModel {
    private int id;
    private String descripcion;

    public PuestoModel(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "id: '" + getId() + "'" + ", descripcion: '" + getDescripcion() + "'";
    }

}
