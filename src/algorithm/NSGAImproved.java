package algorithm;

import common.Common;
import entity.Task;
import entity.Vertice;
import entity.pool.TaskPool;
import entity.population.Population;

import java.util.List;

public class NSGAImproved extends NSGA {

	@Override
	public void init() {
		this.population = new Population();
		for (int i = 1; i <= Common.numOfPopulation; i++) {
			Vertice vertices = new Vertice();
			this.population.getVerticeList().add(initElement(TaskPool.maxDuration * i / Common.numOfPopulation, vertices));
		}
	}


	/**
	 * Initialize the individuals
	 */
	public Vertice initElement(double k, Vertice vertices) {

		List<Task> taskList = vertices.getTaskList();
		List<List<Integer>> taskResourceList = vertices.getTaskResourceList();

		for (Task task : taskList) {
			List<Task> predecessors = task.getPredecessors();
			List<Integer> taskResource = taskResourceList.get(taskList.indexOf(task));

			for (Task tj : predecessors) {
				double start = Math.max(task.getStart(), tj.getStart() + tj.getDuration());
				task.setStart(start);
				int rand = (int) Math.floor(Math.random() * k);
				task.setScheduledTime(start + rand);

			}

			for (int j = 0; j < Common.numOfResources; j++) {

				if (Common.isUseful[task.getId()][j] == 0) {
					taskResource.set(j, 0);
				} else {
					double rand = Math.random();
					taskResource.set(j, rand >= 0.5 ? 1 : 0);
//					if (assign[j] == 1) {
//						task.setNumbOfAssigned(task.getNumbOfAssigned() + 1);
//					}
				}
			}
		}

		vertices.setDuration();
		vertices.setExperience();
		vertices.setAssign();
		return vertices;
	}

	@Override
	public void crossover() {
		for (int i = 0; i < Common.parentPoolSize / 2; i++) {
			int first = (int) Math.ceil(Math.random() * Common.numOfPopulation / 2);
			int second = (int) Math.ceil(Math.random() * Common.numOfPopulation / 2);
			if (first != second) {
				crossover(this.population.getVerticeList().get(first), this.population.getVerticeList().get(first));
			} else {
				i--;
			}
		}
	}

	public void crossover(Vertice a, Vertice b) {
		int pos1, pos2, begin, end;
		do {
			pos1 = (int) Math.floor(Math.random() * Common.numOfTasks);
			pos2 = (int) Math.floor(Math.random() * Common.numOfTasks);
		} while (pos1 == pos2);

		if (pos1 > pos2) {
			begin = pos2;
			end = pos1;
		} else {
			begin = pos1;
			end = pos2;
		}
		List<Task> taskList1 = a.getTaskList();
		List<Task> taskList2 = b.getTaskList();

		for (int i = begin; i < end; i++) {
			Task t1 = taskList1.get(i);
			Task t2 = taskList2.get(i);

			double dif = t1.getStart() - t2.getStart();

			if (dif < 0) {
				t1.setStart(t1.getStart() + dif * 0.1);
				t2.setStart(t2.getStart() - dif * 0.1);
			} else {
				t1.setStart(t1.getStart() - dif * 0.1);
				t2.setStart(t2.getStart() + dif * 0.1);
			}
		}
	}
}
