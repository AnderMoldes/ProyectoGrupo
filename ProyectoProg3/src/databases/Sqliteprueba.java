package databases;

import java.sql.*;

public class Sqliteprueba {

	public static void main(String[] args) {
		
		try {
			 Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
			 System.out.println("No se ha podido cargar el driver de la base de datos");
			}
		
		try {

			   // ESTABLECER LA CONEXIÓN
			   Connection conexion;
			   conexion = DriverManager.getConnection("jdbc:sqlite:bdpruebas.db");

			   // CREAR ENUNCIADO
			   Statement enunciado;
			   enunciado = conexion.createStatement();

			   // CREAR UNA TABLA NUEVA, LA BORRA SI EXISTE
			   enunciado.execute("DROP TABLE IF EXISTS tablapruebas;");
			   enunciado.execute("CREATE TABLE tablapruebas (id int primary key, aleatorio int);");

			   // INSERTAR DATOS
			   for (int i = 1; i <= 100; i++) {
			    enunciado.execute("INSERT INTO tablapruebas (id, aleatorio) values ("
			        + i
			        + ", "
			        + Math.floor(Math.random() * 100 + 1) + ");");
			   }

			   // CONSULTA DATOS
			   ResultSet resultados;
			   resultados = enunciado.executeQuery("SELECT * FROM tablapruebas;");

			   // PROCESAR EL RESULTADO
			   while (resultados.next()) {
			    System.out.println("id " + resultados.getString(1)
			      + ": aleatorio " + resultados.getString(2));
			   }

			   // CERRAR
			   resultados.close();
			   enunciado.close();
			   conexion.close();

			  } catch (Exception e) {
			   System.out.println("ERROR: " + e.getMessage());
			  }

	}

}
