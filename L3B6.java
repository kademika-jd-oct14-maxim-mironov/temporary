package temporary;

import java.util.Arrays;

public class L3B6 {

	public static void main(String[] args) {

		int[] array = {1, 2, 3, 12, 13};
		int[] arrayTwo = {0};
		getLast(arrayTwo);

	}
	
	static int getLast(int[] data) {
		
		if (data != null){
			
		int lastIndex = data[data.length -1];
		System.out.println(lastIndex);
		return lastIndex;
		
		}
		
		return -1;
	}

}