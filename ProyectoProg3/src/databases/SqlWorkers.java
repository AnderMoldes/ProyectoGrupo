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
import classes.Workers;

public class SqlWorkers {

	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;

	// Meodo local para loggear
	private static void log(Level level, String msg, Throwable excepcion) {
		if (!LOGGING)
			return;
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(SqlWorkers.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}

	private static boolean LOGGING = true;

	// Conectarse a la base de datos

	public  Connection initBD(String nombreBD) {
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

	public  void conexion() {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS workers (code INTEGER PRIMARY KEY AUTOINCREMENT, grande INTEGER, name VARCHAR, surname VARCHAR, gender VARCHAR,Specialty VARCHAR, startWorkingIn DATE,  Assesment VARCHAR )");
				log(Level.INFO, "Creada tabla " , null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table workers already exists")) // Este error s� es correcto si la
																						// tabla ya existe
					log(Level.SEVERE, "La tabla 'workers' ya existe", e);
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en conexión de base de datos 'workers' ", e);
		}

	}

	
	//InsertarDatos
		public static void insertInto( int code, int grade, String name, String surname, String gender ,String specialty,Date startWorkingIn, String assesment) {
			String sent = "insert into Alumnos values(" + code + ", '" + grade + "', '" + name + "', " + surname + ", " + gender + ", " + specialty + ", " + startWorkingIn + ", " + assesment +
					")";
			//String sent = "drop table if exists Alumnos";
			try {
				statement = connection.createStatement();
				statement.executeUpdate(sent);
			} catch (SQLException e2) {
				log( Level.SEVERE, "ERROR EN SENTENCIA SQL: " + sent, e2 );
			}
		}

	public void insertIntoPrepStat(Workers workers) {
		try {
			PreparedStatement insertSql = connection.prepareStatement("INSERT INTO workers(code, grade, name, surname, gender, specialty, startWorkingIn, assesment) VALUES (?,?,?,?,?,?,?,?)");
			
			insertSql.setInt(1, workers.getCode());
			insertSql.setInt(2, workers.getGrade());
			insertSql.setString(3, workers.getName());
			insertSql.setString(4, workers.getSurname());
			insertSql.setString(5, workers.getGender());
			insertSql.setString(6, workers.getSpecialty().toString());
			insertSql.setDate(7, (java.sql.Date) workers.getStartWorkingIn());
			insertSql.setString(8, workers.getAssesment());

			insertSql.executeUpdate();

		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR EN SENTENCIA SQL: " + "INSERT INTO workers(code, grade, name, surname, gender, specialty, startWorkingIn, assesment) VALUES (?,?,?,?,?,?,?,?)", e);
		}
	}



	// Sacar los datos
	public  String getAlumno(int code) {
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
	public  void cerrarBD(Connection con, Statement st) {
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
	
	public void dropUserTable() {
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate("DROP TABLE IF EXISTS workers");
		} catch (SQLException e) {
			log(Level.SEVERE, "Error borrando la tabla 'workers' en la BD", e);
		}
	}

}
