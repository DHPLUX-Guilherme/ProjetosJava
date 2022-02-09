package ExAvaliacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConeF
{
    public static  Connection createConnection() throws SQLException
    {
        String url="jdbc:mysql://localhost:3306/lojameleiro";
        String user="root";
        String pass="1234";

        Connection connect = null;
        connect = DriverManager.getConnection(url, user, pass);


        return connect;
    }

}
