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

        ResultSet unekoa=topHiruDBKud.topHiru();

        Map<Integer,String> emaitza=new HashMap<>();
        try{
            Integer i=0;
            while (unekoa.next()){
                emaitza.put(i,unekoa.getString("totala")+"###"+unekoa.getString("bandera"));
                i++;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return emaitza;

    }
}
