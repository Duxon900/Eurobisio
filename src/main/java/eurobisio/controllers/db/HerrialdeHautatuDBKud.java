package eurobisio.controllers.db;

import java.sql.ResultSet;

public class HerrialdeHautatuDBKud {

    public ResultSet lortuHerrialdeIzen(){
        String query="SELECT izena FROM Herrialde inner join Ordezkaritza on herrialdea=izena order by izena";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        ResultSet emaitza= dbKudeatzaile.execSQL(query);
        return emaitza;
    }
}
