package eurobisio.controllers;

import eurobisio.controllers.db.HerrialdeHautatuDBKud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeHautatuKud {


    public List<String> lortuHerrialdeIzenak() throws SQLException {
        HerrialdeHautatuDBKud herrialdeHautatuDBKud = new HerrialdeHautatuDBKud();
        ResultSet resultSet = herrialdeHautatuDBKud.lortuHerrialdeIzen();

        List<String> emaitza = new ArrayList<>();

        while (resultSet.next()) {
            emaitza.add(resultSet.getString("izena"));
        }

        return emaitza;
    }


    public String lortuBandera(String izena)  {
        HerrialdeHautatuDBKud herrialdeHautatuDBKud = new HerrialdeHautatuDBKud();
        ResultSet resultSet = herrialdeHautatuDBKud.lortuBandera(izena);
        String bandera = "";
        try {
            if (resultSet.next())
            bandera = resultSet.getString("bandera");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bandera;
    }

    public int puntuakKalkulatu(String izena) {
        HerrialdeHautatuDBKud herrialdeHautatuDBKud = new HerrialdeHautatuDBKud();
        ResultSet resultSet = herrialdeHautatuDBKud.emandakoPuntuak(izena);

        int emaitza = 0;
        try {
            if (resultSet == null) return emaitza;
            else {
                while (resultSet.next()) {
                    emaitza = emaitza + resultSet.getInt("puntuak");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emaitza;
    }
}