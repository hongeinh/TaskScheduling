import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Distance {

	public static void main(String[] args) {
		double[][] arr = {
				{	0.67587046	    ,0.0111905	    , 0.49242424    },
				{	0.50920379	    ,0.0111905	    , 0.61991342    },
				{	0.3703149	    ,0.0111905	    , 0.61385281    },
				{	0.24392601	    ,0.0111905	    , 0.54924242    },
				{	0.39670379	    ,0.0118056	    , 0.57770563    },
				{	0.24809268	    ,0.0103704	    , 0.65876623    },
				{	0.25110194	    ,0.0118056	    , 0.61847042    },
				{	0.36370114	    ,0.0103704	    , 0.65382395    },
				{	0.246803	    ,0.0126667	    , 0.6504329     },
				{	0.16218599	    ,0.0139583	    , 0.58679654    },
				{	0.18331394	    ,0.0161111	    , 0.54220779    },
				{	0.30443171	    ,0.0126667	    , 0.55606061    },
				{	0.15820297	    ,0.0139583	    , 0.52619048    },
				{	0.16022684	    ,0.0126667	    , 0.63744589    },
				{	0.16687066	    ,0.0118056	    , 0.59924242    },
				{	0.2372073	    ,0.0139583	    , 0.56984127    },
				{	0.28842457	    ,0.0139583	    , 0.59491342    },
				{	0.13696445	    ,0.0107292	    , 0.57619048    },
				{	0.17121646	    ,0.0126667	    , 0.60562771    },
				{	0.1394448	    ,0.0139583	    , 0.53917749    },
				{	0.6758704554	,0.01395833333	, 0.583008658   },
				{	0.4675371221	,0.01611111111	, 0.5621212121  },
				{	0.3078148998	,0.01266666667	, 0.3577922078  },
				{	0.4175371221	,0.01395833333	, 0.5297619048  },
				{	0.3036482332	,0.01180555556	, 0.5672077922  },
				{	0.3489855348	,0.01266666667	, 0.45          },
				{	0.2828148998	,0.01395833333	, 0.6848484848  },
				{	0.2123122543	,0.01180555556	, 0.5887445887  },
				{	0.1928678099	,0.01395833333	, 0.6225108225  },
				{	0.2856287526	,0.01072916667	, 0.5204545455  },
				{	0.3044398027	,0.01072916667	, 0.5071428571  },
				{	0.1735391062	,0.01037037037	, 0.7103896104  },
				{	0.2147205282	,0.01119047619	, 0.6298701299  },
				{	0.2718438447	,0.01266666667	, 0.7015151515  },
				{	0.177967929	    ,0.01119047619	, 0.6079004329  },
				{	0.1871138416	,0.01119047619	, 0.7844155844  },
				{	0.1297882152	,0.01180555556	, 0.5931818182  },
				{	0.2041824966	,0.01180555556	, 0.8701298701  },
				{	0.1851385752	,0.01180555556	, 0.4962121212  },
				{	0.1986497594	,0.01119047619	, 0.6806637807  }
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
		for (int i = 0; i < 40; i++) {
			solutionList.add(new Solution(i + 1, arr[i][0], arr[i][1], arr[i][2]));
		}
		return solutionList;
	}

	public static List<Solution> calcDistance(List<Solution> solutionList) {
		solutionList = sort(solutionList, 1);
		Solution smallest = solutionList.get(0);
		Solution biggest = solutionList.get(39);
		for (int j = 1; j < 39; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).duration - solutionList.get(j - 1).duration)/(biggest.duration - smallest.duration);

		}

		solutionList = sort(solutionList, 2);
		smallest = solutionList.get(0);
		biggest = solutionList.get(39);

		for (int j = 1; j < 39; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).assign - solutionList.get(j - 1).assign)/(biggest.assign - smallest.assign);

		}

		solutionList = sort(solutionList, 3);
		 smallest = solutionList.get(0);
		 biggest = solutionList.get(39);

		for (int j = 1; j < 39; j++) {
			solutionList.get(j).distance += (solutionList.get(j + 1).experience - solutionList.get(j - 1).experience)/(biggest.experience - smallest.experience);

		}
		return solutionList;
	}

	public static List<Solution> sort(List<Solution> solutionList, int flag) {

		if (flag == 1) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40 - i - 1; j++) {
					if (solutionList.get(j).duration > solutionList.get(j+1).duration) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Duration");
		} else if (flag == 2) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40 - i - 1; j++) {
					if (solutionList.get(j).assign > solutionList.get(j+1).assign) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Assignment");

		} else if (flag == 3) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40 - i - 1; j++) {
					if (solutionList.get(j).experience > solutionList.get(j+1).experience) {
						Solution tmp = solutionList.get(j);
						solutionList.set(j, solutionList.get(j+1));
						solutionList.set(j + 1, tmp);
					}
				}
			}
			System.out.println("Experience");
		} else if (flag == 4) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40 - i - 1; j++) {
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
