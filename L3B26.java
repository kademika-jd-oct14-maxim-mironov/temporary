package temporary;

public class L3B26 {

	public static void main(String[] args) {

		String[][] population = {
				{"China", "Peking", "1354040000"},
				{"India", "New Delhi", "1210569573"},
				{"USA", "Washington D.C.", "316305000"},
				{"Indonesia", "Jakarta", "237641326"},
				{"Brazil", "Brasilia", "193946886"},
				{"Oakistan", "Islamabad", "183748060"},
				
		};
		
		System.out.println(getPopulation(population));
		

	}
	
	static long getPopulation(String[][] data) {
		long summ = 0;
		
		for (int i = 0; i < data.length; i++) {
			summ += Integer.parseInt(data[i][2]);
			System.out.println(summ);
		}
		return (long)summ;
	}

}
