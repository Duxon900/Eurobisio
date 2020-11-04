package eurobisio.controllers.ui;


import eurobisio.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopHiruUI {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {
        mainApp.pantailaratuHasiera();
    }

}
