package temporary;

import java.util.Arrays;

public class L3B23 {

	public static void main(String[] args) {
		
		int[] array = {7, 5, 1, 6, 23, 131, 7, 5, 1, 6, 23, 131};

		Arrays.sort(array);
		//sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static void sort(int[] data) {
		int activeLength = data.length - 1;
		for (int i = 0; i < data.length; i++){
			for (int k = 0; k < activeLength; k++){
				swap(data, k, k + 1);
			}
			activeLength--;
		}
	}
	
	static void swap(int[] data, int i, int k) {
			int tmp = 0;
				if (data[i] < data[i +1]){	
					tmp = data[i];
					data[i] = data[i +1];
					data[i + 1] = tmp;
		}
	}
}
