package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDetained {
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
			log( Level.SEVERE, "An error has ocurred connecting to database " + nombreBD, e );
			return null;
		}
	}
	// Conectarse a la base de datos
	public static void conection(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table "+nombreBD+" (identificative string,name string,LastName string, age string,gender string,numberOfArrest string, description string,jailRelease string,cityzenship string,payment string)");
				log( Level.SEVERE, "The table " + nombreBD + " created", null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table "+nombreBD+" already exists"))  // Este error sí es correcto si la tabla ya existe
					log( Level.SEVERE, "The table " + nombreBD + " already exists", e );
			}
		} catch (SQLException e) {
			log( Level.SEVERE, "Error coneccting to database " + nombreBD, e );
		}
		
	}
	public Connection getConection() {
		return connection;
	}
	//InsertarDatos
	public static void insertInto( String identificative,String age, String name, String LastName, String gender,String numberOfArrest, String description, String jailRelease,String cityzenship,String payment) {
		String sent = "insert into Workers values(" + identificative + ", '" + name + "', " + LastName + ", "+ age + "', '"  + gender + ", " + description+ ", " + cityzenship+ ", " + jailRelease+ ", " + payment+")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sent);
		} catch (SQLException e) {
			log( Level.SEVERE, "ERROR IN SQL: " + sent, e );
		}
	}
	// InsertarDatos con preparedStatement
	public static void insertIntoPrepStat( String identificative,String age, String name, String LastName, String gender,String numberOfArrest, String description, String jailRelease,String cityzenship,String payment){
		try {
			PreparedStatement insertSql=connection.prepareStatement("INSERT INTO Workers VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
			insertSql.setString(1,identificative);
			insertSql.setString(2,name);
			insertSql.setString(3,LastName);
			insertSql.setString(4,age);
			insertSql.setString(5,gender);
			insertSql.setString(6,numberOfArrest);
			insertSql.setString(7,jailRelease);
			insertSql.setString(8,cityzenship);
			insertSql.setString(9,description);
			insertSql.setString(10,payment);
			
			insertSql.executeUpdate();
		
		} catch (SQLException e) {
			log( Level.SEVERE, "ERROR EN SENTENCIA SQL: " + "INSERT INTO Workers VALUES (?,?,?,?,?,?,?,?,?,?)", e );
		}
	}
	
	
	
	//Cerrar conexion
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en cierre de base de datos", e );
		}
	}
	
	//Reiniciar 
	public static void dropTable( String nombreBD ) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists Workers" );
			log( Level.INFO, "Deleted the table", null );
		} catch (SQLException e) {
			log( Level.SEVERE, "An error has ocurred deleting database", e );
		}
	}
	
	

}
