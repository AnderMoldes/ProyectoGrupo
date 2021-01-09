package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Arrested;
import classes.Country;
import classes.Detained;
import classes.Fined;

public class BDetained {
	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;

	// Loggin local
	private static void log(Level level, String msg, Throwable excepcion) {
		if (!LOGGING)
			return;
		if (logger == null) {
			logger = Logger.getLogger(BDWorkers.class.getName());
			logger.setLevel(Level.ALL);
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}

	private static boolean LOGGING = true;

	// Inicializar la Base de Datos
	public static Connection initBD(String nombreBD) {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			log(Level.INFO, "Conected to database " + nombreBD, null);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "An error has ocurred connecting to database " + nombreBD, e);
			return null;
		}
	}

	// Conectarse a la base de datos
	public static void conection(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table " + nombreBD
						+ " (ID integer primary key autoincrement, name varchar, LastName varchar, "
						+ "age integer, gender varchar, numberOfArrest integer, description varchar, jailRelease varchar, cityzenship varchar)");
				
				log(Level.SEVERE, "The table " + nombreBD + " created", null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error sí es correcto si la
																						// tabla ya existe
					log(Level.SEVERE, "The table " + nombreBD + " already exists", e);
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error coneccting to database " + nombreBD, e);
		}

	}

	// Conectarse a la base de datos
	public static void conectionFained(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table " + nombreBD
						+ " (ID integer primary key autoincrement, name varchar,"
						+ " LastName varchar, age integer, gender varchar, description varchar, cityzenship varchar, payment integer)");
				
				log(Level.SEVERE, "The table " + nombreBD + " created", null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error sí es correcto si la
																						// tabla ya existe
					log(Level.SEVERE, "The table " + nombreBD + " already exists", e);
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error coneccting to database " + nombreBD, e);
		}

	}

	public Connection getConection() {
		return connection;
	}


	// InsertarDatos con preparedStatement
	public static void insertIntoPrepStat(Arrested arrested) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO DetainedTable( name, LastName, age, gender, numberOfArrest, description, jailRelease, cityzenship) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			Statement stmtForId= connection.createStatement();
			
			//insertSql.setLong(1, arrested.getIdentificative());
			insertSql.setString(1, arrested.getName());
			insertSql.setString(2, arrested.getLastName());
			insertSql.setLong(3, arrested.getAge());
			insertSql.setString(4, arrested.getGender());
			insertSql.setLong(5, arrested.getNumberOfArrest());
			insertSql.setString(6, arrested.getDescription());
			insertSql.setString(7, arrested.getJailRelease());
			insertSql.setString(8, arrested.getCitizenship().toString());
		

			insertSql.executeUpdate();
			
			ResultSet rs= stmtForId.executeQuery("SELECT LAST_INSERT_ROWID() AS ID FROM  DetainedTable" );
			if (rs.next()) {
				int newID= rs.getInt("ID");
				arrested.setIdentificative(newID);
			}else {
				log(Level.SEVERE, "Error generando el id autoincremental", null);
			}
			
			log(Level.SEVERE, "Completed", null);

		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR IN THE SQL SENTENCE: " + "INSERT INTO DetainedTable VALUES (?,?,?,?,?,?,?,?)", e);
		}
	}

	public static ArrayList<Object[]> consultarDatosArrested(String nombreBD) throws SQLException {
		
//		String consultaSQL = "SELECT * FROM " + nombreBD + ";";
//		try {
//			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
//			while (rs.next()) {
//				int identificative = rs.getInt("identificative");
//				String name = rs.getString("name");
//				String lastname = rs.getString("lastname");
//				int age = rs.getInt("age");
//				String gender = rs.getString("gender");
//				int NumberOfArrest = rs.getInt("NumberOfArrest");
//				String JailRelease = rs.getString("JailRelease");
//				String Citizenship = rs.getString("Citizenship");
//				String Description = rs.getString("Description");
//				System.out.println("Identificative of the Arrested: " + identificative + ". Name: " + name
//						+ ". Lastname: " + lastname + ". Age: " + age + ". Gender: " + gender + ". NumberOfArrest: "
//						+ NumberOfArrest + ". JailRelease: " + JailRelease + ". Citizenship: " + Citizenship
//						+ ". Description: " + Description);
//			}
//			rs.close();
//		} catch (Exception e) {
//			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
//		}
//	}
	
		ArrayList<Object[]> datos = new ArrayList<Object[]>();
		String consultaSQL = "SELECT * FROM " + nombreBD + ";";
		try {
			
			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
			
			while (rs.next()) {
				Object filas[]= new Object[9];
				for (int i = 0; i < filas.length; i++) {
					filas[i]= rs.getObject(i+1);
				}
				datos.add(filas);
			}
			
			rs.close();

		} catch (Exception e) {
			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
		}
		return datos;
	}
		
		

	// InsertarDatos con preparedStatement
	public static void insertIntoPrepStatFained(Fined fained) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO FainedTable( name, LastName, age, gender, description, cityzenship, payment) VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			Statement stmtForId= connection.createStatement();
			
			//insertSql.setLong(1, fained.getIdentificative());
			insertSql.setString(1, fained.getName());
			insertSql.setString(2, fained.getLastName());
			insertSql.setLong(3,fained.getAge());
			insertSql.setString(4, fained.getGender());
			insertSql.setString(5, fained.getDescription());
			insertSql.setString(6, fained.getCitizenship().toString());
			insertSql.setInt(7, (int) fained.getPayment());

			insertSql.executeUpdate();
			
			ResultSet rs= stmtForId.executeQuery("SELECT LAST_INSERT_ROWID() AS ID FROM  FainedTable" );
			if (rs.next()) {
				int newID= rs.getInt("ID");
				fained.setIdentificative(newID);
			}else {
				log(Level.SEVERE, "Error generando el id autoincremental", null);
			}
			
			log(Level.SEVERE, "Completed", null);

		} catch (SQLException e) {
			log(Level.SEVERE, " ERROR EN SENTENCIA SQL: " + " INSERT INTO FainedTable VALUES (?,?,?,?,?,?,?) ", e);
		}
	}

	public static ArrayList<Object[]> consultarDatosFained(String nombreBD) throws SQLException {
//		String consultaSQL = "SELECT * FROM " + nombreBD + ";";
//		try {
//			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
//			while (rs.next()) {
//				int identificative = rs.getInt("identificative");
//				String name = rs.getString("name");
//				String lastname = rs.getString("lastname");
//				int age = rs.getInt("age");
//				String gender = rs.getString("gender");
//				String Description = rs.getString("Description");
//				String Citizenship = rs.getString("Citizenship");
//				int Payment = rs.getInt("Payment");
//				System.out.println("Identificative of the Arrested: " + identificative + ". Name: " + name
//						+ ". Lastname: " + lastname + ". Age: " + age + ". Gender: " + gender + ". Description: "
//						+ Description + ". Citizenship: " + Citizenship + ". Payment: " + Payment);
//			}
//			rs.close();
//		} catch (Exception e) {
//			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
//		}
		
		ArrayList<Object[]> datos = new ArrayList<Object[]>();
		String consultaSQL = "SELECT * FROM " + nombreBD + ";";
		try {
			
			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
			
			while (rs.next()) {
				Object filas[]= new Object[8];
				for (int i = 0; i < filas.length; i++) {
					filas[i]= rs.getObject(i+1);
				}
				datos.add(filas);
			}
			
			rs.close();

		} catch (Exception e) {
			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
		}
		return datos;
	}
		
	
	

	// Cerrar conexion
	public static void closeBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			log(Level.INFO, "Close the database", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "An error has ocurred closing the database", e);
		}
	}

	// Borrar la table de la base de datos
	public static void dropTable(String nombreBD) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists DetainedTable");
			statement.executeUpdate("drop table if exists FainedTable");
			log(Level.INFO, "Deleted the tables", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "An error has ocurred deleting database", e);
		}
	}

}
