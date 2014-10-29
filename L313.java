package temporary;

public class L313 {

	public static void main(String[] args) {

		int[] array = {1, 3, 4, 5, 3};

		System.out.println(oddElementSum(array));
		
		
	}
	
	static long oddElementSum(int[] data) {
		int summ = 0;
		for (int i = 0; i < data.length; i++){
		if (i % 2 == 1){
			summ += data[i];
			}
		}
		return summ;
	}

}
