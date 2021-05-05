package utilities;

import java.util.ArrayList;

public  class Utilities {
	
	public static byte determinateBiggestNumberInArray(ArrayList<Byte> arrayList) {
		byte biggest = 0;
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) > biggest) {
				biggest = arrayList.get(i);
			}
		}
		return biggest;
	}
	
	public static boolean existNumberInArray(ArrayList<Byte> arrayList, byte number) {
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) == number)
				return true;
		}
		return false;
	}
		
	

}
