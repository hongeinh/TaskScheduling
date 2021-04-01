public class Utils {

    public static void isUseful (int [][] a, double [][] b) {
        int [][] useful = new int[Common.numberOfTasks][Common.numberOfResource];

        for (int i = 0; i < Common.numberOfTasks; i++) {
            for (int j = 0; j < Common.numberOfResource; j++) {
                for (int k = 0; k < Common.numberOfSkills; k++) {
                    if(a[i][k] == 1 && b[j][k] > 0) {
                        useful[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 11; j++){
                System.out.print(useful[i][j]);
            }
            System.out.println("");
        }
    }
}
