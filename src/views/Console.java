package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import exceptions.views.*;
import utilities.Utilities;
import static java.time.temporal.ChronoUnit.DAYS;



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
	public static final String MESSAGE_READ_GROUND_ANIMALS = "Ingrese en metros cuadrados el terreno que será designado al cuidado de animales";
	public static final String ERROR_INVALIDATE_VALUE = "El valor ingresado no es correcto, intente nuevamente";
	public static final String MESSAGE_METRIC_ERROR = "El terreno no es óptimo";
	public static final String MESSAGE_INSUFICIENT_GROUND = "El terreno no concuerda con los valores dados anteriormente";
	public static final String MESSAGE_READ_GROUND_CROPS = "Ingrese en metros cuadrados el terreno que será designado para siembra de cultivos";
	public static final String MESSAGE_READ_INITIAL_MONEY = "Ingrese la cantidad de dinero en COP con el que se iniciara la finca";
	public static final String MESSAGE_READ_USERNAME = "Ingrese un nombre de usuario";
	public static final String MESSAGE_READ_PASSWORD = "Ingrese una contraseña, antes de todo asegurese de que tenga:\n-Minimo 8 caracteres.\n-Una mayuscula.\n-Un numero";
	public static final String MESSAGE_READ_TOTAL_GROUND = "Ingrese en metros cuadradros el terreno total de la finca";
	public static final byte   MINIMUM_LAND = 50;
	public static final String MESSAGE_FOR_SHOW_HEADER = "					Finca ";
	public static final String MESSAGE_CHOOSE_OPTION = "\nPor favor, elija la opción que desea";
	public static final String MESSAGE_MAIN_MENU =    "_________________________________________\n1. Administrador de cultivos."
													+ "            |\n2. Administrador de bovinos.             "
													+ "|\n3. Administrador de gallineros.          "
													+ "|\n4. Administrador de panales de abejas.   "
													+ "|\n5. Cerrar sesion.                        "
													+ "|\n6. Cerrar el programa.                   "
													+ "|\n_________________________________________|";	
	
	public static final String MESSAGE_CROPS = "\n		Cultivos"; 
	public static final String ERROR_INVALID_OPTION = "No pudimos encontrar la opción seleccionada. Por favor, intentelo nuevamente. \n";
	public static final String MESSAGE_CROPS_MENU =   "\n 1.Añadir cultivo.	"
													+ "\n 2.Añadir gasto a un cultivo	"
													+ "\n 3.Mis cultivos.	"
													+ "\n 4.Mostrar número de cultivos en progreso por especie.	"
													+ "\n 5.Mostrar número de cultivos por especie finalizados.	"
													+ "\n 6.Obtener porcentaje de crecimiento por especie.		"
													+ "\n 7.Obtener porcentaje de tierra ocupada por tipo de planta	"
													+ "\n 8.Obtener porcentaje de gastos por tipo de cultivo "
													+ "\n 9.Obtener porcentaje de cultivos en la granja"
													+ "\n 10.Obtener gastos por cultivo		"
													+ "\n 11.Finalizar cultivo		"
													+ "\n 0.Volver atrás\n";
	
	public static final String MESSAGE_END_CROPS_MENU = "\n Elija de qué forma quiere terminar su cultivo\n"
													  + "\n  1.Por cosecha.  "
													  + "\n  2.Por daños."
													  + "\n  0.Cancelar.";
	
	public static final String MESSAGE_TO_CHOOSE_THE_TYPE_OF_PLANT = " Elija el tipo de planta que desea:\n	\n  "
																	+ "1. Papa.	\n  "
																	+ "2. Arveja.	\n  "
																	+ "3. Frijol.	\n  "
																	+ "4. Maiz		\n  \n  "
																	+ "0.Volver a \"Cultivos\"";
	public static final String VALIDATOR_OF_DATE = "\\d{1,2}/\\d{1,2}/\\d{4}";
	public static final String FORMAT_OF_DATE = "d/M/yyyy";
	public static final String MESSAGE_FOR_ENTRY_SEED_DATE = "\nPor favor ingrese la fecha de creación del cultivo en formato \"d/M/yyyy\": ";
	public static final String MESSAGE_FOR_PLANTING_LAND = "Ingrese en metros cuadrados la cantidad de terreno que desea usar para la siembra";
	public static final String MESSAGE_TO_SHOW_THE_OPTIMAL_SOWING_AMOUNT_IN_ARROBAS = "\nGran eleccion de tierra, la cantidad de semilla optima para esta siembra es de : %1.2f arrobas\n";
	public static final String MESSAGE_TO_SHOW_THE_OPTIMAL_SOWING_AMOUNT_IN_POUNDS = "\nGran eleccion de tierra, la cantidad de semilla optima para esta siembra es de : %1.2f libras\n";
	public static final String MESSAGE_FOR_GREATER_EARTH = "La cantidad que acaba de ingresar excede los limites de tierra dados para la siembra, intente nuevamente";
	public static final String MESSAGE_FOR_SAVED_CROP = "\n¡¡¡Cultivo guardado con exito!!!";
	public static final String MESSAGE_FOR_VOID_LIST = "\n***Aún no hay elementos en esta lista***\n"; 
	public static final String MESSAGE_FOR_SHOW_NUMBER_CROPS_BY_SPECIE_FINISHED = "Mostrar el número de cultivos por especie terminados.";
	public static final String MESSAGE_FOR_WAY_TO_ADD_CROP = "\n   1.Añadir un cultivo en curso.	\n   2.Añadir un cultivo finalizado. \n   0.Volver atrás"; 
	public static final String MESSAGE_FOR_READ_VALUE_EXPENSE_CROP_FINISHED = "\nPor favor, ingrese sus gastos totales para este cultivo";
	public static final String MESSAGE_FOR_READ_VALUE_INITIAL_EXPENSE_CROP_IN_PROGRESS = "\nPor favor, ingrese la cantidad que invirtió de dinero en este cultivo";
	public static final String MESSAGE_FOR_READ_VALUE_OF_SOLD_PACKAGES = "Por favor, ingrese la cantidad de bultos vendidos"; 
	public static final String MESSAGE_FOR_READ_PRICE_PER_PACKAGE_FINISHED = "Por favor, ingrese el precio al que vendió cada bulto"; 
	public static final String MESSAGE_FOR_READ_PRICE_PER_PACKAGE_IN_PROGRESS = "Por favor, ingrese el precio al que venderá cada bulto"; 
	public static final String MESSAGE_FOR_READ_NUMBER_PACKAGES_HARVEST = "Por favor, ingrese la cantidad de bultos que logró cosechar."; 
	public static final String MESSAGE_FOR_READ_PRICE_ID_CROP_FINISHED = "Por favor, ingrese el id que desea asignarle a su cultivo finalizado"; 
	public static final String MESSAGE_FOR_READ_ID_CROP_FINISHED = "Por favor, ingrese el precio al que vendió cada bulto de la mercancía"; 
	public static final String MESSAGE_FOR_CHOOSE_TYPE_CROP = "\nPor favor, elija qué tipo de cultivos desea visualizar\n "
															+ "\n   1.Cultivos en crecimiento. "
															+ "\n   2.Cultivos terminados. "
															+ "\n   0.Volver atrás.";
	public static final String MESSAGE_NUMBER_CROPS_BY_SPECIE = "";
	public static final String HEADER_CROPS_BY_SPECIE_IN_PROGRESS = "    ---Cultivos por especie en progreso---			"; 
	public static final String HEADER_CROPS_BY_SPECIE_FINISHED = "    ---Cultivos por especie finalizados---			"; 
	public static final String HEADER_TABLE = " _______________________________________________\n|\t%1$-16s|\t%2$-11s\t|\n|_______________________|_______________________|\n";
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
	public static final String CONCEPT = "Concepto";
	public static final String VALUE = "Valor";
	public static final String MESSAGE_CHOOSE_CROP_OPTION = "Por favor, seleccione el id del cultivo que desea.";
	public static final String MESSAGE_CHOOSE_TYPE_EXPENSE = "Por favor, elija el tipo de gasto que desea agregar: \n  1. Siembra.	\n  2. Cuidados.		\n  3. Preparación de tierra.	\n  4. Cosecha.		\n\n  0. Cancelar.";
	public static final String MESSAGE_FOR_READ_PRICE_EXPENSE_TYPE_CROP = "Por favor, ingrese el valor del gasto: "; 
	public static final String MESSAGE_FOR_CROP_FINISHED = "			**Tiene %d cultivo listo para cosechar**";
	public static final String MESSAGE_FOR_CROPS_FINISHED = "			**Tiene %d cultivos listos para cosechar**";
	public static final String ERROR_CROP_FINISHED = "Según la fecha que acaba de ingresar, su cultivo ya ha finalizado. Por favor verifique";
	public static final String ID = "Id : ";
	public static final String WARNING_CROP_NO_FINISHED = "				***El cultivo no ha finalizado***" +
														    "\n¿Está seguro de querer finalizarlo?" + 
														   	"\n 1.Sí" + 
														    "\n 2.No";
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_EXPENSES = "\n\tPorcentaje de gastos por cultivo\n"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_GROUND_OCCUPIED = "\n\tPorcentaje de tierra ocupada por tipo de cultivo\n"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_GROWTH_RATE = "\n\tPorcentaje de crecimiento por cultivo\n"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_CROPS = "\n\tPorcentaje de la cantidad de cultivos en toda la granja\n"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_EXPENSES_BY_TYPE_BOVINE = "\n\tPorcentaje de gastos por tipo de bovino"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_CUANTITY_OF_ANIMAL_BY_TYPE_BOVINE = "\n\tPorcentaje de número de bovinos por tipo"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_BOUGHTS_BY_TYPE = "\n\tPorcentaje de cantidad de compras por tipo de bovino"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_SOLDS_BY_TYPE = "\n\tPorcentaje de cantidad de ventas por tipo de bovino"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_MONEY_INVESTED_IN_PURCHASES_BY_TYPE_BOVINE = "\n\tPorcentaje de dinero en compras por tipo"; 
	public static final String MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_MONEY_INVESTED_IN_SOLDS_BY_TYPE_BOVINE = "\n\tPorcentaje de dinero en ventas por tipo";
	public static final String MESSAGE_BOVINE = "\n		Bovinos";
	public static final String MESSAGE_BOVINE_MENU = "\n 1.Mi ganado.\n 2.Añadir bovino.\n 3.Eliminar un bovino.\n 4.Añadir gastos.\n 5.Obtener porcentaje de gastos por tipo.\n 6.Obtener porcentajes de animales por tipo\n 7.Obtener porcentajes de compras (en cantidad) por tipo\n 8.Obtener porcentajes de ventas (en cantidad) por tipo\n 9.Obtener porcentajes de compras(en valor) por tipo.\n 10.Obtener porcentjaes de ventas(en valor) por tipo.\n 11.Mostrar tabla de gastos(concepto - valor) por tipo\n 0.Volver atrás"; 
	public static final String MESSAGE_FOR_CHOOSE_TYPE_BOVINE = "\nPor favor elija el tipo de bovino"
															  + "\n  1.Sin destetar."
															  + "\n  2.Levante."
															  + "\n  3.Engorde."
															  + "\n  4.Lechero."
															  + "\n  0.Volver atrás";
	public static final String MESSAGE_TO_CHOOSE_WAY_TO_SEE_THE_BOVINE = "\nPor favor escoja como desea ver la informacion de su ganado\n  1.Tipo de bovino : Cantidad de animales.\n  2.Informacion de cada animal por tipo de bovino.\n  0.Volver atrás";
	public static final String MESSAGE_TO_BOVINE_PURCHASE_VALUE = "\nPor favor ingrese el valor de compra del bovino en pesos Colombianos (COP) : ";
	public static final String MEESAGE_TO_AGE_BOVINE = "\nPor favor ingrese la edad actual del animal en meses";
	public static final String MEESAGE_TO_GENDER_OF_BOVINE = "\nPor favor seleccione el genero del bovino.\n 1. Macho.\n 2. Hembra.";
	public static final String MESSAGE_FOR_BOVINE_ENTRY = "\nPor favor ingrese la fecha de ingreso del bovino en formato \"d/M/yyyy\": ";
	public static final String MESSAGE_FOR_ERROR_BOVINE_ADMISSION = "!No¡ en la finca no se aceptan bovinos con mas de 2 años de edad en al presente dia\nDebido a que no ofreceran una buena produccion";
	public static final String MEESAGE_FOR_ID_REMOVE = "Por favor ingrese el Id del bovino que desea eliminar";
	public static final String MESSAGE_FOR_TYPE_EXPENSE_BOVINE = "\nPor favor ingrese el tipo de gasto.\n  1.Alimentacion.\n  2.Vacunacion.\n  3.Cerca o valla del potrero.\n  4.Cuidados.";
	public static final String MESSAGE_FOR_SALE_VALUE = "\nPor favor ingrese el valor de venta del bovino : ";
	public static final String MESSAGE_CHICKEN_POO_MENU = "\n 1.Añadir gallinero"
														+ "\n 2.Vender gallina"
														+ "\n 3.Añadir gallina"
														+ "\n 0.Volver atrás";
	public static final String MESSAGE_FOR_READ_NUMBER_CHICKEN_IN_COOPS = "\nPor favor, ingrese el número de gallinas que desea añadir a su corral"; 
	public static final String MESSAGE_FOR_READ_DATE_OF_CHICKEN_POO_CREATION = "\nPor favor, ingrese la fecha de creación de su corral en formato \"d/M/yyyy\": ";
	public static final String MESSAGE_FOR_READ_INITIAL_INVESTMEN_FOR_CHICKEN_COOP = "\nPor favor, ingrese la inversión inicial para su corral";
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
		 for(int i = 0; i < cropsInProgress.length; i++) {
			 System.out.print(String.format(FORMAT,SEPARATOR_TABLE_LINE, HEADERS_PRODUCTS[i],SEPARATOR_TABLE_LINE, cropsInProgress[i], SEPARATOR_TABLE_LINE));
		 }
		 System.out.print(FINAL_LINE);
	 }
	 public void showInvalidOptionMenu() {
		 System.out.println(ERROR_INVALID_OPTION);
	 }
	 
	 public void printCropsBySpecieInProgressAsTable(int[] cropsInProgress) {
		 System.out.println(HEADER_CROPS_BY_SPECIE_IN_PROGRESS);
		 System.out.printf(HEADER_TABLE, TYPE, AMOUNT);
		 this.printInTableFormat(cropsInProgress);
	 }
	 
	 public void printCropsBySpecieFinishedAsTable(int[] cropsFinished) {
		 System.out.println(HEADER_CROPS_BY_SPECIE_FINISHED);
		 System.out.printf(HEADER_TABLE, TYPE, AMOUNT);
		 this.printInTableFormat(cropsFinished);
	 }
	
	/**
	 * Método para elegir la opción deseada en el menú principal
	 * @return opción elegida por el usuario
	 */
	public byte readOptionMainMenu() {
		System.out.println(MESSAGE_CHOOSE_OPTION);
		System.out.println(MESSAGE_MAIN_MENU);
		String option = scanner.nextLine().trim();
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
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 20) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
		
	}
	
	/**
	 * Metodo privado para determinar si una cadena de texto es o no numero
	 * @param cadena : String a evaluar
	 * @return true : Si es numero, false : No es numero
	 */
	private boolean isNumeric(String string){
		try {
			Double.parseDouble(string.trim());
			return true;
		}
		catch (NumberFormatException exceptionInvalidateValue){
//			System.out.println(exceptionInvalidateValue.getMessage());
			return false;
		}
	}
	
	/**
	 * Metodo hecho para obtener el nombre de la finca
	 * @return String con 4 caracteres o mas que es el nombre de la finca
	 */
	public String readNameOfFarm() {
		System.out.println(MESSAGE_NAME_OF_FARM);
		String name = scanner.nextLine().trim();
		while (name.length() < 4) {
			System.out.println(ERROR_NAME);
			name = scanner.nextLine().trim();
		}
		return name;
	}
	
	/**
	 * Metodo para obtener el terreno en m2 que sera usado para la crianza y cuidado de animales
	 * @return numero de m2 
	 */
	private double readGroundOfAnimals() {
		System.out.println(MESSAGE_READ_GROUND_ANIMALS);
		String groundAnimals = scanner.nextLine().trim();
		while(!isNumeric(groundAnimals) || Double.parseDouble(groundAnimals) < MINIMUM_LAND) {
			System.out.println(MESSAGE_METRIC_ERROR);
			groundAnimals = scanner.nextLine().trim();
		}
		return Double.parseDouble(groundAnimals);
	}
	
	/**
	 * Metodo para obtener el terreno en m2 que sera usado para la siembra de cultivos
	 * @return numero de m2 
	 */
	private double readGroundCrop(){
		System.out.println(MESSAGE_READ_GROUND_CROPS);
		String grounCrops = scanner.nextLine().trim();
		while(!isNumeric(grounCrops) || Double.parseDouble(grounCrops) < MINIMUM_LAND) {
			System.out.println(MESSAGE_METRIC_ERROR);
			grounCrops = scanner.nextLine().trim();
		}
		return Double.parseDouble(grounCrops);
	}
	
	public double[] readGrounds() {
		double[] grounds = new double[3];
		grounds[0] = readGroundOfAnimals();
		grounds[1] = readGroundCrop();
		System.out.println(MESSAGE_READ_TOTAL_GROUND);
		String totalGround = scanner.nextLine().trim();
		while(!isNumeric(totalGround) || (grounds[0] + grounds[1] + MINIMUM_LAND > Double.parseDouble(totalGround))) {
			System.out.println(MESSAGE_INSUFICIENT_GROUND);
			totalGround = scanner.nextLine().trim();
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
		String money = scanner.nextLine().trim();
		while(!isNumeric(money)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			money = scanner.nextLine().trim();
		}
		return Double.parseDouble(money);
	}
	
	/**
	 * Metodo para obtener el nombre de usuario de la app
	 * @return nombre de usuario
	 */
	public String readUsername() {
		System.out.println(MESSAGE_READ_USERNAME);
		String username = scanner.nextLine().trim();
		while(username.length() < 4) {
			System.out.println(ERROR_NAME);
			username = scanner.nextLine().trim();
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
		String password = scanner.nextLine().trim();
		while(password.length() < 8 || !isValidate1(password) || !isValidate2(password)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			System.out.println(MESSAGE_READ_PASSWORD);
			password = scanner.nextLine().trim();
		}
		return password;
	}
	
	public byte readPlantTypeOption() {
		System.out.println(MESSAGE_TO_CHOOSE_THE_TYPE_OF_PLANT);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 4) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	

	
	public LocalDate readSeedTime() {
		System.out.println(MESSAGE_FOR_ENTRY_SEED_DATE);
		try {
			return this.validateDate(scanner.nextLine());
		}
		catch(ExceptionDate exceptionDate) {
			System.out.println(exceptionDate.MESSAGE);
			return readSeedTime();
		}
	}
	
	public LocalDate validateDate(String seedTime) throws ExceptionDate{
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
		String ground = scanner.nextLine().trim();
		while(!isNumeric(ground)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			ground = scanner.nextLine().trim();
		}
		return Double.parseDouble(ground);
	}
	

	
	public void showSowingAmount(double[] production) {
		if(production[0] == 1) {
			System.out.printf(MESSAGE_TO_SHOW_THE_OPTIMAL_SOWING_AMOUNT_IN_ARROBAS, production[1]);
		}else {
			System.out.printf(MESSAGE_TO_SHOW_THE_OPTIMAL_SOWING_AMOUNT_IN_POUNDS, production[1]);
		}
	}
	
	public double readInitialCapitalCrop() {
		System.out.println(MESSAGE_FOR_READ_VALUE_INITIAL_EXPENSE_CROP_IN_PROGRESS);
		String initialCapital = scanner.nextLine().trim();
		while(!isNumeric((initialCapital))) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			initialCapital = scanner.nextLine().trim();
		}
		return Double.parseDouble(initialCapital);
	}
	
	public byte readOptionForWayToAdd() {
		System.out.println(MESSAGE_FOR_WAY_TO_ADD_CROP);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) ||  Byte.parseByte(option) < 0 || Byte.parseByte(option) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		
		return Byte.parseByte(option);
	}
	
	public double readValueOfExpense() {
		System.out.println(MESSAGE_FOR_READ_VALUE_EXPENSE_CROP_FINISHED);
		String expense = scanner.nextLine().trim();
		while(!isNumeric(expense)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			expense = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(expense);
	}
	
	public double readProductionObtained() {
		System.out.println(MESSAGE_FOR_READ_VALUE_OF_SOLD_PACKAGES);
		String productionObtained = scanner.nextLine().trim();
		while(!isNumeric(productionObtained)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			productionObtained = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(productionObtained);
	}
	
	public double readSalePricePerPackage() {
		System.out.println(MESSAGE_FOR_READ_PRICE_PER_PACKAGE_FINISHED);
		String price = scanner.nextLine().trim();
		while(!isNumeric(price)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			price = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(price);
	}
	
	public byte readIdOfCrop() {
		System.out.println(MESSAGE_FOR_READ_PRICE_ID_CROP_FINISHED);
		String id = scanner.nextLine();
		while(!isNumeric(id)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			id = scanner.nextLine().trim();
		}
		
		return Byte.parseByte(id);
		
	}
	
	
	public byte readTypeOfCrop() {
		System.out.println(MESSAGE_FOR_CHOOSE_TYPE_CROP);
		String typeCrop = scanner.nextLine().trim();
		while(!isNumeric(typeCrop) || Byte.parseByte(typeCrop) < 0 || Byte.parseByte(typeCrop) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			typeCrop = scanner.nextLine().trim();
		}
		
		return Byte.parseByte(typeCrop);
	}
	
	
	public void printListOfCropsForSelect(ArrayList<Byte> expenseList){
		if(expenseList.size() != 0){
			System.out.println(MESSAGE_CHOOSE_CROP_OPTION);
			for(int i = 0; i < expenseList.size(); i++) {
				System.out.println((i + 1) + ") " + ID + expenseList.get(i));
			}
		}
		else
			System.out.println(MESSAGE_FOR_VOID_LIST);
		
	}
	
	public byte readIdForSearchCrop(ArrayList<Byte> arrayList ) {
		String  option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 1 || !(Utilities.existNumberInArray(arrayList, Byte.parseByte(option)))) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
		
	}
	

	
	public byte readExpenseTypeCrop() {
		System.out.println(MESSAGE_CHOOSE_TYPE_EXPENSE);
		String option = scanner.nextLine().trim();
		while(!isNumeric((option)) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 4) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		
		return Byte.parseByte(option);
	}
	
	public double readPriceExpenseTypeCrop() {
		System.out.println(MESSAGE_FOR_READ_PRICE_EXPENSE_TYPE_CROP);
		String price = scanner.nextLine().trim();
		while(!isNumeric((price))) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			price = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(price);
	}
	

	public void printExpesesByCrop(String[][] listExpense) {
		if(listExpense.length > 0) {
			System.out.printf(HEADER_TABLE, CONCEPT, VALUE);
			for(int i = 0; i < listExpense.length; i++) {
			 	System.out.print(String.format(FORMAT,SEPARATOR_TABLE_LINE, listExpense[i][0],SEPARATOR_TABLE_LINE, listExpense[i][1], SEPARATOR_TABLE_LINE));
		 	}
			System.out.println(FINAL_LINE);
		}
		else
			System.out.println(MESSAGE_FOR_VOID_LIST);
	}
	
	public void printNotificationOfCropsFinished(byte numberOfCrops) {
		if(numberOfCrops > 0 && numberOfCrops <= 1) {
			System.out.printf(MESSAGE_FOR_CROP_FINISHED, numberOfCrops);
			System.out.println("");
		}
		else if(numberOfCrops > 1) {
			System.out.printf(MESSAGE_FOR_CROPS_FINISHED, numberOfCrops);
			System.out.println(" ");
		}
		else
			System.out.print("");
	}

	//metodo cuestionable y quizá salga a volar
	public void validateDaysBetweenTwoDates(boolean decision) {
		if(decision) {
			System.out.println(ERROR_CROP_FINISHED);
		}
		else
			System.out.print("");
	}
	
	public byte readFinishDecision(boolean decision) {
		if(!decision) {
			System.out.println(WARNING_CROP_NO_FINISHED);
			String option = scanner.nextLine().trim();
			while(!isNumeric((option)) || Byte.parseByte(option) < 1 || Byte.parseByte(option) > 2) {
				System.out.println(ERROR_INVALID_OPTION);
				option = scanner.nextLine().trim();
			}
			return Byte.parseByte(option);
		}
		return -1; //sé que es una mala práctica pero no se me ocurrió cómo más hacerlo
	}
	
	public byte readTypeEndingCrop() {
		System.out.println(MESSAGE_END_CROPS_MENU);
		String option = scanner.nextLine().trim();
		while(!isNumeric((option)) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		
		return Byte.parseByte(option);
	}
	
	
	public double readNumberPackagesHarvest() {
		System.out.println(MESSAGE_FOR_READ_NUMBER_PACKAGES_HARVEST);
		String numberOfPackages = scanner.nextLine().trim();
		while(!isNumeric(numberOfPackages)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			numberOfPackages = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(numberOfPackages);
	}
	
	public double readPriceToBeSold() {
		System.out.println(MESSAGE_FOR_READ_PRICE_PER_PACKAGE_IN_PROGRESS);
		String price = scanner.nextLine().trim();
		while(!isNumeric(price)){
			System.out.println(ERROR_INVALIDATE_VALUE);
			price = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(price);
	}
	
	/**
	 * Método para elegir la opción deseada en el menú de los bovinos
	 * @return opción elegida por el usuario
	 */
	public byte readOptionMenuBovine() {
		System.out.println(MESSAGE_CHOOSE_OPTION);
		System.out.println(MESSAGE_BOVINE_MENU);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 11) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	/**
	 * Metodo para obtener el tipo de bovino seleccionado por el usuario
	 * @return numero con el tipo de bovino
	 */
	public byte readTypeOfBovine() {
		System.out.println(MESSAGE_FOR_CHOOSE_TYPE_BOVINE);
		String typeCrop = scanner.nextLine().trim();
		while(!isNumeric(typeCrop) || Byte.parseByte(typeCrop) < 0 || Byte.parseByte(typeCrop) > 4) {
			System.out.println(ERROR_INVALID_OPTION);
			typeCrop = scanner.nextLine().trim();
		}
		return Byte.parseByte(typeCrop);
	}
	
	/**
	 * Metodo para obtener la forma en la que el usuario quiere ver su ganado
	 * @return
	 */
	public byte readWayOfSeeingBovines() {
		System.out.println(MESSAGE_TO_CHOOSE_WAY_TO_SEE_THE_BOVINE);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
	}
	
	/**
	 * Metodo para obtener el valor de compra dle bovino
	 * @return
	 */
	public float readPurchaseValueOfTheBovine() {
		System.out.println(MESSAGE_TO_BOVINE_PURCHASE_VALUE);
		String value = scanner.nextLine().trim();
		while(!isNumeric(value) || Double.parseDouble(value) < 0) {
			System.out.println(ERROR_INVALID_OPTION);
			value = scanner.nextLine().trim();
		}
		return (float)Float.parseFloat(value);
	}
	
	/**	
	 * Metodo para obtener la edad del bovino
	 * @return
	 */
	public int readBovineAge() {
		System.out.println(MEESAGE_TO_AGE_BOVINE);
		String age = scanner.nextLine().trim();
		while(!isNumeric(age) || Integer.parseInt(age) < 0) {
			System.out.println(ERROR_INVALID_OPTION);
			age = scanner.nextLine().trim();
		}
		return (int)Integer.parseInt(age);
	}
	
	/**
	 * Metodo para obtener el genero del bovino
	 * @return
	 */
	public int readGenderOfBovine() {
		System.out.println(MEESAGE_TO_GENDER_OF_BOVINE);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 1 || Byte.parseByte(option) > 2) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Integer.parseInt(option);
	}
	
	/**
	 * Metodo para obtener la fecha de ingreso de un bovino
	 * @return
	 */
	public LocalDate readDateOfAdmission(int age) {		
		LocalDate admission = readAdmissionTime();
		while((int)DAYS.between(admission, LocalDate.now()) + (age * 30) > 730) {
			System.out.println(MESSAGE_FOR_ERROR_BOVINE_ADMISSION);
			admission = readAdmissionTime();
		}
		return admission;
	}
	
	/**
	 * Metodo para obtener el id del bovino que se quiere eliminar
	 * @return
	 */
	public int readIdBovineRemove() {
		System.out.println(MEESAGE_FOR_ID_REMOVE);
		String id = scanner.nextLine();
		while(!isNumeric(id) || Integer.parseInt(id) < 0) {
			System.out.println(ERROR_INVALID_OPTION);
			id = scanner.nextLine();
		}
		return Integer.parseInt(id);
	}
	
	/**
	 * Metodo para obtener el tipo de gasto de los bovinos
	 * @return
	 */
	public byte readExpenseTypeBovine() {
		System.out.println(MESSAGE_FOR_TYPE_EXPENSE_BOVINE);
		String type = scanner.nextLine();
		while(!isNumeric(type) || Integer.parseInt(type) < 0 || Integer.parseInt(type) > 4) {
			System.out.println(ERROR_INVALID_OPTION);
			type = scanner.nextLine();
		}
		return Byte.parseByte(type);
	}
	
	/**
	 * Metodo para obtener el valor de venta de un bovino
	 * @return
	 */
	public double readBovineSaleValue() {
		System.out.println(MESSAGE_FOR_SALE_VALUE);
		String value = scanner.nextLine();
		while(!isNumeric(value) || Integer.parseInt(value) < 0) {
			System.out.println(ERROR_INVALID_OPTION);
			value = scanner.nextLine();
		}
		return Double.parseDouble(value);
	}

	public LocalDate readAdmissionTime() {
		System.out.println(MESSAGE_FOR_BOVINE_ENTRY);
		try {
			return this.validateDate(scanner.nextLine().trim());
		}
		catch(ExceptionDate exceptionDate) {
			System.out.println(exceptionDate.getMessage());
			return readAdmissionTime();
		}
	}
	
	public byte readOptionMenuChickenCoop() {
		System.out.println(MESSAGE_CHOOSE_OPTION);
		System.out.println(MESSAGE_CHICKEN_POO_MENU);
		String option = scanner.nextLine().trim();
		while(!isNumeric(option) || Byte.parseByte(option) < 0 || Byte.parseByte(option) > 4) {
			System.out.println(ERROR_INVALID_OPTION);
			option = scanner.nextLine().trim();
		}
		return Byte.parseByte(option);
		
	}
	
	public int readNumberOfChickensInCoop() {
		System.out.println(MESSAGE_FOR_READ_NUMBER_CHICKEN_IN_COOPS);
		String numberOfChickens = scanner.nextLine().trim();
		while(!isNumeric(numberOfChickens)) {
			System.out.println(ERROR_INVALIDATE_VALUE);
			numberOfChickens = scanner.nextLine().trim();
		}
		return Integer.parseInt(numberOfChickens);
	}
	
	public LocalDate readDateOfCreationChickenPoo() {
		System.out.println(MESSAGE_FOR_READ_DATE_OF_CHICKEN_POO_CREATION);
		try {
			return this.validateDate(scanner.nextLine().trim());
		}
		catch(ExceptionDate exceptionDate) {
			System.out.println(exceptionDate.getMessage());
			return readDateOfCreationChickenPoo();
		}
	}
	
	public double readInitialInvestmentChickenCoop() {
		System.out.println(MESSAGE_FOR_READ_INITIAL_INVESTMEN_FOR_CHICKEN_COOP);
		String initialInvestment = scanner.nextLine().trim();
		while(!isNumeric(initialInvestment)){
			initialInvestment = scanner.nextLine().trim();
		}
		
		return Double.parseDouble(initialInvestment);
	}
	
	
}

