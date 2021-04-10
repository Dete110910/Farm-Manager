package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import java.util.Scanner;

/**
 * 
 * @author GRUPO 3
 *
 */
public class Console {
	
	private Scanner scanner;
	public static String MESSAGE_NAME_OF_FARM = "				Bienvenido al Software DARXS\nPara empezar por favor ingrese el nombre de su finca :";
	public static String ERROR_NAME = "\nEl nombre contiene menos de 4 caracteres, por favor intente nuevamente";
	public static String MESSAGE_READ_GROUND_ANIMALS = "Ingrese en metros cuadrados el terreno que sera designado al cuidado de animales";
	public static String ERROR_INVALIDATE_VALUE = "El valor ingresado no es correcto, intente nuevamente";
	public static String MESSAGE_METRIC_ERROR = "El terreno no es óptimo";
	public static String MESSAGE_INSUFICIENT_GROUND = "El terreno no concuerda con los valores dados anteriormente";
	public static String MESSAGE_READ_GROUND_CROPS = "Ingrese en metros cuadrados el terreno que sera designado para siembra de cultivos";
	public static String MESSAGE_READ_INITIAL_MONEY = "Ingrese la cantidad de dinero en COP con el que se iniciara la finca";
	public static String MESSAGE_READ_USERNAME = "Ingrese un nombre de usuario";
	public static String MESSAGE_READ_PASSWORD = "Ingrese una contraseña, antes de todo asegurese de que tenga:\n-Minimo 8 caracteres.\n-Una mayuscula.\n-Un numero";
	public static String MESSAGE_READ_TOTAL_GROUND = "Ingrese en metros cuadradros el terreno total de la finca";
	public static byte 	 MINIMUM_LAND = 50;
	public static String MESSAGE_FOR_SHOW_HEADER = "					Finca ";
	public static String MESSAGE_CHOOSE_OPTION = "Por favor, elija la opción que desea";
	public static String MESSAGE_MAIN_MENU = "_________________________________________\n1. Administrador de cultivos.            |\n2. Administrador de bovinos.             |\n3. Administrador de gallineros.          |\n4. Administrador de panales de abejas.   |\n5. Cerrar sesion.                        |\n6. Cerrar el programa.                   |\n_________________________________________|";	
	public static String MESSAGE_CROPS = "Cultivos \n"; 
	public static String ERROR_INVALID_OPTION = "No pudimos encontrar la opción seleccionada \n";
	public static String MESSAGE_CROPS_MENU = "	\n1.Añadir cultivo.	\n2.Mis cultivos.	\n3.Registrar cultivo.	\n4.R2.	\n0.Volver atrás";
	public static String MESSAGE_CHOOSE_TYPE_CROP = "";
	public static String MESSAGE_TO_CHOOSE_THE_TYPE_OF_PLANT = "1. Papa.\n2. Arveja.\n3. Frijol.\n4. Maiz";
	public static final String FORMAT_OF_DATE = "d/M/yyyy";
	public static final String MESSAGE_FOR_ENTRY_SEED_DATE = "\nPor favor ingrese la fecha de creación del cultivo en formato \"d/M/yyyy\": ";


	
	/**
	 * Metodo constructor por default
	 */
	public Console() {
		scanner = new Scanner(System.in);
	}
	
	
	public void print(String string) {
		System.out.println(string);
	}
	
	/**
	 * Método para elegir la opción deseada en el menú principal
	 * @return opción elegida por el usuario
	 */
	public byte readOptionMainMenu() {
		System.out.println(MESSAGE_CHOOSE_OPTION);
		System.out.println(MESSAGE_MAIN_MENU);
		String option = scanner.nextLine();
		if(!isNumeric(option) || Byte.parseByte(option) < 1 || Byte.parseByte(option) > 6) {
			System.err.println(ERROR_INVALID_OPTION);
			return readOptionMainMenu();
		}
		return Byte.parseByte(option); 
	}
	
	/**
	 * Método para elegir la opción deseada en el menú de los cultivos
	 * @return opción elegida por el usuario
	 */
	public byte readOptionMenuCrop() {
		System.out.println(MESSAGE_CHOOSE_OPTION);
		System.out.println(MESSAGE_CROPS_MENU);
		String option = scanner.nextLine();
		if(!isNumeric(option) || Byte.parseByte(option) < 1 || Byte.parseByte(option) > 5) {
			System.out.println(ERROR_INVALID_OPTION);
			return readOptionMenuCrop();
		}
		return Byte.parseByte(option);
		
	}
	
