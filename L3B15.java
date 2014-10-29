package temporary;

public class L3B15 {

	public static void main(String[] args) {

		int[] array = {1, 2, 3, 4, 5};
		System.out.println(avarage(array));

	}
	
	static int avarage(int[] data){
		int result = 0;
		
		for (int i : data){
		result += i;
		}
		
		return result / data.length;
	}

}
