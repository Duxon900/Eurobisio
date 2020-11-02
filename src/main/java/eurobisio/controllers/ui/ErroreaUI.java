package eurobisio.controllers.ui;

import eurobisio.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ErroreaUI {

    private Main mainApp;


    @FXML
    void onClick(ActionEvent event) {
        System.out.println("okay bro no me cuentes tu vida");
    }


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


}
