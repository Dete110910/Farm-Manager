package models;

/**
 * Clase correspondiente a una venta o compra de un bovino
 * @author USUARIO
 *
 */
public class BovineSalePurchase {

	private TypeBovine type;
	private double saleValue;
	
	/**
	 * Metodo constructor por default
	 * @param type : Tipo de Bovino que se vendio
	 * @param saleValue : Valor por el que se vendio
	 */
	public BovineSalePurchase(TypeBovine type, double saleValue) {
		this.type = type;
		this.saleValue = saleValue;
	}

	/**
	 * @return the type
	 */
	public TypeBovine getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeBovine type) {
		this.type = type;
	}

	/**
	 * @return the saleValue
	 */
	public double getSaleValue() {
		return saleValue;
	}

	/**
	 * @param saleValue the saleValue to set
	 */
	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}
	
	
}