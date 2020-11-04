package eurobisio.controllers.ui;

import eurobisio.Main;
import eurobisio.controllers.HerrialdeBozkatuKud;
import eurobisio.controllers.HerrialdeHautatuKud;
import eurobisio.controllers.Partaide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.security.auth.callback.Callback;
import java.awt.*;
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

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {
        mainApp.pantailaratuTopHiru();
    }

    public void hasieratu(String izena){
        HerrialdeBozkatuKud herrialdeBozkatuKud=new HerrialdeBozkatuKud();
        ResultSet datuak=herrialdeBozkatuKud.lortuHerriak();

    }

}
