package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ArrayList;
import exceptions.views.*;


import java.util.Scanner;

/**
 * 
 * @author GRUPO 3
 *
 */
public class Console {
	
	private Scanner scanner;
	public static final String MESSAGE_NAME_OF_FARM = "				Bienvenido al Software DARXS\nPara empezar por favor ingrese el nombre de su finca :";
	public static final String ERROR_NAME = "\nEl nombre contiene menos de 4 caracteres, por favor intente nuevamente";
	public static final String MESSAGE_READ_GROUND_ANIMALS = "Ingrese en metros cuadrados el terreno que sera designado al cuidado de animales";
	public static final String ERROR_INVALIDATE_VALUE = "El valor ingresado no es correcto, intente nuevamente";
	public static final String MESSAGE_METRIC_ERROR = "El terreno no es óptimo";
	public static final String MESSAGE_INSUFICIENT_GROUND = "El terreno no concuerda con los valores dados anteriormente";
	public static final String MESSAGE_READ_GROUND_CROPS = "Ingrese en metros cuadrados el terreno que sera designado para siembra de cultivos";
	public static final String MESSAGE_READ_INITIAL_MONEY = "Ingrese la cantidad de dinero en COP con el que se iniciara la finca";
	public static final String MESSAGE_READ_USERNAME = "Ingrese un nombre de usuario";
	public static final String MESSAGE_READ_PASSWORD = "Ingrese una contraseña, antes de todo asegurese de que tenga:\n-Minimo 8 caracteres.\n-Una mayuscula.\n-Un numero";
	public static final String MESSAGE_READ_TOTAL_GROUND = "Ingrese en metros cuadradros el terreno total de la finca";
	public static final byte   MINIMUM_LAND = 50;
	public static final String MESSAGE_FOR_SHOW_HEADER = "					Finca ";
	public static final String MESSAGE_CHOOSE_OPTION = "Por favor, elija la opción que desea";
	public static final String MESSAGE_MAIN_MENU = "_________________________________________\n1. Administrador de cultivos.            |\n2. Administrador de bovinos.             |\n3. Administrador de gallineros.          |\n4. Administrador de panales de abejas.   |\n5. Cerrar sesion.                        |\n6. Cerrar el programa.                   |\n_________________________________________|";	
	public static final String MESSAGE_CROPS = "\n		Cultivos"; 
	public static final String ERROR_INVALID_OPTION = "No pudimos encontrar la opción seleccionada. Por favor, intentelo nuevamente. \n";
	public static final String MESSAGE_CROPS_MENU = "\n 1.Añadir cultivo.	\n 2.Mis cultivos.	\n 3.Mostrar número de cultivos en progreso por especie.	\n 4.R2.	\n 0.Volver atrás\n";
	public static final String MESSAGE_TO_CHOOSE_THE_TYPE_OF_PLANT = " Elija el tipo de planta que desea sembrar:	\n  1. Papa.	\n  2. Arveja.	\n  3. Frijol.	\n  4. Maiz";
	public static final String VALIDATOR_OF_DATE = "\\d{1,2}/\\d{1,2}/\\d{4}";
	public static final String FORMAT_OF_DATE = "d/M/yyyy";
	public static final String MESSAGE_FOR_ENTRY_SEED_DATE = "\nPor favor ingrese la fecha de creación del cultivo en formato \"d/M/yyyy\": ";
	public static final String MESSAGE_FOR_PLANTING_LAND = "Ingrese en metros cuadrados la cantidad de terreno que sera sembrada";
	public static final String MESSAGE_TO_SHOW_THE_OPTIMAL_SOWING_AMOUNT = "Gran eleccion de tierra, la cantidad de semilla optima para esta siembra es de : ";
	public static final String MESSAGE_IF_THEY_ARE_POUNDS = " libras.";
	public static final String MESSAGE_IF_THEY_ARE_ARROBAS = " arrobas.";
	public static final String MESSAGE_FOR_GREATER_EARTH = "La cantidad que acaba de ingresar excede los limites de tierra dados para la siembra, intente nuevamente";
	public static final String MESSAGE_FOR_SAVED_CROP = "\n¡¡¡Cultivo guarado con exito!!!";
	public static final String MESSAGE_FOR_VOID_LIST = "\n***Aún no hay elementos en esta lista***\n"; 
	public static final String MESSAGE_FOR_SHOW_NUMBER_CROPS_BY_SPECIE = "Mostrar el número de cultivos por especie.";
	public static final String MESSAGE_FOR_WAY_TO_ADD_CROP = "\n   1.Añadir un cultivo en curso.	\n   2.Añadir un cultivo finalizado. \n   0.Volver atrás"; 
	public static final String MESSAGE_FOR_READ_VALUE_EXPENSE_CROP = "\nPor favor, ingrese sus gastos totales para este cultivo";
	public static final String MESSAGE_FOR_READ_VALUE_OF_PRUDCTION_OBTAINED = "Por favor, ingrese la cantidad cosechada en bultos"; 
	public static final String MESSAGE_FOR_READ_PRICE_PER_PACKAGE = "Por favor, ingrese el precio al que vendió cada bulto de la mercancía"; 
	public static final String MESSAGE_FOR_CHOOSE_TYPE_CROP = "Por favor, elija qué tipo de cultivos desea visualizar\n \n   1.Cultivos en crecimiento. \n   2.Cultivos terminados. \n   0.Volver atrás.";
	public static final String MESSAGE_NUMBER_CROPS_BY_SPECIE = "";
	public static final String HEADER_CROPS_BY_SPECIE = "	   ---Cultivos por espeice---			"; 
	public static final String HEADER_TABLE = " _______________________________________________\n|\t\t\t|\t\t\t|\n|\t%s\t\t|\t%s\t|\n|_______________________|_______________________|\n";
	public static final String POTATO = "Papa"; 
	public static final String VETCH = "Arveja";
	public static final String BEANS = "Frijol";
	public static final String CORN = "Maíz";
	public static final Object[] HEADERS_PRODUCTS = {POTATO, VETCH, BEANS, CORN};
	public static final String SEPARATOR_TABLE_LINE = "|";
	public static final String FORMAT = "%1$-1s\t%2$-15s %3$-10s %4$-12s %5$-1s\n";
	public static final String FORMAT_PART_OF_TABLE = "%1$-26s %2$-10s\n";
	public static final String TYPE = "Tipo"; 
	public static final String AMOUNT = "Cantidad";
	public static final String FINAL_LINE = "|_______________________|_______________________|";
//	public static final String 
//	public static final String 
//	public static final String 


	
	/**
	 * Metodo constructor por default
	 */
	public Console() {
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Metodo para imprimir
	 * @param <E>
	 * @param input : Objeto a mostrar
	 */
	 public < E > void printData( E input) {
		 System.out.println(input);
	 }
	 
	 public < E > void validateLengthOfLists(ArrayList<E> input) {
		 if (input.size() <= 0) {
			 System.out.println(MESSAGE_FOR_VOID_LIST);
		 }
		 else
			 this.printData(input);
	 }
	 
	 public void printInTableFormat(int[] cropsInProgress) {
		 System.out.println(HEADER_CROPS_BY_SPECIE);
		 System.out.printf(HEADER_TABLE, TYPE, AMOUNT);
		 for(int i = 0; i < cropsInProgress.length; i++) {
			 System.out.println(String.format(FORMAT,SEPARATOR_TABLE_LINE, HEADERS_PRODUCTS[i],SEPARATOR_TABLE_LINE, cropsInProgress[i], SEPARATOR_TABLE_LINE));
		 }
		 System.out.println(FINAL_LINE);
	 }
	 public void showInvalidOptionMenu() {
		 System.out.println(ERROR_INVALID_OPTION);
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
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 5) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine();
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
		System.out.println(MESSAGE_TO_CHOOSE_THE_TYPE_OF_PLANT);
		String option = scanner.nextLine();
		while(!isNumeric(option) || Byte.parseByte(option) < 1 || Byte.parseByte(option) > 4) {
			System.out.println("Ponga el error");
			option = scanner.nextLine();
		}
		return Byte.parseByte(option);
	}
	
