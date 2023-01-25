import java.sql.*;
import java.util.Collections;

public class connections {
    Connection connection;
    Statement statement;

    public connections(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "Munna6954@");
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
