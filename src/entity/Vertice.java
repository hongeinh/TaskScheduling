package entity;


import common.Common;
import entity.pool.TaskPool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertice implements Comparable {

	/**
	 * Set of tasks
	 * */
	private List<Task> taskList = new ArrayList<Task>();

	/**
	 * Set of vectors of resource assignment that corresponds to the @taskList above.
	 * Each element is an array of size Common.numOfResource to indicate the resource assignment for the task.
	 * */
	private List<List<Integer>> taskResourceList;

	/**
	 * Objectives
	 * */
	private double duration;

	private double assignment;

	private double experience;

	/**
	 * For sorting purpose
	 * */
	private int rank;

	private double distance;

	public Vertice() {
		Task t1 = TaskPool.getPool().getTask(1);
		Task t2 = TaskPool.getPool().getTask(2);
		Task t3 = TaskPool.getPool().getTask(3);
		Task t4 = TaskPool.getPool().getTask(4);
		Task t5 = TaskPool.getPool().getTask(5);
		Task t6 = TaskPool.getPool().getTask(6);
		Task t7 = TaskPool.getPool().getTask(7);
		Task t8 = TaskPool.getPool().getTask(8);
		Task t9 = TaskPool.getPool().getTask(9);
		Task t10 = TaskPool.getPool().getTask(10);
		Task t11 = TaskPool.getPool().getTask(11);
		Task t12 = TaskPool.getPool().getTask(12);

		taskList.add(t2);
		taskList.add(t3);
		taskList.add(t6);
		taskList.add(t10);
		taskList.add(t12);
		taskList.add(t1);
		taskList.add(t9);
		taskList.add(t4);
		taskList.add(t7);
		taskList.add(t5);
		taskList.add(t8);
		taskList.add(t11);

		this.taskResourceList = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < Common.numOfResources; i++) {
			temp.add(0);
		}
		for (int i = 0; i < Common.numOfTasks; i++) {
			taskResourceList.add(temp.stream().collect(Collectors.toList()));
		}
	}


	public void setDuration() {
		double duration = 0;
		for (Task task : this.taskList) {
			double idle = task.getScheduledTime() - task.getStart();
			idle = idle < 0 ? 0 : (1 / (1 + idle));
			duration += idle;
		}
		this.duration = duration / Common.numOfTasks;
	}


	public void setExperience() {
//		double treq = 0;
//		for (Task task : this.taskList) {
//			for (int i = 0; i < Common.numOfSkills; i++) {
//				if (old.Common.treq[task.getId() - 1][i] == 1) {
//					treq = getMaxExpOfSkill(i) + getSumExpOfSkill(i) / task.getNumbOfAssigned();
//				}
//			}
//		}
//		treq /= old.Common.numberOfSkills;
//		this.experience = treq / old.Common.numberOfTasks;

		double treq = 0;
		for (Task task: this.taskList) {
			double treqi = 0;
			int sz = task.getTreq().size();
			for (int i = 0; i < sz; i++) {
				treqi =  task.getTreq().get(i).getMaxSkill();
			}
		}
	}


	// pending
	public void setAssign() {
		this.assignment = 0;
	}

	public double getDuration() {
		return duration;
	}

	public double getAssignment() {
		return assignment;
	}

	public double getExperience() {
		return experience;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<List<Integer>> getTaskResourceList() {
		return taskResourceList;
	}

	public void setTaskResourceList(List<List<Integer>> taskResourceList) {
		this.taskResourceList = taskResourceList;
	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Vertice) {
			Vertice v = (Vertice) o;
			if (this.getDuration() < v.getDuration() && this.getExperience() > v.getExperience() && this.getAssignment() > v.getAssignment()) {
				return 1;
			} else if (this.getDuration() > v.getDuration() && this.getExperience() < v.getExperience() && this.getAssignment() < v.getAssignment()) {
				return -1;
			} else return 0;
		} else return -1;
	}
}
