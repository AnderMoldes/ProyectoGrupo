package databases;

import java.awt.Component;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


import classes.Boss;
import classes.Specialty;
import classes.Specialty.SpecialtyEnum;
import classes.Workers;
import classes.Workers2;
import windows.WindowWorkers;

public class BDWorkers{
	
	private static Logger logger = null;
	private static Connection connection;
	private static Statement statement;

	// Meodo local para loggear
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

	// Conectarse a la base de datos
	public static  Connection initBD(String nombreBD) {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			log(Level.INFO, "Conected to database " + nombreBD, null);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			log(Level.SEVERE, "An error has ocurred conecting to database " + nombreBD, e);
			return null;
		}
	}

	// Conectarse a la base de datos
	public static  void conection(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table " + nombreBD
						+ " (code integer primary key autoincrement, grade integer, name varchar, surname varchar, gender varchar, Specialty varchar, startWorkingIn varchar, Assessment varchar )");
				
				log(Level.SEVERE, "The table " + nombreBD + " created", null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error s� es correcto si la
																						// tabla ya existe
					log(Level.SEVERE, "The table " + nombreBD + " already exists", e);
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error conecting to database " + nombreBD, e);
		}
	}

	// Conectarse a la base de datos
	public static  void conectionBoss(String nombreBD) {
		try {
			statement = connection.createStatement();
			try {
				statement.executeUpdate("create table " + nombreBD
						+ " (code integer primary key autoincrement, grade integer, name varchar, surname varchar, "
						+ "gender varchar, Specialty varchar, startWorkingIn varchar, Assessment varchar, function varchar )");
				
				log(Level.SEVERE, "The table " + nombreBD + " created", null);
			} catch (SQLException e) {
				if (!e.getMessage().equals("table " + nombreBD + " already exists")) // Este error s� es correcto si la
																						// tabla ya existe
					log(Level.SEVERE, "The table " + nombreBD + " already exists", e);
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "Error conecting to database " + nombreBD, e);
		}

	}

	public Connection getConection() {
		return connection;
	}


	// InsertarDatos con preparedStatement
	public static  void insertIntoPrepStat(Workers2 workers) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO WorkersTable(code, grade, name, surname, gender, Specialty, startWorkingIn, Assessment)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			Statement stmtForId= connection.createStatement(); 
			
