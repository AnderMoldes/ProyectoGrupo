package classes;

import java.util.Random;

//recursive method to generate license plates

public class PlateGenerator {

	public static void main(String[] args) {

		Random rand = new Random();
		int randomSize = randomNumber(6, 12);

		String PlateL = plateLeterGenerator(rand, "", 0, randomSize);
		String plateN = generateNumbPlate(rand, "", 0, randomSize);

	}
	
	//All the characters
	public static char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	//All the numbers
	public static Number[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static String plateLeterGenerator(Random rand, String plate, int position, int longg) {

		int randomChar = rand.nextInt(chars.length);

		char c = chars[randomChar];

		if (position == longg) {
			return plate;
		}

		return plateLeterGenerator(rand, plate + Character.toUpperCase(c), position + 1, longg);

	}

	public static String generateNumbPlate(Random rand, String plate, int position, int longg) {

		int randomNumber = rand.nextInt(numbers.length);

		Number number = numbers[randomNumber];

		if (position == longg) {
			return plate;
		}

		return generateNumbPlate(rand, plate + numbers[randomNumber], position + 1, longg);

	}

	private static int randomNumber(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
