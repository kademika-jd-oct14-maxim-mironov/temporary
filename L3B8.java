package temporary;

import java.util.Arrays;

public class L3B8 {

	public static void main(String[] args) {

		int[] array = {1, 2, 3, 12, 13};
		int[] arrayTwo = {0};
		
		swap(array, 3, 0);
		
		System.out.println(Arrays.toString(array));

	}
	
	static void swap(int[] data, int i, int k){
		int tmp = data[i];
		data[i] = data[k];
		data[k] = tmp;	
	}

}
