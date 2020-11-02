package eurobisio.controllers.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class HerriakBozkatuUI implements Initializable {

    @FXML
    private TableColumn<?, ?> zutabeArgazki;

    @FXML
    private TableColumn<?, ?> zutabeHerrialde;

    @FXML
    private TableColumn<?, ?> zutabeArtista;

    @FXML
    private TableColumn<?, ?> zutabeAbesti;

    @FXML
    private TableColumn<?, ?> zutabePuntu;

    @FXML
    void onClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
