package eurobisio.controllers;

import eurobisio.Main;
import eurobisio.controllers.db.HerrialdeBozkatuDBKud;
import eurobisio.controllers.db.HerrialdeHautatuDBKud;

import java.sql.ResultSet;

public class HerrialdeBozkatuKud {

    public ResultSet lortuHerriak(){
        HerrialdeBozkatuDBKud herrialdeBozkatuDBKud=new HerrialdeBozkatuDBKud();

        ResultSet resultSet=herrialdeBozkatuDBKud.lortuHerriak();

        return resultSet;
    }

}
