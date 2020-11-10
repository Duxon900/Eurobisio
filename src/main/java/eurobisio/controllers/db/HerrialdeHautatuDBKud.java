package eurobisio.controllers.db;

import java.sql.ResultSet;

public class HerrialdeHautatuDBKud {

    public ResultSet lortuHerrialdeIzen(){
        String query="SELECT izena FROM Herrialde inner join Ordezkaritza on herrialdea=izena order by izena";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        ResultSet emaitza= dbKudeatzaile.execSQL(query);
        return emaitza;
    }

    public ResultSet lortuBandera(String izena){

        //SELECT bandera FROM Herrialde WHERE izena='Belgika';
        String query="SELECT bandera FROM Herrialde WHERE izena='"+izena+"'";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        ResultSet emaitza=dbKudeatzaile.execSQL(query);
        return emaitza;
    }

    public ResultSet emandakoPuntuak(String izena){
        //SELECT puntuak FROM Bozkaketa WHERE bozkatuDu='Belgika' AND urtea=year(curdate());
        String query="SELECT puntuak FROM Bozkaketa WHERE bozkatuDu='"+izena+"' AND urtea=year(curdate())";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        ResultSet emaitza=dbKudeatzaile.execSQL(query);
        return emaitza;
    }
}
