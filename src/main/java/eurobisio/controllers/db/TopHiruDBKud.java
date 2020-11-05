package eurobisio.controllers.db;

import java.sql.ResultSet;

public class TopHiruDBKud {
    public ResultSet topHiru(){
        //select sum(puntuak) as totala,bozkatuaIzanDa from Bozkaketa group by bozkatuaIzanDa order by totala desc limit 3
        String query="select sum(puntuak) as totala,bozkatuaIzanDa from Bozkaketa group by bozkatuaIzanDa order by totala desc limit 3";

        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();

        return dbKudeatzaile.execSQL(query);
    }
}
