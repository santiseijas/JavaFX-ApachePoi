
/**
 * Ui.java 22-jul-2020
 *
 * Copyright 2020 INDITEX. Departamento de Sistemas
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import beans.Pelicula;
import beans.Series;
import components.ActionButtonTableCell;

public class Ui extends Application {

    private final TableView<Pelicula> tablePeliculas = new TableView<Pelicula>();

    private final TableView<Series> tablaSeries = new TableView<Series>();


    private final ObservableList<Pelicula> dataPeliculas = FXCollections.observableArrayList(Poi.rellenarPeliculas());

    private final ObservableList<Series> dataSeries = FXCollections.observableArrayList(Poi.rellenarSeries());

    @Override
    public void start(final Stage stage) {
        final Scene scene = new Scene(new Group());
        final HBox hbPeliculas = new HBox();
        final HBox hbSeries = new HBox();

        stage.setWidth(600);
        stage.setHeight(600);

        // TABLA PELICULAS
        this.tablePeliculas.setEditable(true);

        final TableColumn idCol = new TableColumn("Id");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Pelicula, String>("id"));

        final TableColumn nombreCol = new TableColumn("Nombre");
        nombreCol.setMinWidth(100);
        nombreCol.setCellValueFactory(
                new PropertyValueFactory<Pelicula, String>("nombre"));

        final TableColumn genCol = new TableColumn("Genero");
        genCol.setMinWidth(100);
        genCol.setCellValueFactory(
                new PropertyValueFactory<Pelicula, String>("genero"));

        final TableColumn rattingCol = new TableColumn("Ratting");
        rattingCol.setMinWidth(100);
        rattingCol.setCellValueFactory(
                new PropertyValueFactory<Pelicula, String>("ratting"));

        final TableColumn botonCol = new TableColumn("");
        botonCol.setMinWidth(100);
        botonCol.setCellFactory(ActionButtonTableCell.<Pelicula>forTableColumn("Eliminar", (final Pelicula p) -> {
            this.tablePeliculas.getItems().remove(p);
            return p;
        }));

        this.tablePeliculas.setItems(this.dataPeliculas);
        this.tablePeliculas.getColumns().addAll(idCol, nombreCol, genCol, rattingCol, botonCol);

        // TABLA SERIES
        this.tablaSeries.setEditable(true);
        final TableColumn idColSeries = new TableColumn("Id");
        idColSeries.setMinWidth(100);
        idColSeries.setCellValueFactory(
                new PropertyValueFactory<Series, String>("id"));

        final TableColumn nombreColSeries = new TableColumn("Nombre");
        nombreColSeries.setMinWidth(100);
        nombreColSeries.setCellValueFactory(
                new PropertyValueFactory<Series, String>("nombre"));

        final TableColumn platColSeries = new TableColumn("Plataforma");
        platColSeries.setMinWidth(100);
        platColSeries.setCellValueFactory(
                new PropertyValueFactory<Series, String>("plataforma"));

        final TableColumn rattingColSeries = new TableColumn("Ratting");
        rattingColSeries.setMinWidth(100);
        rattingColSeries.setCellValueFactory(
                new PropertyValueFactory<Series, String>("ratting"));

        this.tablaSeries.setItems(this.dataSeries);
        this.tablaSeries.getColumns().addAll(idColSeries, nombreColSeries, platColSeries, rattingColSeries);

        // TEXTFIELD Peliculas
        final TextField addNombre = new TextField();
        addNombre.setPromptText("Nombre");
        addNombre.setMaxWidth(nombreCol.getPrefWidth());

        final TextField addGenero = new TextField();
        addGenero.setPromptText("Genero");
        addGenero.setMaxWidth(genCol.getPrefWidth());

        final TextField addRat = new TextField();
        addRat.setPromptText("Ratting");
        addRat.setMaxWidth(rattingCol.getPrefWidth());


        // TEXTFIELD Series
        final TextField addNombreSeries = new TextField();
        addNombreSeries.setPromptText("Nombre");
        addNombreSeries.setMaxWidth(nombreCol.getPrefWidth());

        final TextField addPlataformaSeries = new TextField();
        addPlataformaSeries.setPromptText("Plataforma");
        addPlataformaSeries.setMaxWidth(genCol.getPrefWidth());

        final TextField addRatSeries = new TextField();
        addRatSeries.setPromptText("Ratting");
        addRatSeries.setMaxWidth(rattingCol.getPrefWidth());
        // BOTON Peliculas
        final Button addButtonPeliculas = new Button("Añadir");
        addButtonPeliculas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                int id = Ui.this.dataPeliculas.size() + 1;
                Ui.this.dataPeliculas.add(new Pelicula(id++,
                        addNombre.getText(),
                        addGenero.getText(),
                        Double.parseDouble(addRat.getText())));
                Poi.writePeliculas(addNombre.getText(), addGenero.getText(), addRat.getText());
                addNombre.clear();
                addGenero.clear();
                addRat.clear();

            }
        });
        // Boton Series
        final Button addButtonSeries = new Button("Añadir");
        addButtonSeries.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                int id = Ui.this.dataSeries.size() + 1;
                Ui.this.dataSeries.add(new Series(id++,
                        addNombreSeries.getText(),
                        addPlataformaSeries.getText(),
                        Double.parseDouble(addRatSeries.getText())));
                Poi.writeSeries(addNombreSeries.getText(), addPlataformaSeries.getText(), addRatSeries.getText());
                addNombreSeries.clear();
                addPlataformaSeries.clear();
                addRatSeries.clear();

            }
        });

        final VBox vboxPeliculas = new VBox();
        vboxPeliculas.getChildren().addAll(this.tablePeliculas, hbPeliculas);

        final VBox vboxSeries = new VBox();
        vboxSeries.getChildren().addAll(this.tablaSeries, hbSeries);


        // TABS
        final TabPane tabPane = new TabPane();

        final Tab tab1 = new Tab("Peliculas", vboxPeliculas);
        final Tab tab2 = new Tab("Series", vboxSeries);

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);

        hbPeliculas.getChildren().addAll(addNombre, addGenero, addRat, addButtonPeliculas);
        hbPeliculas.setSpacing(3);

        hbSeries.getChildren().addAll(addNombreSeries, addPlataformaSeries, addRatSeries, addButtonSeries);
        hbPeliculas.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(tabPane);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
