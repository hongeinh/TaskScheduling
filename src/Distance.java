import java.util.ArrayList;
import java.util.List;

public class Distance {

	public static void main(String[] args) {
		double[][] arr = {
				{0.67587046, 0.0111905, 0.49242424},
				{0.50920379, 0.0111905, 0.61991342},
				{0.3703149, 0.0111905, 0.61385281},
				{0.24392601, 0.0111905, 0.54924242},
				{0.39670379, 0.0118056, 0.57770563},
				{0.24809268, 0.0103704, 0.65876623},
				{0.25110194, 0.0118056, 0.61847042},
				{0.36370114, 0.0103704, 0.65382395},
				{0.246803, 0.0126667, 0.6504329},
				{0.16218599, 0.0139583, 0.58679654},
				{0.18331394, 0.0161111, 0.54220779},
				{0.30443171, 0.0126667, 0.55606061},
				{0.15820297, 0.0139583, 0.52619048},
				{0.16022684, 0.0126667, 0.63744589},
				{0.16687066, 0.0118056, 0.59924242},
				{0.2372073, 0.0139583, 0.56984127},
				{0.28842457, 0.0139583, 0.59491342},
				{0.13696445, 0.0107292, 0.57619048},
				{0.17121646, 0.0126667, 0.60562771},
				{0.1394448, 0.0139583, 0.53917749}
		};
		List<Solution> solutionList = createSolutions(arr);
		solutionList = calcDistance(solutionList);
		for (Solution sol: solutionList) {
			System.out.println(sol.id + ": " + sol.distance);
		}

	}

	public static List<Solution> createSolutions(double[][] arr) {
		List<Solution> solutionList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			solutionList.add(new Solution(i + 1, arr[i][0], arr[i][1], arr[i][2]));
		}
		return solutionList;
	}

	public static List<Solution> calcDistance(List<Solution> solutionList) {
		solutionList = sort(solutionList, 1);
		Solution smallest = solutionList.get(0);
		Solution biggest = solutionList.get(19);
		for (int j = 1; j < 19; j++) {
			solutionList.get(j).distance += (solutionList.get(j - 1).duration - solutionList.get(j + 1).duration)/(smallest.duration - biggest.duration);

		}

		solutionList = sort(solutionList, 2);
		smallest = solutionList.get(0);
		biggest = solutionList.get(19);

		for (int j = 1; j < 19; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).assign - solutionList.get(j - 1).assign)/(biggest.assign - smallest.assign);

		}

		solutionList = sort(solutionList, 3);
		 smallest = solutionList.get(0);
		 biggest = solutionList.get(19);

		for (int j = 1; j < 19; j++) {
			solutionList.get(j).distance += (solutionList.get(j - 1).experience - solutionList.get(j + 1).experience)/(smallest.experience - biggest.experience);

		}
		return solutionList;
	}

	public static List<Solution> sort(List<Solution> solutionList, int flag) {

		if (flag == 1) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20 - i - 1; j++) {
					if (solutionList.get(i).duration > solutionList.get(j).duration) {
						Solution tmp = solutionList.get(i);
						solutionList.set(i, solutionList.get(j));
						solutionList.set(j, tmp);
					}
				}
			}
		} else if (flag == 2) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20 - i - 1; j++) {
					if (solutionList.get(i).assign < solutionList.get(j).assign) {
						Solution tmp = solutionList.get(i);
						solutionList.set(i, solutionList.get(j));
						solutionList.set(j, tmp);
					}
				}
			}
		} else if (flag == 3) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20 - i - 1; j++) {
					if (solutionList.get(i).experience > solutionList.get(j).experience) {
						Solution tmp = solutionList.get(i);
						solutionList.set(i, solutionList.get(j));
						solutionList.set(j, tmp);
					}
				}
			}
		}
		return solutionList;
	}
}

class Solution {
	public double duration;
	public double experience;
	public double assign;


	public int id;
	public double distance;


	Solution(int id, double duration, double experience, double assign) {
		this.id = id;
		this.duration = duration;
		this.experience = experience;
		this.assign = assign;
		this.distance = 0;
	}
}
