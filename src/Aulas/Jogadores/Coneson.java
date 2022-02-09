package Aulas.Jogadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneson {

    public static Connection CriarConexao() throws SQLException {

        String url ="jdbc:mysql://localhost:3306/funcionarios";
        String user ="root";
        String pass="1234";

        Connection conectar = null;
        conectar = DriverManager.getConnection(url, user, pass);

        return conectar;
    }

}
