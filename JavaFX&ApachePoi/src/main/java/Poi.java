
/**
 * Poi.java 22-jul-2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import beans.Pelicula;
import beans.Series;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Poi {

    final static String rutaPeliculas = "C:\\Users\\sseijas\\Downloads\\peliculas.xlsx";

    final static String rutaSeries = "C:\\Users\\sseijas\\Downloads\\series.xlsx";


    public static List<Pelicula> rellenarPeliculas() {
        final ArrayList<Pelicula> employeeList = new ArrayList<Pelicula>();

        try {
            final FileInputStream file = new FileInputStream(new File(rutaPeliculas));

            final XSSFWorkbook workbook = new XSSFWorkbook(file);

            final XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                final Pelicula pelicula = new Pelicula();
                final Row ro = sheet.getRow(i);
                for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
                    final Cell ce = ro.getCell(j);
                    if (j == 0) {
                        pelicula.setId(ce.getNumericCellValue());
                    }
                    if (j == 1) {
                        pelicula.setNombre(ce.getStringCellValue());
                    }
                    if (j == 2) {
                        pelicula.setGenero(ce.getStringCellValue());
                    }
                    if (j == 3) {
                        pelicula.setRatting(ce.getNumericCellValue());
                    }
                }
                employeeList.add(pelicula);
            }
            for (final Pelicula emp : employeeList) {
                System.out.println("ID:" + emp.getId() + " nombre:" + emp.getNombre() + " fecha:" + emp.getGenero()
                        + " ratting:" + emp.getRatting());
            }
            file.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static List<Series> rellenarSeries() {
        final ArrayList<Series> listaSeries = new ArrayList<Series>();

        try {
            final FileInputStream file = new FileInputStream(new File(rutaSeries));

            final XSSFWorkbook workbookSeries = new XSSFWorkbook(file);

            final XSSFSheet sheet = workbookSeries.getSheetAt(0);

            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                final Series series = new Series();
                final Row ro = sheet.getRow(i);
                for (int j = ro.getFirstCellNum(); j <= ro.getLastCellNum(); j++) {
                    final Cell ce = ro.getCell(j);
                    if (j == 0) {
                        series.setId(ce.getNumericCellValue());
                    }
                    if (j == 1) {
                        series.setNombre(ce.getStringCellValue());
                    }
                    if (j == 2) {
                        series.setPlataforma(ce.getStringCellValue());
                    }
                    if (j == 3) {
                        series.setRatting(ce.getNumericCellValue());
                    }
                }
                listaSeries.add(series);
            }

            file.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return listaSeries;
    }

    public static void writePeliculas(final String nombre, final String genero, final String ratting) {
        XSSFWorkbook workbook = null;
        XSSFSheet sheet;
        try {
            final FileInputStream file = new FileInputStream(new File(rutaPeliculas));

            workbook = new XSSFWorkbook(file);

            sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

            final int rowCount = sheet.getLastRowNum() + 1;
            final Row empRow = sheet.createRow(rowCount);
            System.out.println();
            final Cell c1 = empRow.createCell(0);
            c1.setCellValue(rowCount);
            final Cell c2 = empRow.createCell(1);
            c2.setCellValue(nombre);
            final Cell c3 = empRow.createCell(2);
            c3.setCellValue(genero);
            final Cell c4 = empRow.createCell(3);
            c4.setCellValue(ratting);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        try {
            // Write the workbook in file system
            final FileOutputStream out = new FileOutputStream(
                    new File(rutaPeliculas));
            workbook.write(out);
            out.close();
            System.out.println("Añadido Correctamente");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeSeries(final String nombre, final String plataforma, final String ratting) {
        XSSFWorkbook workbook = null;
        XSSFSheet sheet;
        try {
            final FileInputStream file = new FileInputStream(new File(rutaSeries));

            workbook = new XSSFWorkbook(file);

            sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

            // Get the count in sheet
            final int rowCount = sheet.getLastRowNum() + 1;
            final Row empRow = sheet.createRow(rowCount);
            System.out.println();
            final Cell c1 = empRow.createCell(0);
            c1.setCellValue(rowCount);
            final Cell c2 = empRow.createCell(1);
            c2.setCellValue(nombre);
            final Cell c3 = empRow.createCell(2);
            c3.setCellValue(plataforma);
            final Cell c4 = empRow.createCell(3);
            c4.setCellValue(ratting);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        try {
            // Write the workbook in file system
            final FileOutputStream out = new FileOutputStream(
                    new File(rutaSeries));
            workbook.write(out);
            out.close();
            System.out.println("Añadido Correctamente");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}
