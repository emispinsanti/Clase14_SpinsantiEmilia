import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String archivo1 = "src\\\\ExpReg.txt";
		String regex1 = "P[A|B]\\#[1-9]{2}_..[1-9][0-9]";

		File file_result1 = new File(archivo1);
		
		try (Scanner fileScn = new Scanner(file_result1, StandardCharsets.UTF_8)) {
			while (fileScn.hasNextLine()) {
				String linea = fileScn.nextLine();
				Pattern patron1 = Pattern.compile(regex1, Pattern.MULTILINE);
				Matcher coincidencia1 = patron1.matcher(linea);

				if (coincidencia1.find()) {

					System.out.println("la linea " + linea + " respecta el patron");
				} else {
					System.out.println("la linea " + linea + " NO respecta el patron");
				}

			}

		} catch (IOException e) {
			System.out.println("se produjo un error al leer el archivo" + e.getMessage());
		}

		System.out.println("\n*************************");

		String archivo2 = "src\\ExpReg.txt";
		String regex2 = "P[A|B]\\#([1-9|a-z]{3})_.(.[a-z][0-9])";

		File file_result2 = new File(archivo2);
		
		try (Scanner fileScn2 = new Scanner(file_result2, StandardCharsets.UTF_8)) {
			while (fileScn2.hasNextLine()) {
				String linea = fileScn2.nextLine();
				Pattern patron2 = Pattern.compile(regex2, Pattern.MULTILINE);
				Matcher coincidencia2 = patron2.matcher(linea);
			
				while (coincidencia2.find()) {
					System.out.println("Full match: " + coincidencia2.group(0));
					for (int i = 1; i <= coincidencia2.groupCount(); i++) {
						System.out.println("Grupo " + i + ": " + coincidencia2.group(i));
					}
				}
			}
		        
		} catch (IOException e) {
			System.out.println("se produjo un error al leer el archivo" + e.getMessage());
		}
	}

}