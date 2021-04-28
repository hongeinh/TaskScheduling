import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Distance {
	public static int size = 6;
	public static void main(String[] args) {
		double[][] arr = {
				{ 1	    ,0.6758704554	,0.01395833333	,0.583008658  },
				{ 7	    ,0.2828148998	,0.01395833333	,0.6848484848 },
				{ 9	    ,0.1928678099	,0.01395833333	,0.6225108225 },
				{ 17	,0.1297882152	,0.01180555556	,0.5931818182 },
				{ 20	,0.1986497594	,0.01119047619	,0.6806637807 },
				{ 21	,0.1015794412	,0.01266666667	,0.3577922078 }
		};
		List<Solution> solutionList = createSolutions(arr);
		solutionList = calcDistance(solutionList);
		solutionList = sort(solutionList, 4);
		System.out.println("-----------------------------------------------------");
		for (Solution sol: solutionList) {
			System.out.println(sol.id + ": " + sol.distance);
		}

	}

	public static List<Solution> createSolutions(double[][] arr) {
		List<Solution> solutionList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			solutionList.add(new Solution(arr[i][0], arr[i][1], arr[i][2], arr[i][3]));
		}
		return solutionList;
	}

	public static List<Solution> calcDistance(List<Solution> solutionList) {
		solutionList = sort(solutionList, 1);
		Solution smallest = solutionList.get(0);
		Solution biggest = solutionList.get(size - 1);
		for (int j = 1; j < size - 1; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).duration - solutionList.get(j - 1).duration)/(biggest.duration - smallest.duration);

		}

		solutionList = sort(solutionList, 2);
		smallest = solutionList.get(0);
		biggest = solutionList.get(size - 1);

		for (int j = 1; j < size - 1; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).assign - solutionList.get(j - 1).assign)/(biggest.assign - smallest.assign);

		}

		solutionList = sort(solutionList, 3);
		 smallest = solutionList.get(0);
		 biggest = solutionList.get(size - 1);

		for (int j = 1; j < size - 1; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).experience - solutionList.get(j - 1).experience)/(biggest.experience - smallest.experience);

		}
		return solutionList;
	}

	public static List<Solution> sort(List<Solution> solutionList, int flag) {

		if (flag == 1) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - i - 1; j++) {
					if (solutionList.get(j).duration > solutionList.get(j+1).duration) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Duration");
		} else if (flag == 2) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - i - 1; j++) {
					if (solutionList.get(j).assign > solutionList.get(j+1).assign) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Assignment");

		} else if (flag == 3) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - i - 1; j++) {
					if (solutionList.get(j).experience > solutionList.get(j+1).experience) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Experience");
		} else if (flag == 4) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size - i - 1; j++) {
					if (solutionList.get(j).id > solutionList.get(j+1).id) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Assignment");

		}
//		for (Solution solution: solutionList) {
//			if (flag == 1) {
//				System.out.println(solution.id + "  Duration: " + solution.duration);
//			} else if (flag == 2) {
//				System.out.println(solution.id + "  Assignment: " + solution.assign);
//			} else if (flag == 3) {
//				System.out.println(solution.id + "  Experience: " + solution.experience);
//			}
//		}
		return solutionList;
	}
}

class Solution {
	public double duration;
	public double experience;
	public double assign;


	public double id;
	public double distance;


	Solution(double id, double duration, double experience, double assign) {
		this.id = id;
		this.duration = duration;
		this.experience = experience;
		this.assign = assign;
		this.distance = 0;
	}
}