//			insertSql.setLong(1, workers.getCode());
			insertSql.setLong(2, workers.getGrade());
			insertSql.setString(3, workers.getName());
			insertSql.setString(4, workers.getSurname());
			insertSql.setString(5, workers.getGender());
			insertSql.setString(6, workers.getSpecialty().toString());
			insertSql.setString(7, (String) workers.getStartWorkingIn());
			insertSql.setString(8, workers.getAssesment());
			
			

			insertSql.executeUpdate();
			
			ResultSet rs= stmtForId.executeQuery("SELECT LAST_INSERT_ROWID() AS code FROM  WorkersTable" );
			if (rs.next()) {
				int newCode= rs.getInt("code");
				workers.setCode(newCode);
				
			}else {
				log(Level.SEVERE, "Error generando el id autoincremental", null);
			}

			log(Level.SEVERE, "Completed", null);
			

		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR IN THE SQL SENTENCE: " + "INSERT INTO WorkersTable VALUES (?,?,?,?,?,?,?)", e);
		}
	}

	public  ArrayList<Workers2> consultarDatos() {
		ArrayList<Workers2> datos = new ArrayList<Workers2>();
		String consultaSQL = "SELECT * FROM WorkersTable;";
		
		try {
			
			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
			
			while (rs.next()) {
				Workers2 workers2= new Workers2();
				workers2.setCode(rs.getInt(1));
				workers2.setGrade(rs.getInt(2));
				workers2.setName(rs.getString(3));
				workers2.setSurname(rs.getString(4));
				workers2.setGender(rs.getString(5));
				SpecialtyEnum e= SpecialtyEnum.valueOf(rs.getString(6));
				workers2.setSpecialty(e);
				workers2.setStartWorkingIn(rs.getString(7));
				workers2.setAssesment(rs.getString(8));
				datos.add(workers2);
			}
			
			rs.close();
			
		} catch (Exception e) {
			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
		}
		return datos;
		
	}
	
	public void delete(Workers2 workers) {
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM WorkersTable WHERE code=?")) {
			stmt.setInt(1, workers.getCode());
			stmt.executeUpdate();
			stmt.close();
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "No se pudo borrar el usuario en la BD", e);
		}
		
	}
	
	
	
	public static  void insertIntoPrepStatBoss(Boss boss) {
		try {
			PreparedStatement insertSql = connection.prepareStatement(
					"INSERT INTO WorkersTableBoss(code, grade, name, surname, gender, Specialty, startWorkingIn, Assessment, function)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			Statement stmtForId= connection.createStatement(); 
			
//			insertSql.setLong(1, boss.getCode());
			insertSql.setLong(2, boss.getGrade());
			insertSql.setString(3, boss.getName());
			insertSql.setString(4, boss.getSurname());
			insertSql.setString(5, boss.getGender());
			insertSql.setString(6, boss.getSpecialty().toString());
			insertSql.setString(7, boss.getStartWorkingIn().toString());
			insertSql.setString(8, boss.getAssesment());
			insertSql.setString(9, boss.getFunction());

			insertSql.executeUpdate();

			ResultSet rs = stmtForId.executeQuery("SELECT last_insert_rowid() AS code FROM WorkersTableBoss");
			if (rs.next()) {
				int newCode = rs.getInt("code");
				boss.setCode(newCode);
			} else {
				log(Level.SEVERE, "Error generando el id autoincremental", null);
			}
			
			log(Level.SEVERE, "Completed", null);

		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR IN THE SQL SENTENCE: " + "INSERT INTO WorkersTableBoss VALUES (?,?,?,?,?,?,?,?,?)",
					e);
		}
	}

	public  ArrayList<Boss> consultarDatosBoss() {
		
		ArrayList<Boss> datos = new ArrayList<Boss>();
		String consultaSQL = "SELECT * FROM WorkersTableBoss;";
		try {
			
			ResultSet rs = connection.createStatement().executeQuery(consultaSQL);
			
			while (rs.next()) {
				Boss boss= new Boss();
				boss.setCode(rs.getInt(1));
				boss.setGrade(rs.getInt(2));
				boss.setName(rs.getString(3));
				boss.setSurname(rs.getString(4));
				boss.setGender(rs.getString(5));
				SpecialtyEnum e= SpecialtyEnum.valueOf(rs.getString(6));
				boss.setSpecialty(e);
				boss.setStartWorkingIn(rs.getString(7));
				boss.setAssesment(rs.getString(8));
				boss.setFunction(rs.getString(9));
				datos.add(boss);
			}
			
			rs.close();

		} catch (Exception e) {
			log(Level.SEVERE, "ERROR AL RECUPERAR DATOS", e);
		}
		return datos;
	}
	
	
	
	public void deleteBoss(Boss boss) {
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM WorkersTableBoss WHERE code=?")) {
			stmt.setInt(1, boss.getCode());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			log(Level.SEVERE, "No se pudo borrar el usuario en la BD", e);
		}
		
	}

	
	
	// Cerrar conexion
	public  void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			log(Level.INFO, "Closing database", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error in the database", e);
		}
	}

	// Reiniciar
	public static  void dropTable(String nombreBD) {
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists WorkersTable");
			statement.executeUpdate("drop table if exists WorkersTableBoss");
			log(Level.INFO, "Deleted the tables", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "An error has ocurred deleting database", e);
		}
	}

	public static Connection getConnection() {
		return connection;
	}


	public static Statement getStatement() {
		return statement;
	}

	
	
	

}