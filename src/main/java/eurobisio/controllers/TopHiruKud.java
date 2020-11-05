package eurobisio.controllers;

import eurobisio.controllers.db.DBKudeatzaile;
import eurobisio.controllers.db.TopHiruDBKud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TopHiruKud {

    public Map<Integer,String> topHiru(){
        TopHiruDBKud topHiruDBKud=new TopHiruDBKud();

        ResultSet lag=topHiruDBKud.topHiru();

        Map<Integer,String> emaitza=new HashMap<>();
        try{
            Integer i=0;
            while (lag.next()){
                emaitza.put(i,lag.getString("totala")+"###"+lag.getString("bozkatuaIzanDa"));
                i++;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return emaitza;

    }
}
