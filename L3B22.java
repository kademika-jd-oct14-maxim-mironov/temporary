package temporary;

import java.util.Arrays;

public class L3B22 {

	public static void main(String[] args) {
		
		int[] array = {7, 5, 1, 6, 23, 131, 7, 5, 1, 6, 23, 131};

		sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static void sort(int[] data) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < data.length; i++)
		swap(data);
		System.out.println(System.currentTimeMillis() - time);
	}
	
	static void swap(int[] data) {
		if (data != null && data.length > 0){
			int tmp = 0;
			for (int i = 0; i < data.length - 1; i++) {
				if (data[i] < data[i +1]){	
					tmp = data[i];
					data[i] = data[i +1];
					data[i + 1] = tmp;
				}
			}
		}
	}
}
