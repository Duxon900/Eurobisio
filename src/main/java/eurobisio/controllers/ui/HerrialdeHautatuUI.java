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
        HerrialdeHautatuKud herrialde=new HerrialdeHautatuKud();
        String bandera=herrialde.lortuBandera(cmbxHerrialde.getValue());

        int puntu=herrialde.puntuakKalkulatu(cmbxHerrialde.getValue());
        if(puntu==5){
            mainApp.getErroreaUI().hasieratuTestua(cmbxHerrialde.getValue());
            mainApp.pantailaratuErrorea();
        }
        else {
            mainApp.getHerriakBozkatuUI().setBozkatzailea(cmbxHerrialde.getValue());
            mainApp.getHerriakBozkatuUI().hasieratu(cmbxHerrialde.getValue());
            mainApp.pantailaratuHerriakBozkatu();
        }
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