	/**
	 * Metodo privado para determinar si una cadena de texto es o no numero
	 * @param cadena : String a evaluar
	 * @return true : Si es numero, false : No es numero
	 */
	private static boolean isNumeric(String string){
		try {
			Double.parseDouble(string);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/**
	 * Metodo hecho para obtener el nombre de la finca
	 * @return String con 4 caracteres o mas que es el nombre de la finca
	 */
	public String readNameOfFarm() {
		System.out.println(MESSAGE_NAME_OF_FARM);
		String name = scanner.nextLine();
		while (name.length() < 4) {
			System.out.println(ERROR_NAME);
			name = scanner.nextLine();
		}
		return name;
	}
	
	/**
	 * Metodo para obtener el terreno en m2 que sera usado para la crianza y cuidado de animales
	 * @return numero de m2 
	 */
	private double readGroundOfAnimals() {
		System.out.println(MESSAGE_READ_GROUND_ANIMALS);
		String groundAnimals = scanner.nextLine();
		while(!isNumeric(groundAnimals) || Double.parseDouble(groundAnimals) < MINIMUM_LAND) {
			System.out.println(MESSAGE_METRIC_ERROR);
			groundAnimals = scanner.nextLine();
		}
		return Double.parseDouble(groundAnimals);
	}
	
	/**
	 * Metodo para obtener el terreno en m2 que sera usado para la siembra de cultivos
	 * @return numero de m2 
	 */
	private double readGroundCrop(){
		System.out.println(MESSAGE_READ_GROUND_CROPS);
		String grounCrops = scanner.nextLine();
		while(!isNumeric(grounCrops) || Double.parseDouble(grounCrops) < MINIMUM_LAND) {
			System.out.println(MESSAGE_METRIC_ERROR);
			grounCrops = scanner.nextLine();
		}
		return Double.parseDouble(grounCrops);
	}
	
	public double[] readGrounds() {
		double[] grounds = new double[3];
		grounds[0] = readGroundOfAnimals();
		grounds[1] = readGroundCrop();
		System.out.println(MESSAGE_READ_TOTAL_GROUND);
		String totalGround = scanner.nextLine();
		while(!isNumeric(totalGround) || (grounds[0] + grounds[1] + MINIMUM_LAND > Double.parseDouble(totalGround))) {
			System.out.println(MESSAGE_INSUFICIENT_GROUND);
			totalGround = scanner.nextLine();
		}
		grounds[2] = Double.parseDouble(totalGround);
		return grounds;
	}
	
	/**
	 * Meotodo para obtener la cantidad de dinero con la que se iniciara la finca
	 * @return cantidad numerica de dinero
	 */
	public double readInitialCapital(){
		System.out.println(MESSAGE_READ_INITIAL_MONEY);
		String money = scanner.nextLine();
		while(!isNumeric(money)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			money = scanner.nextLine();
		}
		return Double.parseDouble(money);
	}
	
	/**
	 * Metodo para obtener el nombre de usuario de la app
	 * @return nombre de usuario
	 */
	public String readUsername() {
		System.out.println(MESSAGE_READ_USERNAME);
		String username = scanner.nextLine();
		while(username.length() < 4) {
			System.out.println(ERROR_NAME);
			username = scanner.nextLine();
		}
		return username;
	}
	
	/**
	 * Metodo para saber si una cadena de caracteres contiene una letra mayuscula
	 * @param string
	 * @return
	 */
	public boolean isValidate1(String string) {
		if(string.length() > 0) {
			for (int i = 0; i < string.length(); i++) {
				if(Character.isUpperCase(string.charAt(i))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo para validar si una cadena de texto contiene un numero
	 * @param string cadena a evaluar
	 * @return true : contiene almenos un numero ; false : no contiene ni un numero
	 */
	public boolean isValidate2(String string) {
		if(string.length() > 0) {
			for (int i = 0; i < string.length(); i++) {
				if(string.charAt(i) > 47 && string.charAt(i) < 58) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodo para obtener la contraseña 
	 * @return contraseña
	 */
	public String readPassword() {
		System.out.println(MESSAGE_READ_PASSWORD);
		String password = scanner.nextLine();
		while(password.length() < 8 || !isValidate1(password) || !isValidate2(password)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			System.out.println(MESSAGE_READ_PASSWORD);
			password = scanner.nextLine();
		}
		return password;
	}
	
	public byte readPlantTypeOption() {
		System.out.println(ERROR_INVALID_OPTION);
		String option = scanner.nextLine();
		while(!isNumeric(option) || Byte.parseByte(option) < 1 || Byte.parseByte(option) > 4) {
			System.out.println("Ponga el error");
			option = scanner.nextLine();
		}
		return Byte.parseByte(option);
	}
	
	public LocalDate readSeedTime(){
		System.out.println(MESSAGE_FOR_ENTRY_SEED_DATE);
		return this.validateSeedTime(scanner.nextLine());
	}
	
	public LocalDate validateSeedTime(String seedTime){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( FORMAT_OF_DATE );
		return LocalDate.parse( seedTime, dateTimeFormatter );
	}
	
//	public static void main(String[] ss) {
//		Console sss = new Console();
//		
//		System.out.println(sss.readOptionMainMenu());
//	}
	
	
	
}