package eurobisio.controllers;

import eurobisio.controllers.db.HerrialdeHautatuDBKud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeHautatuKud {


    public List<String> lortuHerrialdeIzenak() throws SQLException {
        HerrialdeHautatuDBKud herrialdeHautatuDBKud=new HerrialdeHautatuDBKud();
        ResultSet resultSet=herrialdeHautatuDBKud.lortuHerrialdeIzen();

        List<String> emaitza=new ArrayList<>();

        while (resultSet.next()){
            emaitza.add(resultSet.getString("izena"));
        }

        return emaitza;
    }
}
