package tata_health_generic_DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con;

	public void getDbConnection(String url, String user, String password) throws Throwable {
		try {
			Driver Dref = new Driver();

			DriverManager.registerDriver(Dref);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
		}
	}

	public void getDbConnection() throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		} catch (Exception e) {
		}
	}

	public void closeDbConnection() throws Throwable {
		try {
			con.close();
		} catch (Exception e) {

		}
	}

	public ResultSet executeSelectQuery(String Query) throws Throwable {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(Query);
		} catch (Exception e) {

		}
		return result;

	}

	public int executeNonSelectQuery(String Query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(Query);
		} catch (Exception e) {

		}
		return result;
	}
}
