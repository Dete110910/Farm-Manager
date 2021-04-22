package views;
import java.util.HashMap;
public class PrintHashMap {

	private HashMap<String, Double> map;
	private String[][] result;
	
	public PrintHashMap(HashMap<String, Double> map) {
		this.map = map;
		result = new String[map.size() * 4 + 1][42];
		this.printData();
	}
	
	/**
	 * Metodo para centrar una palabra dependiendo la cantidad de caracteres que deba tener
	 * @param data
	 * @param numberOfCharacters
	 * @return
	 */
	public String designData(String data, double numberOfCharacters) {
		String newData = "";
		int startNumber = (int) ((numberOfCharacters - data.length()) / 2);
		for (int i = 0; i < numberOfCharacters; i++) {
			if(i >= startNumber && i < startNumber + data.length()) {
				for (int j = 0; j < data.length(); j++) {
					newData += data.charAt(j);
					i++;
				}
			}else {
				newData += " ";
			}
		}
		return newData;
	}
	
	/**
	 * Metodo para obtener la cantidad maxima de caracteres de una palabra
	 * @return
	 */
	public double getMaxCharacters() {
		int result = 2;
		Double higher = (double)0;
		for (HashMap.Entry<String, Double> entry : map.entrySet()) {
		    if(entry.getKey().length() > higher) {
		    	higher = (double) entry.getKey().length();
		    }
		}
		return result + higher;
	}
	
	/**
	 * Metodo para obtener los keys del HashMap
	 * @return
	 */
	public String[] getKeys() {
		String[] data = new String[map.size()];
		int j = 0;
		for (HashMap.Entry<String, Double> entry : map.entrySet()) {
			data[j] = designData(entry.getKey(), getMaxCharacters());
			j++;
		}
		return data;
	}
	
	/**
	 * Metodo para obtener los valores del HasMap y guardarlos en un vector
	 * @return
	 */
	public double[] getValues() {
		double[] values = new double[map.size()];
		int j = 0;
		for (HashMap.Entry<String, Double> entry : map.entrySet()) {
			double value = entry.getValue();
			if(value%5 == 0) {
				values[j] = value/10;
			}else if(value%5 != 0) {
				values[j] = (double)Math.round(value/10);
			}
			j++;
		}
		return values;
	}
	
	public void fillQuantityPerKey(double cnt, int row) {
		if(cnt <= 100) {
			for (int i = 2; i <= cnt*4 + 1; i++) {
				result[row][i] = "X";
			}
		}	
	}
	
	public void fillInQuantity() {
		int k = 0;
		int j2 = 0;
		double[] values = getValues();
		for (int i = 0; i < result.length; i+=4, k++) {
			if(k < values.length) {
				for (int j = 0; j < 3; j++) {
					fillQuantityPerKey(values[k], j2);
					j2++;
				}
				j2++;
			}	
		}
	}
	
	/**
	 * Metodo para llenar la matriz con la cantidad de espacios necesaria
	 * @return
	 */
	private String getSpaces() {
		String result = "";
		for (int i = 0; i <= getMaxCharacters() - 2; i++) {
			result += " ";
		}
		return result;
	}
	
	/**
	 * Metodo para llenar los espacios donde iran los separadores de la grafica
	 */
	public void fillSeparators() {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++ ) {
				if(j == 1 && i < result.length - 2) {
					result[i][j] = "|";
				}if(i == result.length - 2 && j > 1) {
					result[i][j] = "_";
				}if(i == result.length - 2 && j == 1) {
					result[i][j] = "|_";
				}
			}
		}
	}
	
	/**
	 * Metodo para rellenar la zona de footer del grafico de barras
	 */
	public void fillFooter() {
		int j = 1;
		for (int i = 5; i < result[0].length; i+=4) {
			result[result.length - 1][i] = String.valueOf(j);
			j ++;
		}
	}
	
	/**
	 * Metodo para poner las llaves del HashMap en la matriz grafica
	 */
	public void putKeys() {
		String[] keys = getKeys();
		int k = 0;
		for (int i = 1; i < result.length; i+=4) {
			if(k < keys.length) {
				result[i][0] = keys[k];
				k++;
			}	
		}
		for (int i = 0; i < result.length; i++) {
			if(result[i][0].length() == 1) {
				result[i][0] = getSpaces();
			}
		}
	}
	
	/**
	 * Metodo para reemplazar los null con espacios en la matriz
	 */
	public void fillSpacesInResult() {
		for (int i = 0; i < result.length ; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if(result[i][j] == null) {
					result[i][j] = " ";
				}
			}
		}

	}	
	
	public HashMap<String, Double> getMap(){
		return map;
	}
	
	public String[][] getResult(){
		return result;
	}
	
	public void printData() {
		fillSpacesInResult();
		putKeys();
		fillSeparators();
		fillFooter();
		fillInQuantity();
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println("");
		}
		System.out.println("\n _____________\n|             |\n| Escala 1:10 |\n|_____________|");
	}
}