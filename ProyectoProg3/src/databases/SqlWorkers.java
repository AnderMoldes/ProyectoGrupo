package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Specialty;

public class SqlWorkers {

	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;

	// Meodo local para loggear
	private static void log(Level level, String msg, Throwable excepcion) {
		if (!LOGGING)
			return;
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(SqlDetained.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}

	private static boolean LOGGING = true;

	// Conectarse a la base de datos

	public static Connection initBD(String nombreBD) {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			log(Level.INFO, "Conectada base de datos " + nombreBD, null);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e);
			return null;
		}
	}

	public static void conexion(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate(
						"create table " + nombreBD + " (int code, int grade, name string, surName string, gender string, specialty Specialty, startWorkingIn Date, Assesment String )");
			} catch (SQLException e) {
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error s� es correcto si la
																						// tabla ya existe
					log(Level.SEVERE, "La tabla " + nombreBD + " ya existe", e);
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e);
		}

	}

	public static void insertIntoPrepStat(int code, int grade, String name, String surname, String gender, long specialty,
			Date startWorkingIn, String assesment) {
		try {
			PreparedStatement insertSql = connection.prepareStatement("INSERT INTO workers VALUES (?,?,?,?,?,?,?,?)");

			insertSql.setInt(1, code);
			insertSql.setInt(2, grade);
			insertSql.setString(3, name);
			insertSql.setString(4, surname);
			insertSql.setString(5, gender);
			insertSql.setLong(6, specialty);
			insertSql.setDate(7, (java.sql.Date) startWorkingIn);
			insertSql.setString(8, assesment);

			insertSql.executeUpdate();

		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR EN SENTENCIA SQL: " + "INSERT INTO workers VALUES (?,?,?,?,?,?,?,?)", e);
		}
	}

	// Sacar los datos
	public static String getAlumno(int code) {
		try (PreparedStatement stmt = connection
				.prepareStatement("SELECT * FROM workers WHERE =" + code)) {

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String resul = rs.getInt("code") + " " + rs.getInt("grade") + " " + rs.getString("name") + " " + rs.getString("surName") +  " "
						+ rs.getString("gender") + " " + rs.getLong("specialty") + " " + rs.getDate("startWorkingIn") + " " + rs.getString("assesment");
				return resul;
			} else {
				return "";
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error obteniendo el worker con el code " + 0 + "minutos", (Throwable) e);
		}
		return "";
	}

	// Cerrar conexion
	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			log(Level.INFO, "Cierre de base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en cierre de base de datos", e);
		}
	}

}
