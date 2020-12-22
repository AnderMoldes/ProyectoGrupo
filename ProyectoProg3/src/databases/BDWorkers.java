package databases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Workers;

public class BDWorkers {
	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;
	
	// Meodo local para loggear
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (!LOGGING) return;
		if (logger==null) {  
			logger = Logger.getLogger( BDWorkers.class.getName() ); 
			logger.setLevel( Level.ALL );
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
	private static boolean LOGGING = true;
	// Conectarse a la base de datos
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			log( Level.INFO, "Conected to database " + nombreBD, null );
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			log( Level.SEVERE, "An error has ocurred conecting to database " + nombreBD, e );
			return null;
		}
	}
	// Conectarse a la base de datos
	public static void conection(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table "+nombreBD+" (code int, grade int, name string, surname string, gender string, Specialty string, startWorkingIn string,Assessment string )");
				log( Level.SEVERE, "The table " + nombreBD + " created", null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table "+nombreBD+" already exists"))  // Este error sí es correcto si la tabla ya existe
					log( Level.SEVERE, "The table " + nombreBD + " already exists", e );
			}
		} catch (SQLException e) {
			log( Level.SEVERE, "Error conecting to database " + nombreBD, e );
		}
		
	}
	public Connection getConection() {
		return connection;
	}
	//InsertarDatos
	public static void insertInto( String code,String grade, String name, String surname, String gender,String Specialty, String startWorkingIn, String Assessment) {
		String sent = "insert into WorkersTable values(" + code + ", '" + grade + "', '" + name + "', " + surname + ", " + gender + ", " + Specialty+ ", " + startWorkingIn+ ", " + Assessment+  ")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			log( Level.SEVERE, "ERROR IN SQL: " + sent, e );
		}
	}
	// InsertarDatos con preparedStatement
	public static void insertIntoPrepStat( Workers workers){
		try {
			PreparedStatement insertSql=connection.prepareStatement("INSERT INTO WorkersTable(code, grade, name, surname, gender, Specialty, startWorkingIn, Assessment)  VALUES (?,?,?,?,?,?,?,?)");
			
			insertSql.setLong(1,workers.getCode());
			insertSql.setLong(2,workers.getGrade());
			insertSql.setString(3,workers.getName());
			insertSql.setString(4,workers.getSurname());
			insertSql.setString(5,workers.getGender());
			insertSql.setString(6,workers.getSpecialty().toString());
			insertSql.setString(7, workers.getStartWorkingIn().toString());
			insertSql.setString(8,workers.getAssesment());
			
			insertSql.executeUpdate();
			
			log( Level.SEVERE, "Completed", null );
			
		} catch (SQLException e) {
			log( Level.SEVERE, "ERROR IN THE SQL SENTENCE: " + "INSERT INTO Workers VALUES (?,?,?,?,?,?,?,?)", e );
		}
	}
	
	
	
	//Cerrar conexion
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Closing database", null ); 
		} catch (SQLException e) {
			log( Level.SEVERE, "Error in the database", e );
		}
	}
	
	//Reiniciar 
	public static void dropTable( String nombreBD ) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists WorkersTable" );
			log( Level.INFO, "Deleted the table", null );
		} catch (SQLException e) {
			log( Level.SEVERE, "An error has ocurred deleting database", e );
		}
	}
	
	
}