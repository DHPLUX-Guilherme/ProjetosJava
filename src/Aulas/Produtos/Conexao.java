package Aulas.Produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection CriarConexao() throws SQLException {

        String url ="jdbc:mysql://localhost:3306/dbProdutos";
        String user ="root";
        String pass="1234";

        Connection conectar = null;
        conectar = DriverManager.getConnection(url, user, pass);

        return conectar;
    }
}
