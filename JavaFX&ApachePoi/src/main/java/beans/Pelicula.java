/**
 * Pelicula.java 22-jul-2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package beans;

public class Pelicula extends Item {

    private String genero;

    private double ratting;

    /**
     * @param id
     * @param nombre
     * @param genero
     * @param ratting
     */
    public Pelicula() {

    }

    public Pelicula(final double id, final String nombre, final String genero, final double ratting) {
        super(id, nombre);
        this.genero = genero;
        this.ratting = ratting;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    public double getRatting() {
        return this.ratting;
    }

    public void setRatting(final double ratting) {
        this.ratting = ratting;
    }

}
