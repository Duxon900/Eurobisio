package eurobisio.controllers;

import eurobisio.Main;
import eurobisio.controllers.db.DBKudeatzaile;
import eurobisio.controllers.db.HerrialdeBozkatuDBKud;
import eurobisio.controllers.db.HerrialdeHautatuDBKud;
import eurobisio.controllers.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.image.Image;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HerrialdeBozkatuKud {

    public ResultSet lortuHerriak(){
        HerrialdeBozkatuDBKud herrialdeBozkatuDBKud=new HerrialdeBozkatuDBKud();

        ResultSet resultSet=herrialdeBozkatuDBKud.lortuHerriak();

        return resultSet;
    }

    public ObservableList<Partaide> listaBihurtu(ResultSet resultSet){
        ObservableList<Partaide> emaitza=FXCollections.observableArrayList();
        try{
            while(resultSet.next()){
                //bandera artista herrialdea urtea abestia puntuak
                Partaide partaide=new Partaide();
                partaide.setAbestia(resultSet.getString("abestia"));
                partaide.setArtista(resultSet.getString("artista"));
                partaide.setHerrialdea(resultSet.getString("herrialdea"));
                partaide.setPuntuak(0);

                Properties utils=Utils.lortuEzarpenak();
                String path= utils.getProperty("argazkiKokapena");
                partaide.setArgazkia(new Image(path + resultSet.getString("bandera") + ".jpg"));

                emaitza.add(partaide);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emaitza;
    }


    public boolean updateDatabase(int puntuak,String nork, String nori){
        // INSERT into Bozkaketa (`bozkatuaIzanDa`, `bozkatuDu`, `urtea`, `puntuak`) VALUES ('adaw','awdaw',year(curdate()),'21')
        String query="INSERT INTO `Bozkaketa` (`bozkatuaIzanDa`, `bozkatuDu`, `urtea`, `puntuak`) VALUES('"+nori+"','"+nork+"',year(curdate()),'"+puntuak+"')";

        try{
            DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
            dbKudeatzaile.execSQL(query);
            System.out.println(query);
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

}
