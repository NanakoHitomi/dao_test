package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
			public static Connection getConnection() throws SQLException, ClassNotFoundException {
						final String URL ="jdbc:mysql://localhost/todo_dao_practice";
						final String USER ="root";
						final String  PASSWORD="";
		
						try {
							Class.forName("com.mysql.jdbc.Driver");
						} catch (Exception e) {
							e.printStackTrace();
						}
		
						Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
						return con;
	}

}
