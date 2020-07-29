/**
 * IEstrategia.java 24 jul. 2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package strategy;

import beans.Item;
import org.apache.poi.ss.usermodel.Row;


/**
 * @author <a href=""></a>
 *
 */
public interface IEstrategia {


    public void write(final String param1, final String param2, final String param3);

    /**
     * @return
     */
    public String getRutaFichero();

    /**
     * @param ro
     * @return
     */
    public Item getItemFromRow(Row ro);

}
