/**
 * Series.java 24 jul. 2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package beans;

/**
 * @author <a href=""></a>
 *
 */
public class Series extends Item {


    private String plataforma;

    private double ratting;


    public Series() {
    }


    /**
     * @param plataforma
     * @param ratting
     */
    public Series(final double id, final String nombre, final String plataforma, final double ratting) {
        super(id, nombre);
        this.plataforma = plataforma;
        this.ratting = ratting;
    }


    public String getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(final String plataforma) {
        this.plataforma = plataforma;
    }

    public double getRatting() {
        return this.ratting;
    }

    public void setRatting(final double ratting) {
        this.ratting = ratting;
    }

}
