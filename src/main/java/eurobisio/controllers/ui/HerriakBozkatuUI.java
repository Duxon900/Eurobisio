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

import java.net.Inet4Address;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

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

    public void hasieratu(String izena){
        HerrialdeBozkatuKud herrialdeBozkatuKud=new HerrialdeBozkatuKud();
        ResultSet datuak=herrialdeBozkatuKud.lortuHerriak();

        var lista=herrialdeBozkatuKud.listaBihurtu(datuak);

        taula.setEditable(true);

        //        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        zutabePuntu.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
        zutabeAbesti.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        zutabeArtista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        zutabeHerrialde.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        zutabeArgazki.setCellValueFactory(new PropertyValueFactory<Partaide,Image>("argazkia"));


        zutabePuntu.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

//        zutabePuntu.setOnEditCommit(t -> {
//            if (!t.getTableView().getItems().get(t.getTablePosition().getRow()).getHerrialdea().equals(izena)){
//                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPuntuak(t.getNewValue());
//            }
//            else{
//                zutabePuntu.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
//            }
//        });

        Callback<TableColumn<Partaide, String>, TableCell<Partaide, String>> defaultTextFieldCellFactory = TextFieldTableCell.<Partaide>forTableColumn();


        zutabeHerrialde.setCellFactory(col -> {
            col.setEditable(false);
            var ilara = defaultTextFieldCellFactory.call(col).getTableRow();
            var cell=defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (!cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals(izena)) {
                        cell.setEditable(false);
                        var emaitza=cell.getTableRow();
                        emaitza.setEditable(false);

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
        for (int i=0;i<luzera;i++){
            Integer lag=zutabePuntu.getCellData(i);

            if (lag>0){
                //sartu datu berriak Bozkatu taulan
                herrialdeBozkatuKud.updateDatabase(zutabePuntu.getCellObservableValue(i).getValue(),bozkatzailea,zutabeHerrialde.getCellObservableValue(i).getValue());
            }
        }
        mainApp.pantailaratuTopHiru();
    }


}
