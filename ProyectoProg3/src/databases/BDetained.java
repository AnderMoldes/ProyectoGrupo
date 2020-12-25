package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Arrested;
import classes.Country;
import classes.Fined;

public class BDetained {
	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;
	
	// Loggin
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
	// Inicializar la Base de Datos
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
					statement.executeUpdate("create table "+nombreBD+" (identificative int, name string, LastName string, age int, gender string, numberOfArrest int, description string, jailRelease string, cityzenship string)");
					log( Level.SEVERE, "The table " + nombreBD + " created", null);
				} catch (SQLException e) {
					if (!e.getMessage().equals("table "+nombreBD+" already exists"))  // Este error sí es correcto si la tabla ya existe
						log( Level.SEVERE, "The table " + nombreBD + " already exists", e );
				}
			} catch (SQLException e) {
				log( Level.SEVERE, "Error coneccting to database " + nombreBD, e );
			}
			
		}
		
		// Conectarse a la base de datos
				public static void conectionFained(String nombreBD) {
					try {
						statement = connection.createStatement();
						try {
							statement.executeUpdate("create table "+nombreBD+" (identificative int, name string, LastName string, age int, gender string, description string, cityzenship string, payment int)");
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
		public static void insertInto( int identificative,int age, String name, String LastName, String gender,int numberOfArrest, String description, String jailRelease, Country cityzenship) {
			String sent = "insert into DetainedTable values(" + identificative + ", '" + name + "', " + LastName + ", "+ age + "', '"  + gender + ", " + description+ ", " + cityzenship+ ", " + jailRelease+ ")";
			try {
				statement = connection.createStatement();
				statement.executeUpdate(sent);
			} catch (SQLException e) {
				log( Level.SEVERE, "ERROR IN SQL: " + sent, e );
			}
		}
		// InsertarDatos con preparedStatement
		public static void insertIntoPrepStat( Arrested arrested){
			try {
				PreparedStatement insertSql=connection.prepareStatement("INSERT INTO DetainedTable VALUES (?,?,?,?,?,?,?,?,?)");
				
				insertSql.setLong(1,arrested.getIdentificative());
				insertSql.setString(2,arrested.getName());
				insertSql.setString(3,arrested.getLastName());
				insertSql.setLong(4,arrested.getAge());
				insertSql.setString(5,arrested.getGender());
				insertSql.setLong(6,arrested.getNumberOfArrest());
				insertSql.setString(7,arrested.getJailRelease());
				insertSql.setString(8,arrested.getCitizenship().toString());
				insertSql.setString(9,arrested.getDescription());
				
				
				insertSql.executeUpdate();
				log( Level.SEVERE, "Completed", null );
			
			} catch (SQLException e) {
				log( Level.SEVERE, "ERROR EN SENTENCIA SQL: " + "INSERT INTO DetainedTable VALUES (?,?,?,?,?,?,?,?,?)", e );
			}
		}
		
		
		// InsertarDatos con preparedStatement
				public static void insertIntoPrepStatFained( Fined fained){
					try {
						PreparedStatement insertSql=connection.prepareStatement("INSERT INTO FainedTable VALUES (?,?,?,?,?,?,?,?)");
						
						insertSql.setLong(1,fained.getIdentificative());
						insertSql.setString(2,fained.getName());
						insertSql.setString(3,fained.getLastName());
						insertSql.setLong(4,fained.getAge());
						insertSql.setString(5,fained.getGender());
						insertSql.setString(6,fained.getDescription());
						insertSql.setString(7,fained.getCitizenship().toString());
						insertSql.setInt(8,(int) fained.getPayment());
						
						
						insertSql.executeUpdate();
						log( Level.SEVERE, "Completed", null );
					
					} catch (SQLException e) {
						log( Level.SEVERE, "ERROR EN SENTENCIA SQL: " + "INSERT INTO FainedTable VALUES (?,?,?,?,?,?,?,?)", e );
					}
				}
	
	
	
	//Cerrar conexion
	public static void closeBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Close the database", null );
		} catch (SQLException e) {
			log( Level.SEVERE, "An error has ocurred closing the database", e );
		}
	}
	
	//Borrar la table de la base de datos
	public static void dropTable( String nombreBD ) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists DetainedTable" );
			statement.executeUpdate("drop table if exists FainedTable" );
			log( Level.INFO, "Deleted the tables", null );
		} catch (SQLException e) {
			log( Level.SEVERE, "An error has ocurred deleting database", e );
		}
	}
	
	

}
