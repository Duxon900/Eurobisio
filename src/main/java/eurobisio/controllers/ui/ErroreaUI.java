package eurobisio.controllers.ui;

import eurobisio.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaUI  {

    private Main mainApp;

    @FXML
    private Text txtHerria;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.pantailaratuHasiera();
    }


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void hasieratuTestua(String izena){
        String testua=txtHerria.getText();
        testua=testua.replace("ADRE",izena);
        txtHerria.setText(testua);
    }

}
