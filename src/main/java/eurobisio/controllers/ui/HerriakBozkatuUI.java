package eurobisio.controllers.ui;

import eurobisio.Main;
import eurobisio.controllers.Partaide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HerriakBozkatuUI implements Initializable {

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

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
