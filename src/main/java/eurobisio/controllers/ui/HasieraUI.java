package eurobisio.controllers.ui;


import eurobisio.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;

public class HasieraUI extends Parent {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {
        mainApp.pantailaratuHerrialdeHautatu();
    }

}
