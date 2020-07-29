/**
 * EstrategiaSeries.java 28 jul. 2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package strategy;

import beans.Item;
import beans.Series;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author <a href=""></a>
 *
 */
public class EstrategiaSeries implements IEstrategia {


    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final String param1, final String param2, final String param3) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRutaFichero() {
        return "C:\\Users\\sseijas\\Downloads\\series.xlsx";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item getItemFromRow(final Row ro) {

        final Series e = new Series();
        for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
            final Cell ce = ro.getCell(j);
            if (j == 0) {
                e.setId(ce.getNumericCellValue());
            }
            if (j == 1) {
                e.setNombre(ce.getStringCellValue());
            }
            if (j == 2) {
                e.setPlataforma(ce.getStringCellValue());
            }
            if (j == 3) {
                e.setRatting(ce.getNumericCellValue());
            }
        }

        return e;
    }

}

