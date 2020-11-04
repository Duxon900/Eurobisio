package eurobisio.controllers.db;

import java.sql.ResultSet;

public class HerrialdeBozkatuDBKud {

    public ResultSet lortuHerriak(){
        //SELECT Herrialde.bandera,Ordezkaritza.* FROM Ordezkaritza INNER JOIN Herrialde WHERE herrialdea=izena;
        String query="SELECT Herrialde.bandera,Ordezkaritza.* FROM Ordezkaritza INNER JOIN Herrialde WHERE herrialdea=izena";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        return dbKudeatzaile.execSQL(query);
    }
}
