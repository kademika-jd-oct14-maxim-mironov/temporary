package temporary;

import java.util.Arrays;

public class L3B27 {

	public static void main(String[] args) {

		int[] one = {1, 2, 3};
		int[] two = {4, 5, 6};

		union(one, two);
		
	}
	
	static int[] union(int[] data1, int[] data2) {
		int[] array = new int[6];
		
		for (int i = 0; i < data1.length; i++){
			array[i] = data1[i];
			System.out.println(Arrays.toString(array));
		}
		
		for (int k = 0; k < data2.length; k++){
			array[k + 3] = data2[k];
			System.out.println(Arrays.toString(array));
			}
		
		
		return array;
	}

}
