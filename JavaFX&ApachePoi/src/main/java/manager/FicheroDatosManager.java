/**
 * FicheroDatosManager.java 24 jul. 2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
package manager;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import beans.Item;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import strategy.IEstrategia;

/**
 * @author <a href=""></a>
 *
 */
public class FicheroDatosManager {

    final List<Item> listaItems = new ArrayList<Item>();

    public List<Item> getDatosFromFichero(final IEstrategia strategy) {


        try {
            final FileInputStream file = new FileInputStream(new File(strategy.getRutaFichero()));

            final XSSFWorkbook workbook = new XSSFWorkbook(file);

            final XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {

                this.listaItems.add(strategy.getItemFromRow(sheet.getRow(i)));
            }

            file.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return this.listaItems;


    }

}
