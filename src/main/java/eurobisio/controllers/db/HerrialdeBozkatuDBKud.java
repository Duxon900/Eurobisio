package eurobisio.controllers.db;

import java.sql.ResultSet;

public class HerrialdeBozkatuDBKud {

    public ResultSet lortuHerriak(){
        //SELECT Herrialde.bandera,Ordezkaritza.* FROM Ordezkaritza INNER JOIN Herrialde WHERE herrialdea=izena;
        String query="SELECT Herrialde.bandera,Ordezkaritza.* FROM Ordezkaritza INNER JOIN Herrialde WHERE herrialdea=izena";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        return dbKudeatzaile.execSQL(query);
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

    public ResultSet lortuPuntuak(String izena){
        //SELECT sum(puntuak) as totala FROM Bozkaketa where 'Albania'=bozkatuDu and urtea=year(curdate()) group by bozkatuDu
        String query="SELECT sum(puntuak) as totala FROM Bozkaketa where bozkatuDu='"+izena+"' and urtea=year(curdate()) group by bozkatuDu";
        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();

        return dbKudeatzaile.execSQL(query);
    }
}
