package algorithm;

import entity.Task;
import entity.Vertice;
import entity.pool.TaskPool;
import entity.population.Population;
import common.Common;

import java.util.List;

public class NSGA extends Algorithm{

	protected Population population;

	@Override
	public void execute() {
		this.init();
		this.calculateRank(this.population);
		this.calculateDistance(this.population);
		this.createOffspring();
		this.crossover();
		this.getPopulation();
		this.display();
	}

	public void init() {
		this.population = new Population();

		for (int i = 1; i <= Common.numOfPopulation; i++) {

			Vertice vertices = new Vertice();
			List<Task> taskList = vertices.getTaskList();
			List<List<Integer>> taskResourceList = vertices.getTaskResourceList();

			double k = TaskPool.maxDuration *i/Common.numOfPopulation;

			for (Task task: taskList) {
				int operator = Math.random() >= 0.5 ? 1 : 0;
				if(operator == 1) {
					task.setStart(task.getScheduledTime() + (int) Math.floor(Math.random()*k));
				} else {
					task.setStart(task.getScheduledTime() - (int) Math.floor(Math.random()*k));
				}

				List<Integer> taskResource = taskResourceList.get(taskList.indexOf(task));

				for (int j = 0; j < Common.numOfResources; j++) {
					int rand = Math.random() >= 0.5 ? 1 : 0;
					taskResource.set(j, rand);
				}
			}
			vertices.setDuration();
			vertices.setAssign();
			vertices.setExperience();
			this.population.getVerticeList().add(vertices);
		}
	}

	public void crossover() {

	}

	public void calculateRank(Population population) {

	}

	public void calculateDistance(Population population) {

	}

	public void display() {

	}

	public void createOffspring() {

	}

	public List<Vertice> getPopulation() {
		return null;
	}
}