	public LocalDate readSeedTime() throws ExceptionDate{
		System.out.println(MESSAGE_FOR_ENTRY_SEED_DATE);
		return this.validateSeedTime(scanner.nextLine());
	}
	
	public LocalDate validateSeedTime(String seedTime) throws ExceptionDate{
		if(seedTime.matches( VALIDATOR_OF_DATE )) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_OF_DATE);
			return LocalDate.parse( seedTime, dateTimeFormatter );
		}
		else {
			throw new ExceptionDate();
			
		}
		
	}
	
	/**
	 * Metodo para obtener la cantidad de tierra que suara para el cultivo
	 * @return cantidad de tierra en metros cuadrados
	 */
	public double readAmountOfLand() {
		System.out.println(MESSAGE_FOR_PLANTING_LAND);
		String ground = scanner.nextLine();
		while(!isNumeric(ground)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			ground = scanner.nextLine();
		}
		return Double.parseDouble(ground);
	}
	

	
	public String showSowingAmount(double[] production) {
		String result = MESSAGE_TO_SHOW_THE_OPTIMAL_SOWING_AMOUNT;
		if(production[0] == 1) {
			result += (String.valueOf(production[1]) + MESSAGE_IF_THEY_ARE_ARROBAS);
		}else {
			result += (String.valueOf(production[1]) + MESSAGE_IF_THEY_ARE_POUNDS);
		}
		return result;
	}
	

	//MÉTODO QUIZÁ INUTILIZADO PARA DESPUÉS
	public void showNumberOfCropsBySpecieInProgress(int[] cropsInProgress) {
		System.out.println(HEADER_CROPS_BY_SPECIE);
		System.out.printf(HEADER_TABLE, TYPE, AMOUNT);
		System.out.printf(MESSAGE_NUMBER_CROPS_BY_SPECIE, cropsInProgress[0], cropsInProgress[1], cropsInProgress[2], cropsInProgress[3]);

	}
	
	
	public byte readOptionForWayToAdd() {
		System.out.println(MESSAGE_FOR_WAY_TO_ADD_CROP);
		String option = scanner.nextLine();
		while(!isNumeric(option) ||  Byte.parseByte(option) < 0 || Byte.parseByte(option) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine();
		}
		
		return Byte.parseByte(option);
	}
	
	public double readValueOfExpense() {
		System.out.println(MESSAGE_FOR_READ_VALUE_EXPENSE_CROP);
		String expense = scanner.nextLine();
		while(!isNumeric(expense)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			expense = scanner.nextLine();
		}
		
		return Double.parseDouble(expense);
	}
	
	public int readProductionObtained() {
		System.out.println(MESSAGE_FOR_READ_VALUE_OF_PRUDCTION_OBTAINED);
		String productionObtained = scanner.nextLine();
		while(!isNumeric(productionObtained)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			productionObtained = scanner.nextLine();
		}
		
		return Integer.parseInt(productionObtained);
	}
	
	public double readSalePricePerPackage() {
		System.out.println(MESSAGE_FOR_READ_PRICE_PER_PACKAGE);
		String price = scanner.nextLine();
		while(!isNumeric(price)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			price = scanner.nextLine();
		}
		
		return Double.parseDouble(price);
	}
	
	
	
	public byte readTypeOfCrop() {
		System.out.println(MESSAGE_FOR_CHOOSE_TYPE_CROP);
		String typeCrop = scanner.nextLine();
		while(!isNumeric(typeCrop) || Byte.parseByte(typeCrop) < 0 || Byte.parseByte(typeCrop) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			typeCrop = scanner.nextLine();
		}
		
		return Byte.parseByte(typeCrop);
	}
	
	
	
	
	
	
	
	
	
	
	
}
