package Loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conetare {

        public static Connection CriarConexao() throws SQLException {

            String url ="jdbc:mysql://localhost:3306/bdlojacatita";
            String user ="root";
            String pass="1234";

            Connection conectar = null;
            conectar = DriverManager.getConnection(url, user, pass);

            return conectar;
        }

}
