/**
 * ColecctionFactory.java 28 jul. 2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package factory;

import beans.TipoColeccion;
import strategy.EstrategiaPeliculas;
import strategy.IEstrategia;

/**
 * @author <a href=""></a>
 *
 */
public class ColeccionFactory {

    public static IEstrategia getEstrategia(final TipoColeccion tipo) {
        IEstrategia estrategia = null;
        switch (tipo) {
            case PELICULAS:
                estrategia = new EstrategiaPeliculas();

                break;
            case SERIES:
                estrategia = new EstrategiaPeliculas();
                break;
        }
        return estrategia;

    }

}
