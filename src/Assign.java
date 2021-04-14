public class Assign {


	public static void main(String[] args) {
		int [][] arr = {
			{0	,0	,1	,1	,0	,0	,1	,0	,0	,0	,1},
			{0	,0	,0	,1	,0	,0	,1	,0	,1	,0	,0},
			{1	,0	,0	,1	,0	,0	,0	,0	,1	,0	,1},
			{1	,0	,1	,1	,0	,0	,0	,1	,0	,0	,1},
			{0	,1	,0	,1	,1	,1	,0	,0	,0	,1	,1},
			{0	,0	,0	,1	,0	,0	,0	,0	,0	,0	,0},
			{0	,0	,1	,1	,0	,1	,0	,0	,1	,0	,0},
			{1	,0	,0	,0	,1	,0	,0	,1	,1	,0	,0},
			{1	,1	,0	,1	,0	,0	,1	,0	,0	,0	,1},
			{0	,0	,0	,0	,0	,1	,1	,0	,0	,0	,1},
			{0	,1	,0	,0	,0	,0	,0	,1	,0	,1	,0},
			{1	,0	,1	,1	,1	,0	,1	,0	,1	,0	,1}
		};
		double assign = 0.0;
		double count;
		double total;
	  	for (int i = 0; i < 11; i++) {
	  		count = 0; total = 0;
			for (int j = 0; j < 12; j++) {
	  	    	if(arr[j][i] == 1) {
	  	    		total = total + 1;
					if (j < 5) {
						count = count + 1;
					}
				}
			}
			if(count == 1) {
				count = 0;
			}
			if (arr[8][i] == 1 && arr[9][i] == 1) {
				count = count + 2;
			}

			if(total > 0) {
				assign = assign + (1 - count/total);
			}
		}
		System.out.println("Assign = " + assign/11);
	}
}
