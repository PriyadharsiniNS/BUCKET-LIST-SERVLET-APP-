package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private String url = "jdbc:postgresql://localhost:5432/BucketList2";
	private String dbuname = "postgres";
	private String dbpass = "GanHari@74";

	public Connection getConnection()
	{
		
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, dbuname, dbpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
