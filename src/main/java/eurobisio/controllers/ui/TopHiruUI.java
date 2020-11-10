package eurobisio.controllers.ui;


import eurobisio.Main;
import eurobisio.controllers.TopHiruKud;
import eurobisio.controllers.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class TopHiruUI{

    @FXML
    private Label txt1;

    @FXML
    private Label txt2;

    @FXML
    private Label txt3;

    @FXML
    private ImageView imgIrabazle1;

    @FXML
    private ImageView imgIrabazle2;

    @FXML
    private ImageView imgirabazle3;


    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    void onClick(ActionEvent event) {
        mainApp.pantailaratuHasiera();
    }


    public void hasieratu() throws FileNotFoundException {
        TopHiruKud topHiruKud=new TopHiruKud();
        var onenak=topHiruKud.topHiru();
        Properties utils= Utils.lortuEzarpenak();
        String path= utils.getProperty("argazkiKokapena");
        Image argazki=null;


        if(!onenak.isEmpty()){
            for (int i=0;i<onenak.size();i++){
                if (i==0){
                    //1. posi
                    String irabazle1=onenak.get(0);
                    String[] lista1=irabazle1.split("###");
                    String izena=path+lista1[1].toLowerCase()+".jpg";
                    argazki=new Image(izena);
                    imgIrabazle1.setImage(argazki);

                    txt1.setText("1. "+lista1[1]+" - "+lista1[0]+" points/pua");


                }
                else if (i==1){
                    //2. posi
                    String irabazle2=onenak.get(1);
                    String[] lista2=irabazle2.split("###");

                    String izena=path+lista2[1].toLowerCase()+".jpg";
                    argazki=new Image(izena);
                    imgIrabazle2.setImage(argazki);

                    txt2.setText("1. "+lista2[1]+" - "+lista2[0]+" points/pua");
                }
                else if(i==2){
                    //3. posi
                    String irabazle3=onenak.get(2);
                    String[] lista3=irabazle3.split("###");

                    String izena=path+lista3[1].toLowerCase()+".jpg";
                    argazki=new Image(izena);
                    imgirabazle3.setImage(argazki);


                    txt3.setText("1. "+lista3[1]+" - "+lista3[0]+" points/pua");
                }
            }
        }
    }
}
