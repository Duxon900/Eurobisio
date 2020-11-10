package eurobisio.controllers.ui;

import eurobisio.Main;
import eurobisio.controllers.HerrialdeBozkatuKud;
import eurobisio.controllers.Partaide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.io.FileNotFoundException;
import java.sql.ResultSet;

public class HerriakBozkatuUI {

    @FXML
    private TableView<Partaide> taula;

    @FXML
    private TableColumn<Partaide, Image> zutabeArgazki;

    @FXML
    private TableColumn<Partaide, String> zutabeHerrialde;

    @FXML
    private TableColumn<Partaide, String> zutabeArtista;

    @FXML
    private TableColumn<Partaide, String> zutabeAbesti;

    @FXML
    private TableColumn<Partaide, Integer> zutabePuntu;

    private Main mainApp;

    private String bozkatzailea;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setBozkatzailea(String bozkatzailea) {
        this.bozkatzailea = bozkatzailea;
    }

    public void hasieratu(){
        HerrialdeBozkatuKud herrialdeBozkatuKud=new HerrialdeBozkatuKud();
        ResultSet datuak=herrialdeBozkatuKud.lortuHerriak();

        var lista=herrialdeBozkatuKud.listaBihurtu(datuak);

        taula.setEditable(true);

        zutabePuntu.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
        zutabeAbesti.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        zutabeArtista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        zutabeHerrialde.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        zutabeArgazki.setCellValueFactory(new PropertyValueFactory<Partaide,Image>("argazkia"));


        Callback<TableColumn<Partaide,Integer>,TableCell<Partaide,Integer>> defaultTextFactory=TextFieldTableCell.forTableColumn(new IntegerStringConverter());

        zutabePuntu.setOnEditCommit(t -> {
            if (!t.getTableView().getItems().get(t.getTablePosition().getRow()).getHerrialdea().equals(bozkatzailea)){
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPuntuak(t.getNewValue());
            }
        });

        zutabePuntu.setCellFactory(col -> {
            var cell=defaultTextFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (!cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals(bozkatzailea)) {
                        cell.setEditable(false);
                    } else {
                        cell.setEditable(true);
                    }
                }
            });
            return cell;
        });


        zutabeArgazki.setCellFactory(p -> new TableCell<>() {
        public void updateItem(Image image, boolean empty) {
            if (image != null && !empty){
                final ImageView imageview = new ImageView();
                imageview.setFitHeight(30);
                imageview.setFitWidth(50);
                imageview.setImage(image);
                setGraphic(imageview);
                setAlignment(Pos.CENTER);
            }else{
                setGraphic(null);
                setText(null);
            }
        };
    });

        taula.setItems(lista);
    }


    @FXML
    void onClick(ActionEvent event) {
        HerrialdeBozkatuKud herrialdeBozkatuKud=new HerrialdeBozkatuKud();
        int luzera=taula.getItems().size();
        int emaitza=0;

        for (int i=0;i<luzera;i++){
            Integer lag=zutabePuntu.getCellData(i);

            emaitza=emaitza+lag;
        }

        //konprobatu 5 baino gutxiago direla puntuak
        Integer unekoak=herrialdeBozkatuKud.lortuPuntuak(bozkatzailea);

        if (emaitza+unekoak<=5 ){
            for (int i=0;i<luzera;i++){
                Integer lag=zutabePuntu.getCellData(i);

                if (lag>0) {
                    //sartu datu berriak Bozkatu taulan
                    herrialdeBozkatuKud.updateDatabase(zutabePuntu.getCellObservableValue(i).getValue(), bozkatzailea, zutabeHerrialde.getCellObservableValue(i).getValue());
                }
            }
        }
        else {
            System.out.println("konprobatu puntuak");
        }

        try {
            mainApp.getTopHiruUI().hasieratu();
            mainApp.pantailaratuTopHiru();
        } catch (FileNotFoundException e) {

        }

    }

}
