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
import classes.Fined;
import classes.Vehicle;

public class BDVehicles {
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
						+ " (ID integer primary key licensePlate, brand varchar, colour varchar, polices varchar)");
				
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
	
	public static void insertIntoPrepStatVehicle(Vehicle vehicle) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO VehicleTable( licenseePlate, brand, colour, polices) VALUES (?, ?, ?, ?)");
			
			Statement stmtForId= connection.createStatement();
			
			insertSql.setLong(1, vehicle.getLicensePlate());
			insertSql.setString(2, String.valueOf(vehicle.getBrand()));
			insertSql.setString(3,String.valueOf(vehicle.getColour()));
			insertSql.setString(4, String.valueOf(vehicle.getPolices()));

			insertSql.executeUpdate();
			
			log(Level.SEVERE, "Completed", null);

		} catch (SQLException e) {
			log(Level.SEVERE, " ERROR EN SENTENCIA SQL: " + " INSERT INTO VehicleTable VALUES (?,?,?,?) ", e);
		}
	}
	
	public static void delete(Vehicle vehicle) {
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM VehicleTable WHERE licensePlate=?")) {
			stmt.setInt(1, vehicle.getLicensePlate());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "No se pudo borrar el vehiculo en la BD", e);
		}
	}
	
	public static void update(Vehicle vehicle) {
		try (PreparedStatement stmt = connection.prepareStatement("UPDATE VehicleTable SET licensePlate=?, brand=?, colour=?, polices=?  WHERE licensePlate=?")) {
			stmt.setInt(1, vehicle.getLicensePlate());
			stmt.setString(2, String.valueOf(vehicle.getBrand()));
			stmt.setString(3,String.valueOf(vehicle.getColour()));
			stmt.setString(4, String.valueOf(vehicle.getPolices()));
			stmt.setInt(1, vehicle.getLicensePlate());
					
			stmt.executeUpdate();
			
			log(Level.SEVERE, "Completed", null);
			
		} catch (SQLException e) {
			log(Level.SEVERE, "No se pudo guardar el vehiculo en la BD", e);
		}
		
	}
	
	public static ArrayList<Object[]> consultarDatosVehicle(String nombreBD) throws SQLException {
		
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
	
	public static void dropTable(String nombreBD) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists" +nombreBD);
			log(Level.INFO, "Deleted the tables", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "An error has ocurred deleting database", e);
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

}
