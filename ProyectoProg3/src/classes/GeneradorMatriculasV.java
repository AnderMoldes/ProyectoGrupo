package classes;

import java.util.Random;

public class GeneradorMatriculasV {
	
	public  static  void  main ( String [] args ) {
		

			Random rand = new Random();
			int randomSize=numeroRandom(6, 12);

			String password=generarContrasenha(rand, "", 0, randomSize);
			System.out.println("password-->  "+password);
		}

		public static char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@',
				'$', '%', '^', '&' };

		// I think it makes more sense returning the generated string and passing along
		// the random number generator instead of recreating it at each recursive call

		public static String generarContrasenha(Random rand, String password, int posicion, int largo) {

			boolean isLowerCase = rand.nextBoolean();

			int randomChar = rand.nextInt(chars.length);

			char c = chars[randomChar];

			if (posicion == largo) {
				return password;
			}

			if (isLowerCase) {

				return generarContrasenha(rand, password + chars[randomChar], posicion + 1, largo);

			} else {
				return generarContrasenha(rand, password + Character.toUpperCase(c), posicion + 1, largo);
			}

		}

		private static int numeroRandom(int min, int max) {
			Random rand = new Random();
			int randomNum = rand.nextInt((max - min) + 1) + min;
			return randomNum;
		}

		
}
