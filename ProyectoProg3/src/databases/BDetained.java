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
import classes.Workers2;

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
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error s� es correcto si la
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
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error s� es correcto si la
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

	public static Statement getStatement() {
		return statement;
	}

	// InsertarDatos con preparedStatement
	public static void insertIntoPrepStat(Arrested arrested) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO DetainedTable(ID, name, LastName, age, gender, numberOfArrest, description, jailRelease, cityzenship) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			Statement stmtForId= connection.createStatement();
			
			
			insertSql.setString(2, arrested.getName());
			insertSql.setString(3, arrested.getLastName());
			insertSql.setLong(4, arrested.getAge());
			insertSql.setString(5, arrested.getGender());
			insertSql.setLong(6, arrested.getNumberOfArrest());
			insertSql.setString(7, arrested.getDescription());
			insertSql.setString(8, arrested.getJailRelease());
			insertSql.setString(9, arrested.getCitizenship().toString());
		

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

	public  ArrayList<Arrested> consultarDatosArrested(){
	
		ArrayList<Arrested> datos = new ArrayList<Arrested>();
		String consultaSQL = "SELECT * FROM DetainedTable;";
		try {
			
			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
			
			while (rs.next()) {
				Arrested arrested= new Arrested();
				arrested.setIdentificative(rs.getInt(1));
				arrested.setName(rs.getString(2));
				arrested.setLastName(rs.getString(3));
				arrested.setAge(rs.getInt(4));
				arrested.setGender(rs.getString(5));
				arrested.setNumberOfArrest((rs.getInt(6)));
				arrested.setDescription(rs.getString(7));
				arrested.setJailRelease(rs.getString(8));
				Country c= Country.valueOf(rs.getString(9));
				arrested.setCitizenship(c);
				datos.add(arrested); 
			}
			
			rs.close();

		} catch (Exception e) {
			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
		}
		return datos;
	}
	

	public  void delete(Arrested arrested) {
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM DetainedTable WHERE ID=?")) {
			stmt.setInt(1, arrested.getIdentificative());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "No se pudo borrar el usuario en la BD", e);
		}
	}
	
		
		

	// InsertarDatos con preparedStatement
	public static void insertIntoPrepStatFained(Fined fained) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO FainedTable(ID, name, LastName, age, gender, description, cityzenship, payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			Statement stmtForId= connection.createStatement();
			
			insertSql.setString(2, fained.getName());
			insertSql.setString(3, fained.getLastName());
			insertSql.setLong(4,fained.getAge());
			insertSql.setString(5, fained.getGender());
			insertSql.setString(6, fained.getDescription());
			insertSql.setString(7, fained.getCitizenship().toString());
			insertSql.setLong(8,  fained.getPayment());

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

	public  ArrayList<Fined> consultarDatosFained()  {
		
		ArrayList<Fined> datos = new ArrayList<Fined>();
		String consultaSQL = "SELECT * FROM FainedTable;";
		try {
			
			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
			
			while (rs.next()) {
				Fined fined= new Fined();
				fined.setIdentificative(rs.getInt(1));
				fined.setName(rs.getString(2));
				fined.setLastName(rs.getString(3));
				fined.setAge(rs.getInt(4));
				fined.setGender(rs.getString(5));
				fined.setDescription(rs.getString(6));
				Country c= Country.valueOf(rs.getString(7));
				fined.setCitizenship(c);
				fined.setPayment(rs.getInt(8));
				datos.add(fined); 
			}
			
			rs.close();

		} catch (Exception e) {
			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
		}
		return datos;
	}
	
	
	public  void deleteFined(Fined fined) {
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM FainedTable WHERE ID=?")) {
			stmt.setInt(1, fined.getIdentificative());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			log(Level.SEVERE, "No se pudo borrar el usuario en la BD", e);
		}
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
