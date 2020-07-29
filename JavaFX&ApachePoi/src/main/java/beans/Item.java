/**
 * Item.java 24 jul. 2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package beans;

/**
 * @author <a href=""></a>
 *
 */
public class Item {

    private double id;

    private String nombre;

    /**
     * @param id
     * @param nombre
     */
    public Item() {

    }

    public Item(final double id, final String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public double getId() {
        return this.id;
    }

    public void setId(final double id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

}
