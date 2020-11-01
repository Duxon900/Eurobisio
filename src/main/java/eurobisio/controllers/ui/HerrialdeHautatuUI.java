package eurobisio.controllers.ui;

import eurobisio.Main;
import eurobisio.controllers.HerrialdeHautatuKud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeHautatuUI implements Initializable{

    @FXML
    private ComboBox<String> cmbxHerrialde;


    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        HerrialdeHautatuKud herrialde=new HerrialdeHautatuKud();
        try {
            List<String> herriLista=new ArrayList<>();
            herriLista = herrialde.lortuHerrialdeIzenak();

            for (int i=0;i<herriLista.size();i++){
                cmbxHerrialde.getItems().add(i,herriLista.get(i));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
