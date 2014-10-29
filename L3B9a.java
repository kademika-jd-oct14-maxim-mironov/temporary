package temporary;

import java.util.Arrays;

public class L3B9a {

	public static void main(String[] args) {

		int[] array = {-1, 62, 3, 12, 13};
		int[] arrayTwo = {0};
		
		printArray(array);

	}
	
	static void printArray(int[] data) {
		
		int index = 0;
		while (index < data.length){
			System.out.println(data[index]);
			index++;
		}
		
		
		//System.out.println(Arrays.toString(data));
	}

}
