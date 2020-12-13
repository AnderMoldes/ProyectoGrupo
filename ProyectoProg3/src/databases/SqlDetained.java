package databases;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlDetained {
	
	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;
	
	// Meodo local para loggear
		private static void log( Level level, String msg, Throwable excepcion ) {
			if (!LOGGING) return;
			if (logger==null) {  // Logger por defecto local:
				logger = Logger.getLogger( SqlDetained.class.getName() );  // Nombre del logger - el de la clase
				logger.setLevel( Level.ALL );  // Loguea todos los niveles
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
				log( Level.INFO, "Conectada base de datos " + nombreBD, null );
			    return connection;
			} catch (ClassNotFoundException | SQLException e) {
				log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
				return null;
			}
		}
		
		public static void conexion(String nombreBD) {
			try {
				statement = connection.createStatement();
				try {
					statement.executeUpdate("create table "+nombreBD+" (name string, lastName string, age integer, gender string)");
				} catch (SQLException e) {
					if (!e.getMessage().equals("table "+nombreBD+" already exists"))  // Este error s� es correcto si la tabla ya existe
						log( Level.SEVERE, "La tabla " + nombreBD + " ya existe", e );
				}
			} catch (SQLException e) {
				log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
			}
			
		}
		
		public static void insertIntoPrepStat( String name, String lastName, int age, String gender){
			try {
				PreparedStatement insertSql=connection.prepareStatement("INSERT INTO detained VALUES (?,?,?,?)");
				
				insertSql.setString(1,name);
				insertSql.setString(2,lastName);
				insertSql.setInt(3,age);
				insertSql.setString(4,gender);
				
				insertSql.executeUpdate();
			
			} catch (SQLException e) {
				log( Level.SEVERE, "ERROR EN SENTENCIA SQL: " + "INSERT INTO detained VALUES (?,?,?,?)", e );
			}
		}
		
		// Sacar los datos
		public static String getAlumno(String name, String lastName) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM detained WHERE ="+name+ "and lastname=" +lastName)) {

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                String resul= rs.getString("nombre")+" "+rs.getString("last Name")+" "+rs.getInt("age") +" "+rs.getString("gender") ;
	                return resul;
	            } else {
	                return "";
	            }
	        } catch (SQLException  e) {
	        	log( Level.SEVERE, "Error obteniendo el detained con name " + 0+ "and lastName" +0+ "minutos", (Throwable) e );
	        }
			return "";
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
		
	
}
