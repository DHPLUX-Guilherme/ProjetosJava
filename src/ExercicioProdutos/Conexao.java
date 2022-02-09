package ExercicioProdutos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bdlojalucas";
        String user = "root";
        String pass = "1234";

        Connection conexao = null;
        conexao = DriverManager.getConnection(url, user , pass);

        return conexao;
    }
}