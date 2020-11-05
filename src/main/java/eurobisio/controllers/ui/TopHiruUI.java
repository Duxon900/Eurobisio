package eurobisio.controllers.ui;


import eurobisio.Main;
import eurobisio.controllers.TopHiruKud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TopHiruUI{

    @FXML
    private Label txt1;

    @FXML
    private Label txt2;

    @FXML
    private Label txt3;

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {
        mainApp.pantailaratuHasiera();
    }


    public void hasieratu() {
        TopHiruKud topHiruKud=new TopHiruKud();
        var onenak=topHiruKud.topHiru();


        for (int i=0;i<onenak.size();i++){
            if (i==0){
                //1. posi
                String irabazle1=onenak.get(0);
                String[] lista1=irabazle1.split("###");

                txt1.setText("1. "+lista1[1]+" - "+lista1[0]+" puntu ditu");
            }
            else if (i==1){
                //2. posi
                String irabazle2=onenak.get(1);
                String[] lista2=irabazle2.split("###");

                txt2.setText("1. "+lista2[1]+" - "+lista2[0]+" puntu ditu");
            }
            else{
                //3. posi
                String irabazle3=onenak.get(2);
                String[] lista3=irabazle3.split("###");

                txt3.setText("1. "+lista3[1]+" - "+lista3[0]+" puntu ditu");
            }
        }
    }
}
